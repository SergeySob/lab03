package com.sobolev.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spFrom = findViewById(R.id.spinnerFrom);
        spTo = findViewById(R.id.spinnerTo);
        etFrom = findViewById(R.id.fromttxt);
        tvTo = findViewById(R.id.totxt);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;
    public void convert(View v)
    {
        Double from = 0d;
        try
        {
            from = Double.parseDouble(etFrom.getText().toString());
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(this, "Некорректное число", Toast.LENGTH_SHORT).show();
            return;
        }


        String stFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        Double to = 0.0d;

        Double coefficient = 0d;


        switch (stFrom)
        {
            case "mm":
                switch (sTo)
                {
                    case "mm":
                        coefficient = 1.0d;
                        break;
                    case "cm":
                        coefficient = 0.1d;
                        break;
                    case "m":
                        coefficient = 0.001d;
                        break;
                    case "km":
                        coefficient = 0.000001d;
                        break;
                }
                to = from * coefficient;
                break;

            case "cm":
                switch (sTo)
                {
                    case "mm":
                        coefficient = 10.0d;
                        break;
                    case "cm":
                        coefficient = 1.0d;
                        break;
                    case "m":
                        coefficient = 0.01d;
                        break;
                    case "km":
                        coefficient = 0.00001d;
                        break;
                }
                to = from * coefficient;
                break;

            case "m":
                switch (sTo)
                {
                    case "mm":
                        coefficient = 1000.0d;
                        break;
                    case "cm":
                        coefficient = 100.0d;
                        break;
                    case "m":
                        coefficient = 1.0d;
                        break;
                    case "km":
                        coefficient = 0.001d;
                        break;
                }
                to = from * coefficient;
                break;

            case "km":
                switch (sTo)
                {
                    case "mm":
                        coefficient = 1000000.0d;
                        break;
                    case "cm":
                        coefficient = 100000.0d;
                        break;
                    case "m":
                        coefficient = 1000.0d;
                        break;
                    case "km":
                        coefficient = 1.d;
                        break;
                }
                to = from * coefficient;
                break;
        }

        tvTo.setText(String.valueOf(to));
    }
}
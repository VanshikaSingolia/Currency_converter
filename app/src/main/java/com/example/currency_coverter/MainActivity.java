package com.example.currency_coverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    //private float rup = 0;
    //private float result;
    private EditText rup;
    private TextView result1;
    private converter con;
    Spinner spinner;
    double rupp;
    ArrayAdapter <CharSequence>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con = new converter();
        result1 = findViewById(R.id.text);
        rup = findViewById(R.id.text1);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.shortcuts,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "  selected", Toast.LENGTH_LONG).show();
                String result;
                if(rup.getText().toString().length()>0)
                rupp = Double.parseDouble(rup.getText().toString());
                switch (position) {
                    case 1:
                        result = String.valueOf(
                                con.USDD(rupp));
                        result1.setText(result);
                        break;
                    case 2:
                        result = String.valueOf(
                                con.EURO(rupp));
                        result1.setText(result);
                        break;
                    case 3:
                        result = String.valueOf(
                                con.POUND(rupp));
                        result1.setText(result);
                        break;
                    case 4:
                        result = String.valueOf(
                                con.UAED(rupp));
                        result1.setText(result);
                        break;
                    case 5:
                        result = String.valueOf(
                                con.YEN(rupp));
                        result1.setText(result);
                        break;

                    default:
                        result = getString(R.string.computationError);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }}

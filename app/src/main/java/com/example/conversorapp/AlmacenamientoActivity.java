package com.example.conversorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AlmacenamientoActivity extends AppCompatActivity {
    public Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacenamiento);
        btnCalcular = (Button)findViewById(R.id.btnConvertir);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar(view);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void procesar(View view) {
        try {
            RadioGroup optOperaciones = (RadioGroup) findViewById(R.id.optAlmacenamiento);
            TextView tempVal = (TextView) findViewById(R.id.txtnum1);
            double num1 = Double.parseDouble(tempVal.getText().toString());
            double respuesta = 0;
            switch (optOperaciones.getCheckedRadioButtonId()) {
                case R.id.optBit:
                    respuesta = num1 * 8388608;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Bits" );
                    break;
                case R.id.optByte:
                    respuesta = num1 * 1048576;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Bytes" );
                    break;
                case R.id.optKilobyte:
                    respuesta = num1 * 1024;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Kilobytes" );
                    break;
                case R.id.optGigabyte:
                    respuesta = num1 * 0.000976563;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Gigabytes" );

                    break;
                case R.id.optTerabyte:
                    respuesta = num1 * 0.000000953674;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Terabytes" );
                    break;
            }

            Toast.makeText(getApplicationContext(),"EXITO ",Toast.LENGTH_LONG).show();
        }catch (Exception err){
            TextView temp = (TextView) findViewById(R.id.lblRespuesta);
            temp.setText("INGRESE CANTIDAD");

            Toast.makeText(getApplicationContext(),"INGRESE CANTIDAD",Toast.LENGTH_LONG).show();
        }
    }
}
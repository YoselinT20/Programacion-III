package com.example.conversorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MasaActivity extends AppCompatActivity {

    public Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa2);
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
            RadioGroup optOperaciones = (RadioGroup) findViewById(R.id.optMasa);
            TextView tempVal = (TextView) findViewById(R.id.txtnum1);
            double num1 = Double.parseDouble(tempVal.getText().toString());
            double respuesta = 0;
            switch (optOperaciones.getCheckedRadioButtonId()) {
                case R.id.optGramo:
                    respuesta = num1 * 453.59;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Gramos" );
                    break;
                case R.id.optKilogramo:
                    respuesta = num1 * 0.45;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Kilogramos" );
                    break;
                case R.id.optQuintal:
                    respuesta = num1 * 0.01;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Quintal" );
                    break;
                case R.id.optOnza:
                    respuesta = num1 * 16;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Onzas" );
                    break;
                case R.id.optTonelada:
                    respuesta = num1 * 0.000453;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Toneladas" );
                    break;
            }
            Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
        }catch (Exception err){
            TextView temp = (TextView) findViewById(R.id.lblRespuesta);
            temp.setText("INGRESE CANTIDAD");
            Toast.makeText(getApplicationContext(),"INGRESE CANTIDAD",Toast.LENGTH_LONG).show();
        }
    }
}
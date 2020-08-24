package com.example.conversorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TiempoActivity extends AppCompatActivity {
    public Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);
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
            RadioGroup optOperaciones = (RadioGroup) findViewById(R.id.optTiempo);
            TextView tempVal = (TextView) findViewById(R.id.txtnum1);
            double num1 = Double.parseDouble(tempVal.getText().toString());
            double respuesta = 0;
            switch (optOperaciones.getCheckedRadioButtonId()) {
                case R.id.optMilisegundo:
                    respuesta = num1 * 3600000;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Milisegundos" );
                    break;
                case R.id.optSegundo:
                    respuesta = num1 * 3600;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Segundos" );
                    break;
                case R.id.optMinuto:
                    respuesta = num1 * 60;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Minutos" );
                    break;
                case R.id.optDia:
                    respuesta = num1 / 24;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " de Dia" );
                    break;
                case R.id.optSemana:
                    respuesta = num1 / 168;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " de Semana" );
                    break;
                case R.id.optMes:
                    respuesta = num1 / 730;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " de Mes" );
                    break;
                case R.id.optAño:
                    respuesta = num1 / 8760;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " de Año" );
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
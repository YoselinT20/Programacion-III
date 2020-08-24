package com.example.conversorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LongitudActivity extends AppCompatActivity {
    public Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud);
        btnCalcular = (Button)findViewById(R.id.btnConvertir);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar(view);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void procesar(View vista){
        try {
            Spinner cboOperaciones = (Spinner)findViewById(R.id.cboOperaciones);
            TextView tempVal = (TextView) findViewById(R.id.txtnum1);
            double num1 = Double.parseDouble(tempVal.getText().toString());
            double respuesta = 0;
            switch (cboOperaciones.getSelectedItemPosition()){
                case 1: //Kilometro
                    respuesta = num1 * 0.001;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Kilometros" );
                    Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
                    break;
                case 2: //Centimetro
                    respuesta = num1 * 100;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Centimetros" );
                    Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
                    break;
                case 3: //milimetro
                    respuesta = num1 * 1000;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Milimetros" );
                    Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
                    break;
                case 4: //milla
                    respuesta = num1 / 1609;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Millas" );
                    Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
                    break;
                case 5: //yarda
                    respuesta = num1 * 1.094;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Yardas" );
                    Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
                    break;
                case 6: //pie
                    respuesta = num1 * 3.281;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Pies" );
                    Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
                    break;
                case 7: //pulgada
                    respuesta = num1 * 39.37;
                    tempVal = (TextView) findViewById(R.id.lblRespuesta);
                    tempVal.setText("El total es" + respuesta + " Pulgadas" );
                    Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();
                    break;
            }
        }catch (Exception err){
            TextView temp = (TextView) findViewById(R.id.lblRespuesta);
            temp.setText("INGRESE CANTIDAD");
            Toast.makeText(getApplicationContext(),"INGRESE CANTIDAD",Toast.LENGTH_LONG).show();
        }
    }
}
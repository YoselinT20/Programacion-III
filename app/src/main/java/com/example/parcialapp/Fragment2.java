package com.example.parcialapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {

    public Button btnCalcular;
    public RadioGroup optOperaciones;
    public TextView tempVal,temp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2, container, false);

        optOperaciones = (RadioGroup) view.findViewById(R.id.optMonedas);
        tempVal = (TextView) view.findViewById(R.id.txtnum1);
        temp = (TextView) view.findViewById(R.id.lblRespuesta);

        btnCalcular = (Button)view.findViewById(R.id.btnConvertir);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num1 = Double.parseDouble(tempVal.getText().toString());
                    double respuesta = 0;
                    //Este es para el radiogroup y los radiobuttons
                    switch (optOperaciones.getCheckedRadioButtonId()) {
                        case R.id.optPie:
                            respuesta = num1 * 10.7639;
                            temp.setText("EL TOTAL ES" + respuesta + " Pies Cuadrados" );
                            break;
                        case R.id.optVara:
                            respuesta = num1 * 1.4308;
                            temp.setText("EL TOTAL ES" + respuesta + " Varas Cuadrados" );
                            break;
                        case R.id.optYarda:
                            respuesta = num1 * 1.196;
                            temp.setText("EL TOTAL ES" + respuesta + " Yardas Cuadradas" );
                            break;
                        case R.id.optTareas:
                            respuesta = num1 / 628.8;
                            temp.setText("EL TOTAL ES" + respuesta + " Tareas" );
                            break;
                        case R.id.optManzana:
                            respuesta = num1 * 0.0001431;
                            temp.setText("EL TOTAL ES" + respuesta + " Manzanas" );
                            break;
                        case R.id.optHectareas:
                            respuesta = num1 * 0.0001;
                            temp.setText("EL TOTAL ES" + respuesta + " Hectareas" );
                            break;
                    }

                    Toast.makeText(getContext(),"EXITO",Toast.LENGTH_SHORT).show();
                }catch (Exception err){
                    temp.setText("Ingrese la cantidad de Metros");
                    Toast.makeText(getContext(),"Ingrese la cantidad",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
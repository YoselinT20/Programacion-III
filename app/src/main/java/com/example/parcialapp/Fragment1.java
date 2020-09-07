package com.example.parcialapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    public Button btnCalcular;
    public Spinner optOperaciones,optOperaciones2;
    public TextView tempVal,temp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        optOperaciones = (Spinner) view.findViewById(R.id.cboOperaciones);
        optOperaciones2 = (Spinner) view.findViewById(R.id.cboOperaciones2);
        tempVal = (TextView) view.findViewById(R.id.txtnum1);
        temp = (TextView) view.findViewById(R.id.lblRespuesta);

        btnCalcular = (Button)view.findViewById(R.id.btnConvertir);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num1 = Double.parseDouble(tempVal.getText().toString());
                    double respuesta = 0;

                    switch (optOperaciones.getSelectedItemPosition()){
                        case 0: //ninguno
                            temp.setText("Conversion inicial");
                            break;
                        case 1: //Caja
                            if (optOperaciones2.getSelectedItemPosition() == 0){
                                temp.setText("Conversion Final");
                            } else if (optOperaciones2.getSelectedItemPosition() == 1) {
                                respuesta = num1 * 1;
                                temp.setText("EL TOTAL ES" + respuesta + " Cajas");
                            } else {
                                respuesta = num1 * 25;
                                temp.setText("EL TOTAL ES" + respuesta + " Unidades");}
                            break;
                        case 2: //Unidad
                            if (optOperaciones2.getSelectedItemPosition() == 0){
                                temp.setText("Conversion Final");
                            } else if (optOperaciones2.getSelectedItemPosition() == 1) {
                                respuesta = num1 / 25 ;
                                temp.setText("EL TOTAL ES" + respuesta + " Cajas");
                            } else {
                                respuesta = num1 * 1 ;
                                temp.setText("EL TOTAL ES" + respuesta + " Unidades");}
                            break;
                    }


                }catch (Exception err){
                    temp.setText("Ingrese la cantidad a Convertir");
                    Toast.makeText(getContext(),"Ingrese la cantidad",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
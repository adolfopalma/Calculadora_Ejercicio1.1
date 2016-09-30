package com.example.adolfo.calculadora_ejercicio11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

        TextView pantalla, pantallaPeque;
        String resultado;
        String res;
        double resu = 0;
        String signoAnterior;
        double memoria = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        pantalla = (TextView) findViewById(R.id.tv);
        pantallaPeque = (TextView) findViewById(R.id.tvPeque);

    }

    public void pulsado(View view) {

        TextView tv2 = (TextView) findViewById(view.getId());



        if (pantalla.getText().toString().equals("0")) {
            pantalla.setText("");
            pantalla.append(tv2.getText());

        } else if (tv2.getText().toString().equals("C")) {
                    pantalla.setText("0");
                    pantallaPeque.setText("0");
                    resu = 0;
                }else
                    pantalla.append(tv2.getText());

    }

    public void leerSigno(View view){
        TextView tvSigno = (TextView) findViewById(view.getId());

        Button b = (Button) view;
        String s = b.getText()+"";

        if(s.equals("+")){
            if(pantalla.getText().toString() == ""){
                pantalla.setText("");
            }else{
                signoAnterior = "+";
                res = pantalla.getText().toString();
                pantalla.setText("");
                resu = resu + Double.parseDouble(res);
            }
        }


        if(s.equals("-")){
            if(pantalla.getText().toString() == ""){
                pantalla.setText("");

            }else{
                signoAnterior = "-";
                res = pantalla.getText().toString();
                pantalla.setText("");
                    if(Double.parseDouble(res)<0)
                        resu = resu - Double.parseDouble(res);
                    if(resu>=0)
                        resu = resu + Double.parseDouble(res);
            }
        }

        if(s.equals("X")){
            if(pantalla.getText().toString() == ""){
                pantalla.setText("");
            }else {
                signoAnterior = "X";
                res = pantalla.getText().toString();
                pantalla.setText("");
                resu = resu + Double.parseDouble(res);
            }
        }

        if(s.equals("/")){
            if(pantalla.getText().toString() == ""){
                pantalla.setText("");
            }else {
                signoAnterior = "/";
                res = pantalla.getText().toString();
                pantalla.setText("");
                resu = resu + Double.parseDouble(res);
            }
        }

        if (s.equals(",")) {
            pantalla.append(".");
        }

        if (s.equals("MS")) {
            memoria = Double.parseDouble(pantalla.getText().toString());
            pantalla.setText("");
            pantallaPeque.setText(""+memoria);
        }

        if (s.equals("MC")) {
            pantallaPeque.setText("");
        }

        if (s.equals("MR")) {
            pantalla.setText(""+memoria);
            pantallaPeque.setText("");
        }


        if(s.equals("=")){
                if(signoAnterior =="+") {
                    resu = resu + Double.parseDouble(pantalla.getText().toString());
                    resultado = Double.toString(resu);
                    pantalla.setText(resultado);
                    resu = 0;
                }

                if(signoAnterior =="X") {
                    resu = resu * Double.parseDouble(pantalla.getText().toString());
                    resultado = Double.toString(resu);
                    pantalla.setText(resultado);
                    resu = 0;
                }

                if(signoAnterior =="/") {
                    resu = resu / Double.parseDouble(pantalla.getText().toString());
                    resultado = Double.toString(resu);
                    pantalla.setText(resultado);
                    resu = 0;
                }

                if(signoAnterior =="-") {
                    resu = resu - Double.parseDouble(pantalla.getText().toString());
                    resultado = Double.toString(resu);
                    pantalla.setText(resultado);
                    resu = 0;
                }
        }
    }
}


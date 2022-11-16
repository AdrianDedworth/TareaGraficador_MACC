package com.example.tareagraficador_macc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBtnBlack, imgBtnGreen, imgBtnYellow, imgBtnBlue, imgBtnRed;
    private Lienzo lienzo;

    float brSmall = 10, brMedium = 20, brBig = 30;
    ImageButton imgBtnBrushSize, imgBtnNewDraw, imgBtnErase, imgBtnSaveDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //botones inferior
        imgBtnBlack = findViewById(R.id.imgBtnBlack);
        imgBtnGreen = findViewById(R.id.imgBtnGreen);
        imgBtnYellow = findViewById(R.id.imgBtnYellow);
        imgBtnBlue = findViewById(R.id.imgBtnBlue);
        imgBtnRed = findViewById(R.id.imgBtnRed);
        //botones superior
        imgBtnBrushSize = findViewById(R.id.imgBtnBrushSize);
        imgBtnNewDraw = findViewById(R.id.imgBtnNewDraw);
        imgBtnErase = findViewById(R.id.imgBtnErase);
        imgBtnSaveDraw = findViewById(R.id.imgBtnSaveDraw);

        imgBtnBlack.setOnClickListener(this);
        imgBtnGreen.setOnClickListener(this);
        imgBtnYellow.setOnClickListener(this);
        imgBtnBlue.setOnClickListener(this);
        imgBtnRed.setOnClickListener(this);

        imgBtnBrushSize.setOnClickListener(this);
        imgBtnNewDraw.setOnClickListener(this);
        imgBtnErase.setOnClickListener(this);
        imgBtnSaveDraw.setOnClickListener(this);


        lienzo = (Lienzo) findViewById(R.id.lienzo);
    }


    @Override
    public void onClick(View view) {
        String color = null;
        switch (view.getId()){
            case R.id.imgBtnBlack:{
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;
            }
            case R.id.imgBtnGreen:{
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;
            }
            case R.id.imgBtnYellow:{
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;
            }
            case R.id.imgBtnBlue:{
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;
            }
            case R.id.imgBtnRed:{
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;
            }
            case R.id.imgBtnBrushSize:{
                final Dialog grosorTrazo = new Dialog(this);
                grosorTrazo.setTitle("Grosor de pincel: ");
                grosorTrazo.setContentView(R.layout.grosor_trazo);
                TextView txtSmall = (TextView) grosorTrazo.findViewById(R.id.txtSmall);
                TextView txtMedium = (TextView) grosorTrazo.findViewById(R.id.txtSmall);
                TextView txtBig = (TextView) grosorTrazo.findViewById(R.id.txtSmall);

                //eventos de click para las opciones de grosor
                txtSmall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBrushSize(brSmall);
                        grosorTrazo.dismiss();
                    }
                });
                txtMedium.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBrushSize(brMedium);
                        grosorTrazo.dismiss();
                    }
                });
                txtBig.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBrushSize(brBig);
                        grosorTrazo.dismiss();
                    }
                });
                break;
            }
            case R.id.imgBtnNewDraw:{

                break;
            }
            case R.id.imgBtnErase:{

                break;
            }
            case R.id.imgBtnSaveDraw:{

                break;
            }
        }

    }
}
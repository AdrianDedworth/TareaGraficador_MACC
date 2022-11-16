package com.example.tareagraficador_macc;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBtnBlack, imgBtnGreen, imgBtnYellow, imgBtnBlue, imgBtnRed;
    private Lienzo lienzo;

    float brSmall, brMedium, brBig;
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

        brSmall = 10;
        brMedium = 20;
        brBig = 40;
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
                grosorTrazo.setContentView(R.layout.grosor_trazo);
                grosorTrazo.show();
                TextView txtSmall = (TextView) grosorTrazo.findViewById(R.id.txtSmall);
                TextView txtMedium = (TextView) grosorTrazo.findViewById(R.id.txtMedium);
                TextView txtBig = (TextView) grosorTrazo.findViewById(R.id.txtBig);

                //eventos de click para las opciones de grosor
                txtSmall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setErase(false);
                        Lienzo.setBrushSize(brSmall);
                        grosorTrazo.dismiss();
                    }
                });
                txtMedium.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setErase(false);
                        Lienzo.setBrushSize(brMedium);
                        grosorTrazo.dismiss();
                    }
                });
                txtBig.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setErase(false);
                        Lienzo.setBrushSize(brBig);
                        grosorTrazo.dismiss();
                    }
                });
                break;
            }
            case R.id.imgBtnNewDraw:{
                AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
                newDialog.setTitle("Nuevo Dibujo");
                newDialog.setMessage("¿Hacer Nuevo Dibujo?\n(No se guardara el dibujo anterior)");
                newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                lienzo.newDraw();
                                dialog.dismiss();
                            }
                });
                newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                newDialog.show();
                break;
            }
            case R.id.imgBtnErase:{
                final Dialog grosorPunto = new Dialog(this);
                grosorPunto.setContentView(R.layout.grosor_trazo);
                grosorPunto.show();
                TextView txtSmallborrar = (TextView) grosorPunto.findViewById(R.id.txtSmall);
                TextView txtMediumborrar = (TextView) grosorPunto.findViewById(R.id.txtMedium);
                TextView txtBigborrar = (TextView) grosorPunto.findViewById(R.id.txtBig);

                //eventos de click para las opciones de grosor
                txtSmallborrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setErase(true);
                        Lienzo.setBrushSize(brSmall);
                        grosorPunto.dismiss();
                    }
                });
                txtMediumborrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setErase(true);
                        Lienzo.setBrushSize(brMedium);
                        grosorPunto.dismiss();
                    }
                });
                txtBigborrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setErase(true);
                        Lienzo.setBrushSize(brBig);
                        grosorPunto.dismiss();
                    }
                });
                break;
            }
            case R.id.imgBtnSaveDraw:{
                AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
                newDialog.setTitle("Guardar Dibujo");
                newDialog.setMessage("¿Guardar Dibujo en la Galería?");
                newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lienzo.setDrawingCacheEnabled(true);
                        String imgSaved = MediaStore.Images.Media.insertImage(
                                getContentResolver(), lienzo.getDrawingCache(),
                                UUID.randomUUID().toString(), "drawing");

                        if (imgSaved != null){
                            Toast savedToast = Toast.makeText(getApplicationContext(), "Dibujo Guardado", Toast.LENGTH_SHORT);

                            savedToast.show();
                        }else{
                            Toast unSavedToast = Toast.makeText(getApplicationContext(), "No Se Guardo El Dibujo", Toast.LENGTH_SHORT);

                            unSavedToast.show();
                        }
                        lienzo.destroyDrawingCache();
                    }
                });
                newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                newDialog.show();
                break;
            }
        }

    }
}
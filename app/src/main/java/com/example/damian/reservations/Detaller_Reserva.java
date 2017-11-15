package com.example.damian.reservations;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detaller_Reserva extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Cancha_Reserva p;
    private String id;
    private Bundle bundle;
    private TextView cancha,direccion,celular,fecha,hora;
    private Intent i;
    private int fot;
    private ImageView foto;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaller__reserva);
        res = this.getResources();
        collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbard);
       // foto = (ImageView) findViewById(R.id.fotocarro);
        cancha = (TextView) findViewById(R.id.txtd_cancha);
        direccion = (TextView) findViewById(R.id.txtd_direccion);
        celular = (TextView) findViewById(R.id.txtd_celular);
        fecha = (TextView) findViewById(R.id.txtd_fecha);
        hora = (TextView) findViewById(R.id.txtd_hora);
        i = getIntent();
        bundle = i.getBundleExtra("datos");
        //fot = bundle.getInt("foto");
        id=bundle.getString("id");
        ArrayList<Integer> h =bundle.getIntegerArrayList("hora");
        cancha.setText(cancha.getText()+": "+bundle.getString("cancha"));
        direccion.setText(direccion.getText()+": "+bundle.getString("direccion"));
        celular.setText(celular.getText()+": "+bundle.getString("celular"));
        fecha.setText(fecha.getText()+": "+bundle.getString("fecha"));
        hora.setText(hora.getText()+": "+h.get(0)+" - "+(h.get(h.size()-1)+1));
        //foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));
        collapsingToolbarLayout.setTitle(bundle.getString("establecimiento"));


    }
    public  void Cancelar(View v){

        String positivo,negativo;

        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_cancelar));
        builder.setMessage(res.getString(R.string.texto_cancelar_reserva));
        positivo = res.getString(R.string.si_cancelar);
        negativo = res.getString(R.string.no_cancelar);



        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    Moldel_Reservas.Cancelarreserva(id);
                Intent si = new Intent(Detaller_Reserva.this,Principal.class);
                startActivity(si);
            }
        });
        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();



    }
}

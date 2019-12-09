package com.truco.truco;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNos, tvEles;
    Button btnMenos1Nos, btnMenos1Eles, btnMais1Nos, btnMais1Eles, btnMais3Nos, btnMais3Eles,
            btnMais6Nos, btnMais6Eles, btnMais9Nos, btnMais9eles, btnReiniciar;
    int iNos=0, iEles=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNos = findViewById(R.id.tvNos);
        tvEles = findViewById(R.id.tvEles);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        btnMenos1Nos = findViewById(R.id.btnMenos1Nos);
        btnMenos1Eles = findViewById(R.id.btnMenos1Eles);
        btnMais1Nos = findViewById(R.id.btnMais1Nos);
        btnMais1Eles = findViewById(R.id.btnMAis1Eles);
        btnMais3Nos = findViewById(R.id.btnMais3Nos);
        btnMais3Eles = findViewById(R.id.btnMais3Eles);
        btnMais6Nos = findViewById(R.id.btnMais6Nos);
        btnMais6Eles = findViewById(R.id.btnMais6Eles);
        btnMais9Nos = findViewById(R.id.btnMais9Nos);
        btnMais9eles = findViewById(R.id.btnMais9Eles);

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iNos=0;
                iEles=0;
                setaPonto();
                btnMenos1Nos.setEnabled(true);
                btnMenos1Eles.setEnabled(true);
                btnMais1Nos.setEnabled(true);
                btnMais1Eles.setEnabled(true);
                btnMais3Nos.setEnabled(true);
                btnMais3Eles.setEnabled(true);
                btnMais6Nos.setEnabled(true);
                btnMais6Eles.setEnabled(true);
                btnMais9Nos.setEnabled(true);
                btnMais9eles.setEnabled(true);
            }
        });
        btnMenos1Nos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iNos==0){
                    alertaErro();
                }else{
                    iNos--;
                    verificaOnze(iNos,0);
                    setaPonto();
                }
            }
        });
        btnMenos1Eles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iEles==0){
                    alertaErro();
                }else{
                    iEles--;
                    verificaOnze(iEles,1);
                    setaPonto();
                }
            }
        });
        btnMais1Nos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iNos++;
                verificaOnze(iNos,0);
                verificaVitoria(iNos,0);
                setaPonto();
            }
        });
        btnMais1Eles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iEles++;
                verificaOnze(iEles,1);
                verificaVitoria(iEles,1);
                setaPonto();
            }
        });
        btnMais3Nos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iNos+=3;
                verificaOnze(iNos,0);
                verificaVitoria(iNos,0);
                setaPonto();
            }
        });
        btnMais3Eles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iEles+=3;
                verificaOnze(iEles,1);
                verificaVitoria(iEles,1);
                setaPonto();
            }
        });
        btnMais6Nos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iNos+=6;
                verificaOnze(iNos,0);
                verificaVitoria(iNos,0);
                setaPonto();
            }
        });
        btnMais6Eles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iEles+=6;
                verificaOnze(iEles,1);
                verificaVitoria(iEles,1);
                setaPonto();
            }
        });
        btnMais9Nos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iNos+=9;
                verificaOnze(iNos,0);
                verificaVitoria(iNos,0);
                setaPonto();
            }
        });
        btnMais9eles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iEles+=9;
                verificaOnze(iEles,1);
                verificaVitoria(iEles,1);
                setaPonto();
            }
        });
    }

    public void alertaErro(){
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("AVISO");
        builder.setMessage("IMPOSSÍVEL RETIRAR PONTOS");
        alerta = builder.create();
        alerta.show();
    }
    public void verificaOnze(int iVerifica, int iTime){
        if(iVerifica==11){
            AlertDialog alerta;
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("AVISO");
            if (iTime==0){
                builder.setMessage("O NOSSO TIME ACABOU DE ENTRAR NA MÃO DE 11");
            }else{
                builder.setMessage("O TIME DELES ACABOU DE ENTRAR NA MÃO DE 11");
            }
            alerta = builder.create();
            alerta.show();
        }
    }
    public void verificaVitoria(int iVerifica, int iTime){
        if(iVerifica>=12){
            AlertDialog alerta;
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("AVISO");
            if (iTime==0){
                builder.setMessage("O NOSSO TIME VENCEU!!");
            }else {
                builder.setMessage("O TIME DELES VENCEUU!!");
            }
            alerta = builder.create();
            alerta.show();
            btnMenos1Nos.setEnabled(false);
            btnMenos1Eles.setEnabled(false);
            btnMais1Nos.setEnabled(false);
            btnMais1Eles.setEnabled(false);
            btnMais3Nos.setEnabled(false);
            btnMais3Eles.setEnabled(false);
            btnMais6Nos.setEnabled(false);
            btnMais6Eles.setEnabled(false);
            btnMais9Nos.setEnabled(false);
            btnMais9eles.setEnabled(false);
        }
    }
    public void setaPonto(){
        if (iNos<10){
            tvNos.setText("0"+iNos);
        }else{
            tvNos.setText(""+iNos);
        }
        if (iEles<10){
            tvEles.setText("0"+iEles);
        }else{
            tvEles.setText(""+iEles);
        }
    }
}

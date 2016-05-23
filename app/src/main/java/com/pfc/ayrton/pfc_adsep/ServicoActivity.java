package com.pfc.ayrton.pfc_adsep;

import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;

import java.util.ArrayList;

import bean.Estabelecimento;
import bean.EstabelecimentoServico;
import bean.Requisito;
import bean.Servico;
import layout.AFragment;
import lists.Listas;

public class ServicoActivity extends AppCompatActivity {
    TextView requisitos;
    TextView estabelecimentoMP;
    GPSTracker gps;
    ArrayList<Estabelecimento> EstabelecimentosDoServico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView descricao = (TextView) findViewById(R.id.descricao_servico);
        requisitos = (TextView) findViewById(R.id.requisitos);
        setTitle(Listas.servicos.get(Listas.servicoEscolhidoId).getNome());
        descricao.setText(Listas.servicos.get(Listas.servicoEscolhidoId).getDescricao());
        String req = getRequisitosDoServico(Listas.servicos.get(Listas.servicoEscolhidoId).getId());
        requisitos.setText(req);
        estabelecimentoMP= (TextView) findViewById(R.id.estabelecimentoMPTextView);
        estabelecimentoMP.setText(EstabelecimentosDoServico.get(0).getNome());





    }

    @Override
    protected void onStart() {
        super.onStart();
        //ver estabelecimento mais proximo no mapa!
        Button estabelecimentoMPButton= (Button) findViewById(R.id.estabelecimentoMPButton);
        estabelecimentoMPButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                FindNearestEstabelecimento(Listas.estabelecimentos);
                EstabelecimentoMapsActivity.estabelecimento=EstabelecimentosDoServico.get(0);
                Intent ne=new Intent(getApplicationContext(),EstabelecimentoMapsActivity.class);

                startActivity(ne);



            }
        });
    }


    public String getRequisitosDoServico(String idServico) {
        String req = new String();
        ArrayList<Requisito> requisitosDoServico = new ArrayList<Requisito>();
        //procurar ID dos requisitos
        for (int i = 0; i < Listas.servicoRequisitos.size(); i++) {

            if (Listas.servicoRequisitos.get(i).getServicoId().equalsIgnoreCase(idServico)) {
                for (int i2 = 0; i2 < Listas.requisitos.size(); i2++) {
                    if (Listas.requisitos.get(i2).getId().equalsIgnoreCase(Listas.servicoRequisitos.get(i).getRequisitoId())) {
                        requisitosDoServico.add(Listas.requisitos.get(i2));
                        Log.d("P.R.", "Apanhou " + i2);
                    }
                }

            }

            getEstabelecimentosDoServico(idServico);
        }
        //colocar os requisitos na string

        for (int i3 = 0; i3 < requisitosDoServico.size(); i3++) {

            if (i3==0) {
                req = "-" + requisitosDoServico.get(i3).getDescricao();
                Log.d("P.R.", "Chegou no String " + requisitosDoServico.get(i3).getDescricao() + "  req:" + req);

            } else {

                req = req + System.getProperty("line.separator") + "-" + requisitosDoServico.get(i3).getDescricao();

                Log.d("P.R.", "Chegou no String 2 " + requisitosDoServico.get(i3).getDescricao());


            }

        }
        Log.d("P.R.", "---" + req);


        return req;
    }

    public void getEstabelecimentosDoServico(String idServico) {
        String req = new String();
        EstabelecimentosDoServico = new ArrayList<Estabelecimento>();
        //procurar ID dos requisitos
        for (int i = 0; i < Listas.estabelecimentoServicos.size(); i++) {

            if (Listas.estabelecimentoServicos.get(i).getServico_id().equalsIgnoreCase(idServico)) {
                for (int i2 = 0; i2 < Listas.estabelecimentos.size(); i2++) {
                    if (Listas.estabelecimentos.get(i2).getId().equalsIgnoreCase(Listas.estabelecimentoServicos.get(i).getEstabelecimento_id())) {
                        EstabelecimentosDoServico.add(Listas.estabelecimentos.get(i2));
                        Log.d("Proc. Estblc.", "Apanhou " + i2);
                    }
                }

            }
        }



        Log.d("P.R.", "---" + req);



    }

    public void FindNearestEstabelecimento( ArrayList<Estabelecimento> EstabelecimentosDoServico){
       // Location current= new ;
        gps = new GPSTracker(ServicoActivity.this);

        // Check if GPS enabled
        if(gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        } else {
            // Can't get location.
            // GPS or network is not enabled.
            // Ask user to enable GPS/network in settings.
            gps.showSettingsAlert();
        }
    }

}


package com.pfc.ayrton.pfc_adsep;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import bean.Requisito;
import lists.Listas;

public class ServicoActivity extends AppCompatActivity {
    TextView requisitos;

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

        //  requisitos.setText();

    }

    @Override
    protected void onStart() {
        super.onStart();
        String req = getRequisitosDoServico(Listas.servicos.get(Listas.servicoEscolhidoId).getId());
        requisitos.setText(req);
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
}
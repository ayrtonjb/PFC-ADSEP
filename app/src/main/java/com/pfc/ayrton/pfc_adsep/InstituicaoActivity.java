package com.pfc.ayrton.pfc_adsep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bean.Instituicao;
import layout.TodosEstabelecimentosList;
import lists.Listas;

public class InstituicaoActivity extends AppCompatActivity {

    Instituicao instituicao;
    String instituicaoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instituicao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras=getIntent().getExtras();
        if(extras !=null){
            instituicaoID=extras.getString("instituicao_id");
        }

        instituicao=findInstituicao(instituicaoID);


        setTitle(instituicao.getNome());
        TextView descricaoInstituicao= (TextView) findViewById(R.id.descricao_instituicao);
        descricaoInstituicao.setText(instituicao.getDescricao());

        Button todosServicosDaInstituicao= (Button) findViewById(R.id.ver_todos_servicos_da_instituicao);
        todosServicosDaInstituicao.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent ne=new Intent(getApplicationContext(),Adapter_Todos_Servicos_list.class);

                startActivity(ne);



            }
        });

        Button todosEstabelecimentosInsituicaoButton= (Button) findViewById(R.id.todosEstabelecimentosInstituicaoButton);
        todosEstabelecimentosInsituicaoButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Listas.setTodosEstabelecimentosListcontroller("Servico");
                TodosEstabelecimentosList.setInstituicaoId(instituicaoID);
                TodosEstabelecimentosList.setServicoId("");
                Intent ne=new Intent(getApplicationContext(),Adapter_Todos_Estabelecimentos_list.class);

                startActivity(ne);



            }
        });
    }


    public Instituicao findInstituicao(String id){

        Instituicao instituicaoEscolhida=new Instituicao();
        for (int i2 = 0; i2 < Listas.instituicoes.size(); i2++) {
            if (Listas.instituicoes.get(i2).getId().equalsIgnoreCase(id)) {
                instituicaoEscolhida=Listas.instituicoes.get(i2);
               // ServicoPosition=i2;
                Log.d("Proc. Inst.", "Apanhou " + i2);
            }

        }
        return instituicaoEscolhida;
    }

}

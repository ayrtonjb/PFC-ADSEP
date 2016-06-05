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

import bean.ContactoEstabelecimento;
import bean.Estabelecimento;
import lists.Listas;

public class EstabelecimentoActivity extends AppCompatActivity {

    String estabelecimentoID;
    Estabelecimento estabelecimento;
    int estabelecimentoPosition;
    ContactoEstabelecimento contactoEstabelecimento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras=getIntent().getExtras();
        if(extras !=null){
            estabelecimentoID=extras.getString("estabelecimento_id");
            Log.d("recebe","EstabId: "+estabelecimentoID);
        }

        estabelecimento=findEstabelecimento(estabelecimentoID);
        contactoEstabelecimento=getContactInfo();
        setTitle(estabelecimento.getNome());
        TextView tipo= (TextView) findViewById(R.id.tipo_estabelecimento);
        TextView endereco= (TextView) findViewById(R.id.endereco_estabelecimento);
        TextView horarioAbertura= (TextView) findViewById(R.id.horario_abertura_estabelecimento);
        TextView horarioEncerremento= (TextView) findViewById(R.id.horario_encerramento_estabelecimento);
        TextView telefone= (TextView) findViewById(R.id.telefone_estabelecimento);
        TextView cel= (TextView) findViewById(R.id.cel_estabelecimento);
        TextView fax= (TextView) findViewById(R.id.fax_estabelecimento);
        TextView email= (TextView) findViewById(R.id.email_estabelecimento);

        tipo.setText(estabelecimento.getTipo());
        endereco.setText(estabelecimento.getEndereco());
        horarioAbertura.setText(estabelecimento.getHorario_abertura());
        horarioEncerremento.setText(estabelecimento.getHorario_encerramento());
        telefone.setText(contactoEstabelecimento.getTelefone());
        cel.setText(contactoEstabelecimento.getTelefone_movel());
        fax.setText(contactoEstabelecimento.getFax());
        email.setText(contactoEstabelecimento.getEmail());

        Button verNoMapa= (Button) findViewById(R.id.ver_no_mapa_estabelecimento);
        verNoMapa.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                EstabelecimentoMapsActivity.estabelecimento=estabelecimento;

                Intent ne=new Intent(getApplicationContext(),EstabelecimentoMapsActivity.class);

                startActivity(ne);



            }
        });

    }

    public ContactoEstabelecimento getContactInfo(){
        for(int i2=0;i2<Listas.contactoEstabelecimentos.size();i2++){
            if(Listas.contactoEstabelecimentos.get(i2).getId().equalsIgnoreCase(estabelecimento.getContacto_estabelecimento_id())){
                Log.d("C. info", "Apanhou os contactos do estabelecimento :");
                return Listas.contactoEstabelecimentos.get(i2);
            }
        }
        Log.d("C. info", "Nao Apanhou os contactos do estabelecimento :"+estabelecimento.getContacto_estabelecimento_id());
        return null;
    }

    public Estabelecimento findEstabelecimento(String id){
        Estabelecimento estabelecimentoEscolhido = new Estabelecimento();
        for (int i2 = 0; i2 < Listas.estabelecimentos.size(); i2++) {
            if (Listas.estabelecimentos.get(i2).getId().equalsIgnoreCase(id)) {
                estabelecimentoEscolhido=Listas.estabelecimentos.get(i2);
                estabelecimentoPosition=i2;
                Log.d("Proc. Estblc.", "Apanhou " + i2);
            }

        }


        return estabelecimentoEscolhido;
    }
}

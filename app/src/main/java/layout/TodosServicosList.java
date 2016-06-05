package layout;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.pfc.ayrton.pfc_adsep.EstabelecimentoActivity;
import com.pfc.ayrton.pfc_adsep.R;
import com.pfc.ayrton.pfc_adsep.ServicoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.Servico;
import lists.Listas;

public class TodosServicosList extends ListFragment {

    //String[] estabs={"Autenticar Copia de Documento","Reconhecer Assinatura","Traduzir Documento"};

    Integer[] Logo = {R.drawable.ic_servico_default_48dp};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Listas.setCurrentServicosList(getServicosDaInstituicaoEscolhida());
        // Inflate the layout for this fragment
        List<HashMap<String,String>> eList = new ArrayList<HashMap<String,String>>();
        // if(Listas.controllerServInst==1){
        for(int i=0;i<Listas.currentServicosList.size();i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            //hm.put("txt", estabelecimentosInsts.get(i).getNome());
            hm.put("txt", Listas.currentServicosList.get(i).getNome());
            hm.put("img", Integer.toString(Logo[0]));

            eList.add(hm);
        }


        // Keys used in Hashmap
        String[] from = { "img","txt"};

        // Ids of views in listview_layout
        int[] to = { R.id.img,R.id.txt};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), eList, R.layout.list_item, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                Listas.setServicoEscolhidoId(position);
                Intent ne=new Intent(getContext(), ServicoActivity.class);
                ne.putExtra("servico_id",Listas.currentServicosList.get(position).getId());
                startActivity(ne);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }


    public ArrayList<Servico> getServicosDaInstituicaoEscolhida(){
        String idIsntituicao=Listas.instituicoes.get(Listas.instituicaoEscolhidaId).getId();
        Log.d("Serv.:", "IdInstituicao "+idIsntituicao);

        ArrayList<Servico> ServicosDaInstituicaoEscolhida=new ArrayList<Servico>();
        //procurar ID dos servicos
        for(int i=0;i<Listas.instituicaoServicos.size();i++){

            if(Listas.instituicaoServicos.get(i).getInstituicaoId().equalsIgnoreCase(idIsntituicao)){
                for(int i2=0;i2<Listas.servicos.size();i2++){
                    if(Listas.servicos.get(i2).getId().equalsIgnoreCase(Listas.instituicaoServicos.get(i).getServicoID())){
                        ServicosDaInstituicaoEscolhida.add(Listas.servicos.get(i2));
                        Log.d("Serv.:", "Apanhou "+i2);
                    }
                }

            }
        }

        Log.d("P.R.","---"+ServicosDaInstituicaoEscolhida.toString());
        return ServicosDaInstituicaoEscolhida;
    }
}

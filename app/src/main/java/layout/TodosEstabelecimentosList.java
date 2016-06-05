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
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.pfc.ayrton.pfc_adsep.EstabelecimentoActivity;
import com.pfc.ayrton.pfc_adsep.R;
import com.pfc.ayrton.pfc_adsep.ServicoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.Estabelecimento;
import lists.Listas;

public class TodosEstabelecimentosList extends ListFragment {
//TODOS ESTABELECIMENTOS DA iNSTITUICAO ou Que prestam um servico

    static String ServicoId;
    static String InstituicaoId;

    public static void setServicoId(String servicoId) {
        ServicoId = servicoId;
    }

    public static void setInstituicaoId(String instituicaoId) {
        InstituicaoId = instituicaoId;
    }

    ArrayList<Estabelecimento> currentListEstab;

    ListView lista;
    //dummy
    //String[] estabs={"1o Cartorio Notarial","2o Cartorio Notarial","3o Cartorio Notarial"};

    Integer[] Logo = {R.drawable.ic_estabelecimento_default_48dp};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        List<HashMap<String,String>> eList = new ArrayList<HashMap<String,String>>();
       if(InstituicaoId.equalsIgnoreCase("")){

           currentListEstab=getEstabelecimentosDoServcoEscolhidoServico();
       }
        else {
           currentListEstab = getEstabelecimentosDaInstituicaoEscolhida();
        }

        for(int i=0;i<currentListEstab.size();i++) {
                HashMap<String, String> hm = new HashMap<String, String>();

                hm.put("txt", currentListEstab.get(i).getNome());
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

                    Listas.setEstabelecimentoEscolhidoID(position);
                    Listas.setCurrentEstabelecimentosList(currentListEstab);
                    Intent ne=new Intent(getContext(), EstabelecimentoActivity.class);
                    ne.putExtra("estabelecimento_id",currentListEstab.get(position).getId());
                    startActivity(ne);
                }
            });
            super.onViewCreated(view, savedInstanceState);
        }



    public ArrayList<Estabelecimento> getEstabelecimentosDoServcoEscolhidoServico(){
        String idServico=ServicoId;


        ArrayList<Estabelecimento> estabelecimentosDoServico=new ArrayList<Estabelecimento>();
        //procurar ID dos requisitos
        for(int i=0;i<Listas.estabelecimentoServicos.size();i++){

            if(Listas.estabelecimentoServicos.get(i).getServico_id().equalsIgnoreCase(idServico)){
                for(int i2=0;i2<Listas.estabelecimentos.size();i2++){
                    if(Listas.estabelecimentos.get(i2).getId().equalsIgnoreCase(Listas.estabelecimentoServicos.get(i).getEstabelecimento_id())){
                        estabelecimentosDoServico.add(Listas.estabelecimentos.get(i2));
                        Log.d("P.R.", "Apanhou "+i2);
                    }
                }

            }
        }

        Log.d("P.R.","---"+estabelecimentosDoServico.toString());
        return estabelecimentosDoServico;
    }

    public ArrayList<Estabelecimento> getEstabelecimentosDaInstituicaoEscolhida(){
        String idInstituicao=InstituicaoId;


        ArrayList<Estabelecimento> estabelecimentosDaInstituicao=new ArrayList<Estabelecimento>();
        //procurar ID dos requisitos
        for(int i=0;i<Listas.estabelecimentos.size();i++){

            if(Listas.estabelecimentos.get(i).getInstituicao_id().equalsIgnoreCase(idInstituicao)){

                estabelecimentosDaInstituicao.add(Listas.estabelecimentos.get(i));
                Log.d("P.R.", "Apanhou "+i);

            }
        }

        Log.d("P.R.","---"+estabelecimentosDaInstituicao.toString());
        return estabelecimentosDaInstituicao;
    }



}

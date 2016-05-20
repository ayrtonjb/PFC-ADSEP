package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.pfc.ayrton.pfc_adsep.MainActivity;
import com.pfc.ayrton.pfc_adsep.R;
import com.pfc.ayrton.pfc_adsep.ServicoActivity;
import com.pfc.ayrton.pfc_adsep.TabbedActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.Instituicao;
import bean.Servico;
import lists.CustomList;
import lists.Listas;


public class AFragment extends ListFragment {

    ArrayList<Servico> servicos= Listas.servicos;

    ListView lista;
    Integer[] Logo = {R.drawable.ic_categoria_viacao_48dp, R.drawable.ic_servico_default_48dp};






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<servicos.size();i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt",  servicos.get(i).getNome());

            if(servicos.get(i).getCategoriaID().equalsIgnoreCase("C002")){
                hm.put("img", Integer.toString(Logo[0]) );
            }

            else{
                hm.put("img", Integer.toString(Logo[1]));}

            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "img","txt"};

        // Ids of views in listview_layout
        int[] to = { R.id.img,R.id.txt};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_item, from, to);

        setListAdapter(adapter);



        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(getContext(),"item:"+Listas.servicos.get((int) getSelectedItemId()).getNome()+" Clicked", Toast.LENGTH_SHORT).show();
                Listas.servicoEscolhidoId= (int) getSelectedItemId();
                Intent ne=new Intent(getContext(),ServicoActivity.class);

                startActivity(ne);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}




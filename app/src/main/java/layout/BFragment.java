package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.pfc.ayrton.pfc_adsep.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.Instituicao;
import lists.Listas;

public class BFragment extends ListFragment {

    ArrayList<Instituicao> instituicoes= Listas.instituicoes;
    Integer defaultLogo = R.drawable.ic_instituicao_default_48dp;
    Integer logo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        List<HashMap<String,String>> bList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<Listas.instituicoes.size();i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", instituicoes.get(i).getNome());


            hm.put("img", Integer.toString(defaultLogo) );



            bList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "img","txt"};

        // Ids of views in listview_layout
        int[] to = { R.id.img,R.id.txt};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), bList, R.layout.list_item, from, to);

        setListAdapter(adapter);



        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(getContext(),"item:"+Listas.instituicoes.get((int) getSelectedItemId()).getNome()+" Clicked", Toast.LENGTH_SHORT).show();

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}

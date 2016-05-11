package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.pfc.ayrton.pfc_adsep.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BFragment extends ListFragment {
    String[] instituicoes = {
            "Instituição 1",
            "Instituição 2",
            "Instituição 3",
            "Instituição 4",
            "Instituição 5",
            "Instituição 6",
            "Instituição 7"
    } ;
    Integer[] logos = {
            R.drawable.cleanhistory,
            R.drawable.common_full_open_on_phone,
            R.drawable.common_ic_googleplayservices,
            R.drawable.feedback,
            R.drawable.logocontrast_white_scale_180,
            R.drawable.small_logo_targetsize_48,
            R.drawable.user40

    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        List<HashMap<String,String>> bList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<7;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt",  instituicoes[i]);
            hm.put("img", Integer.toString(logos[i]) );
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
}

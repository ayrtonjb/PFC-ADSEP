package lists;

/**
 * Created by Ayrton on 2016-05-07.
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pfc.ayrton.pfc_adsep.R;

import java.util.Arrays;
import java.util.List;

import layout.AFragment;

public class CustomList extends BaseAdapter{

    public LayoutInflater mInflater;
    private final String[] web;
    private final Integer[] imageId;
    public CustomList(Context context,
                      String[] web, Integer[] imageId) {




        this.web = web;
        this.imageId = imageId;

    }


    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView ==null)
        {
            convertView = mInflater.inflate(R.layout.list_item,parent,false);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.textView);
            holder.iv = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(web[position]);
        holder.iv.setImageResource(imageId[position]);
        // use holder.iv to set whatever image you want according to the position
        return convertView;
    }

    static class ViewHolder
    {
        ImageView iv;
        TextView tv;
    }
}
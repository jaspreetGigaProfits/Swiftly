package com.example.capstone_the_developers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListView extends ArrayAdapter<String> {
    ArrayList<String> msg;

    private Activity context;
    public CustomListView(Activity context, ArrayList<String> msg) {
        super(context, R.layout.item_list_message_send,msg);
        this.context=context;
        this.msg=msg;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){

            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.item_list_message_send,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) r.getTag();
        }
        viewHolder.txt_msg.setText(msg.get(position));

        return r;
    }
    class ViewHolder{

        TextView txt_msg;

        ViewHolder(View v){

            txt_msg=v.findViewById(R.id.txt_msg);


        }
    }


}


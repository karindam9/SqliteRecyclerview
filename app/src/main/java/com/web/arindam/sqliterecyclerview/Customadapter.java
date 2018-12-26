package com.web.arindam.sqliterecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Customadapter extends BaseAdapter {
    ArrayList<ModelDemo>arrayList=new ArrayList<>();
    Context context;

    public Customadapter(ArrayList<ModelDemo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txt_name,txt_add,txt_ph;
        TextView txt_id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder;

        if(convertView==null){
            convertView=inflater.inflate(R.layout.row_demo,null);
            viewHolder=new ViewHolder();
            viewHolder.txt_name=convertView.findViewById(R.id.txt_name);
            viewHolder.txt_add=convertView.findViewById(R.id.txt_add);
            viewHolder.txt_ph=convertView.findViewById(R.id.txt_ph);
            viewHolder.txt_id=convertView.findViewById(R.id.txt_id);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.txt_name.setText(arrayList.get(position).getName());
        viewHolder.txt_add.setText(arrayList.get(position).getAdd());
        viewHolder.txt_ph.setText(arrayList.get(position).getPhn());
        viewHolder.txt_id.setText(String.valueOf(arrayList.get(position).getId()));

        return convertView;


    }
}

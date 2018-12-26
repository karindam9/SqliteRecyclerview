package com.web.arindam.sqliterecyclerview.CreateContactUse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.web.arindam.sqliterecyclerview.R;

import java.util.ArrayList;

public class RecylerAdapter1 extends RecyclerView.Adapter<RecylerAdapter1.MyViewHolder> {

    ArrayList<Modelrow>arrayList=new ArrayList<>();
    Context context;


    public RecylerAdapter1(ArrayList<Modelrow> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecylerAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowdemo1,viewGroup,false);
//        viewHolder=new MyViewHolder(view);
//        return viewHolder;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.txt_id.setText(String.valueOf(arrayList.get(i).getId()));
        myViewHolder.txt_nam.setText(arrayList.get(i).getName());
        myViewHolder.txt_phn.setText(arrayList.get(i).getPhone());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_id,txt_nam,txt_phn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id=itemView.findViewById(R.id.txt_id);
            txt_nam=itemView.findViewById(R.id.txt_nam);
            txt_phn=itemView.findViewById(R.id.txt_phn);

        }
    }
}

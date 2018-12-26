package com.web.arindam.sqliterecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyOwnAdapter> {

    ArrayList<ModelDemo>arrayList=new ArrayList<>();
    MyOwnAdapter ownAdapter;
    Context context;

    public RecyclerAdapter(ArrayList<ModelDemo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyOwnAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_demo,viewGroup,false);
        ownAdapter=new MyOwnAdapter(view);
        return ownAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnAdapter myOwnAdapter, int i) {

        ownAdapter.txt_name.setText(arrayList.get(i).getName());
        ownAdapter.txt_add.setText(arrayList.get(i).getAdd());
        ownAdapter.txt_ph.setText(arrayList.get(i).getPhn());
        ownAdapter.txt_id.setText(String.valueOf(arrayList.get(i).getId()));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyOwnAdapter extends RecyclerView.ViewHolder {
        TextView txt_name,txt_add,txt_ph,txt_id;

        public MyOwnAdapter(@NonNull View itemView) {
            super(itemView);

            txt_name=itemView.findViewById(R.id.txt_name);
            txt_add=itemView.findViewById(R.id.txt_add);
            txt_ph=itemView.findViewById(R.id.txt_ph);
            txt_id=itemView.findViewById(R.id.txt_id);

        }
    }
}

package com.example.question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adpQ extends RecyclerView.Adapter<adpQ.myviewholder>{
    List<qData> dataholder;
    public adpQ(List<qData> dataholder){
        this.dataholder = dataholder;
    }

    @NonNull
    @Override

    public adpQ.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.holderq,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adpQ.myviewholder holder, int position) {

        holder.tque.setText(dataholder.get(position).getQvalue());
        holder.tqkey.setText(dataholder.get(position).getQkey());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        private TextView tque,tqkey;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            tque =(TextView)itemView.findViewById(R.id.textQ);
            tqkey =(TextView)itemView.findViewById(R.id.textKey);
        }
    }
}

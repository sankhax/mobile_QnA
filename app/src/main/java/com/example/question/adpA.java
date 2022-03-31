//package com.example.question;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class adpA extends RecyclerView.Adapter<myadapter.myviewholder>{
//    @NonNull
//    @Override
//    public adpA.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.holderq,parent,false);
//        return new adpQ.myviewholder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    class myviewholder extends RecyclerView.ViewHolder
//    {
//        TextView tans,tqkey;
//        public myviewholder(@NonNull View itemView)
//        {
//            super(itemView);
//            tans =(TextView)itemView.findViewById(R.id.textQ);
//            tqkey =(TextView)itemView.findViewById(R.id.textKey);
//        }
//    }
//}

package com.example.donationapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donationapp.Interface.RecylerViewClicked;
import com.example.donationapp.POJO.Coll;
import com.example.donationapp.POJO.NGO;
import com.example.donationapp.R;

import java.util.List;

public class Coll_List_Adapter extends RecyclerView.Adapter<Coll_List_Adapter.CollViewHolder> {
    List<Coll> CollList;
    Context context;
    RecylerViewClicked listner;

    public Coll_List_Adapter(List<Coll> CollList, Context context, RecylerViewClicked listner) {
        this.CollList = CollList;
        this.context = context;
        this.listner = listner;
    }

    @NonNull
    @Override
    public CollViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_collection, parent, false);
        return new CollViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollViewHolder holder, int position) {
        Coll experience = CollList.get(position);
        holder.name.setText(experience.getName());
        holder.address.setText(experience.getAddress());
        holder.itemView.setOnClickListener(v -> listner.onClick(position));
    }

    @Override
    public int getItemCount() {
        return CollList.size();
    }

    class CollViewHolder extends RecyclerView.ViewHolder {
        TextView name, address;
        CollViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ngo_name);
            address = itemView.findViewById(R.id.ngo_address);
        }
    }
}

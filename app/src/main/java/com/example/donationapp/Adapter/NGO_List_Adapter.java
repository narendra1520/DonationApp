package com.example.donationapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donationapp.Interface.RecylerViewClicked;
import com.example.donationapp.POJO.NGO;
import com.example.donationapp.R;

import java.util.List;

public class NGO_List_Adapter extends RecyclerView.Adapter<NGO_List_Adapter.NGOViewHolder> {
    List<NGO> NGOList;
    Context context;
    RecylerViewClicked listner;

    public NGO_List_Adapter(List<NGO> NGOList, Context context, RecylerViewClicked listner) {
        this.NGOList = NGOList;
        this.context = context;
        this.listner = listner;
    }

    @NonNull
    @Override
    public NGO_List_Adapter.NGOViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_collection, parent, false);
        return new NGOViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NGO_List_Adapter.NGOViewHolder holder, int position) {
        NGO ngo = NGOList.get(position);
        holder.name.setText(ngo.getName());
        holder.address.setText(ngo.getAddress());
        holder.itemView.setOnClickListener(v -> listner.onClick(position));
    }

    @Override
    public int getItemCount() {
        return NGOList.size();
    }

    class NGOViewHolder extends RecyclerView.ViewHolder {
        TextView name, address;

        NGOViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ngo_name);
            address = itemView.findViewById(R.id.ngo_address);
        }
    }
}

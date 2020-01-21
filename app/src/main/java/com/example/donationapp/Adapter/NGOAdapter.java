package com.example.donationapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donationapp.POJO.NGO;
import com.example.donationapp.R;

import java.util.List;

public class NGOAdapter extends RecyclerView.Adapter<NGOAdapter.NGOViewHolder> {
    List<NGO> NGOList;
    Context context;

    public NGOAdapter(List<NGO> NGOList, Context context) {
        this.NGOList = NGOList;
        this.context = context;
    }

    @NonNull
    @Override
    public NGOAdapter.NGOViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_list, parent, false);
        return new NGOViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NGOAdapter.NGOViewHolder holder, int position) {
        NGO experience = NGOList.get(position);
        holder.name.setText(experience.getName());
        holder.address.setText(experience.getAddress());
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

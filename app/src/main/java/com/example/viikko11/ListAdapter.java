package com.example.viikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.Item.setText(items.get(position).getItem());
        holder.Info.setText(items.get(position).getInfo());
        holder.editItem.setText(items.get(position).getItem());
        holder.editInfo.setText(items.get(position).getInfo());


        holder.removeImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.getInstance().removeItem(items.get(pos).getID());
            notifyItemRemoved(pos);
        });


        holder.editImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            if(holder.editItem.getVisibility() == View.VISIBLE) {
                Item item = Storage.getInstance().getItemByID(pos);
                item.setItem(holder.editItem.getText().toString());
                holder.editItem.setVisibility(View.GONE);

                item.setInfo(holder.editInfo.getText().toString());
                holder.editInfo.setVisibility(View.GONE);

                notifyDataSetChanged();
            }
            else {
                holder.editItem.setVisibility(View.VISIBLE);
                holder.editInfo.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public int getItemCount() {return items.size();}

}

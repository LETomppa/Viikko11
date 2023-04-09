package com.example.viikko11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    ImageView removeImage, editImage;
    TextView Item, Info;
    EditText editItem, editInfo;
    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        Item = itemView.findViewById(R.id.txtItem);
        Info = itemView.findViewById(R.id.txtInfo);
        removeImage = itemView.findViewById(R.id.imgRemove);
        editImage = itemView.findViewById(R.id.imgEdit);
        editItem = itemView.findViewById(R.id.editItem);
        editInfo = itemView.findViewById(R.id.editInfo);
    }
}

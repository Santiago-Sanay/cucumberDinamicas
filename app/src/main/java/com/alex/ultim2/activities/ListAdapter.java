package com.alex.ultim2.activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.ultim2.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;
    public ListAdapter(List<ListElement> itemList,Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;

    }
    @Override
    public int getItemCount(){
        return mData.size();
    }
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view=mInflater.inflate(R.layout.item_list,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }
    public void setItem(List<ListElement> items){
        mData=items;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name,city,status;
        ViewHolder(View itemView){
            super(itemView);
            iconImage=itemView.findViewById(R.id.iconImageView);
            name=itemView.findViewById(R.id.nameTextView);
            city=itemView.findViewById(R.id.cityTextView);
            status=itemView.findViewById(R.id.statusTextView);

        }
        void bindData(final ListElement item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
        }
    }




}

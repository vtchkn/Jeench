package com.example.evetochkin.jeench.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.evetochkin.jeench.R;
import com.example.evetochkin.jeench.model.content.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private ArrayList<Item> data;

    public ItemAdapter(ArrayList<Item> data) {
        this.data = data;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount()  {
        return data.size();
    }

    public void addAll(List<Item> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void add(Item item) {
        data.add(item);
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemImage)
        ImageView itemImage;
        @BindView(R.id.itemName)
        TextView itemName;
        @BindView(R.id.itemPrice)
        TextView itemPrice;
        @BindView(R.id.shopName)
        TextView shopName;
        @BindView(R.id.pointDistance)
        TextView pointDistance;
        @BindView(R.id.textView8)
        TextView textView8;
        @BindView(R.id.shopLogo)
        ImageView shopLogo;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

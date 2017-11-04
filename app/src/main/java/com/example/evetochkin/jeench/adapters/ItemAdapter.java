package com.example.evetochkin.jeench.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.evetochkin.jeench.App;
import com.example.evetochkin.jeench.R;
import com.example.evetochkin.jeench.model.content.Item;
import com.example.evetochkin.jeench.model.content.Message;
import com.example.evetochkin.jeench.ui.RaitingView;
import com.example.evetochkin.jeench.util.Currency;


import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    public Context context;

    private ArrayList<Message> data;


    public ItemAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Message item = data.get(position);
        holder.itemName.setText(item.getItemName());
        String itemPrice = item.getItemPrice();

        holder.itemPrice.setText(App.currencyParser(itemPrice, Currency.RUB));
        holder.shopName.setText(item.getShopName());
        holder.pointDistance.setText(item.getPointDistance());
        String trim = item.getPointRank().trim().substring(0,3);
        holder.raitingView.update(Long.parseLong(trim));
        Glide.with(context)
                .load(item.getItemImage())
                .apply(new RequestOptions().fitCenter().centerCrop().placeholder(R.drawable.item_default).transforms(new RoundedCorners(20)))
                .into(holder.itemImage);
        Glide.with(context)
                .load(item.getShopLogo())
                .apply(new RequestOptions().circleCrop().placeholder(R.drawable.shop_default))
                .into(holder.shopLogo);


    }

    @Override
    public int getItemCount()  {
        return data.size();
    }

    public void addAll(List<Message> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void add(Message item) {
        data.add(item);
        notifyDataSetChanged();
    }

    public void clear() {
        data.clear();
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
        @BindView(R.id.raitingView)
        RaitingView raitingView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

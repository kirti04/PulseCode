package com.example.pulseliveproject.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pulseliveproject.R;
import com.example.pulseliveproject.pojo.ItemList;
import com.example.pulseliveproject.pojo.Items;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {
    private List<Items> data;
    private RecyclerViewAdapter.ClickListener clickListener;

    @Inject
    public RecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        data = new ArrayList();

    }

    @Override
    public RecyclerViewAdapter.RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail,parent,false);
        return new RecycleViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapter.RecycleViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.subTitle.setText((data.get(position)).getSubtitle());
        holder.date.setText(data.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subTitle;
        TextView date;
        LinearLayout recycle_item;

        public RecycleViewHolder(View v) {
            super(v);
            recycle_item = (LinearLayout) v.findViewById(R.id.recycle_item_list);
            title = (TextView) v.findViewById(R.id.text_title);
            subTitle = (TextView) v.findViewById(R.id.text_subTitle);
            date = (TextView) v.findViewById(R.id.text_date);
            recycle_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.launchIntent(data.get(getAdapterPosition()).getId());
                }
            });
        }
    }
    public interface ClickListener {
        void launchIntent(int id);
    }

    public void setData(List<Items> list_data) {
        this.data.addAll(list_data);
        notifyDataSetChanged();
    }
}

package com.example.dreamland;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamland.database.Adjustment;

import java.util.List;

public class PosDetailAdapter extends RecyclerView.Adapter<PosDetailAdapter.ViewHolder> {

    List<Adjustment> items;
    String[] postures = {"오른쪽", "왼쪽", "정면"};

    public PosDetailAdapter(List<Adjustment> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.pos_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Adjustment item = items.get(position);
        holder.tvId.setText(String.valueOf(position + 1));
        holder.tvTime.setText(item.getAdjTime());
        int beforeIndex = Integer.parseInt(item.getBeforePos());
        int afterIndex = Integer.parseInt(item.getAfterPos());
        holder.tvBeforePos.setText(postures[beforeIndex]);
        holder.tvAfterPos.setText(postures[afterIndex]);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvTime;
        TextView tvBeforePos;
        TextView tvAfterPos;

        public ViewHolder(View view) {
            super(view);
            tvId = view.findViewById(R.id.tvId);
            tvTime = view.findViewById(R.id.tvTime);
            tvBeforePos = view.findViewById(R.id.tvBeforePos);
            tvAfterPos = view.findViewById(R.id.tvAfterPos);
        }
    }
}


package com.example.postresfitness.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.postresfitness.Postres;
import com.example.postresfitness.R;

import java.util.List;

public class DataFitAdapter extends RecyclerView.Adapter<DataFitAdapter.TheHolder> implements View.OnClickListener {

    private Context context;
    private List<Postres> lista;
    private OnItemClickListener listener;

    public DataFitAdapter(Context context, List<Postres> lista){
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public TheHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_layout, parent, false);
        TheHolder holder = new TheHolder(view);
        holder.image = view.findViewById(R.id.image);
        holder.image.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TheHolder holder, int position) {
        holder.image.setImageResource(lista.get(position).getImage());
        holder.image.setTag(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View v) {
        listener.onClick(lista.get((int)v.getTag()));
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class TheHolder extends ViewHolder{
        public ImageView image;

        public TheHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener{
        void onClick(Postres postre);
    }
}

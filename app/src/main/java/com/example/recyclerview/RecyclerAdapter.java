package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderData> implements View.OnClickListener {
    // <Clase interna creada dentro de la clase que creamos nosotros (en este caso: RecyclerAdapter)>

    ArrayList<ModeloItem> lista;
    View.OnClickListener listener;

    public RecyclerAdapter(ArrayList<ModeloItem> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolderData(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolderData holder, int position) {
        holder.ivFoto.setImageResource(lista.get(position).getFoto());
        holder.tvTitulo.setText(lista.get(position).getTitulo());
        holder.tvDetalle.setText(lista.get(position).getDetalle());
        if (lista.get(position).isSelected()){
            holder.rlGeneralItem.setBackgroundColor(Color.argb(255, 0, 0, 0));
        }
        else
            holder.rlGeneralItem.setBackgroundColor(lista.get(position).getColor());
        //holder.rlGeneralItem.setBackgroundColor(Color.argb(255, 255, 0, 0));
        //holder.rlGeneralItem.setBackgroundColor(Color.parseColor("#000000"));
        //holder.rlGeneralItem.setBackgroundColor(ContextCompat.getColor(holder.getRlGeneralItem().getContext(), R.color.black));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private TextView tvTitulo, tvDetalle;
        private RelativeLayout rlGeneralItem;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDetalle = itemView.findViewById(R.id.tvDetalle);
            rlGeneralItem = itemView.findViewById(R.id.rlGeneralItem);
        }

        public RelativeLayout getRlGeneralItem() {
            return rlGeneralItem;
        }

        public void setRlGeneralItem(RelativeLayout rlGeneralItem) {
            this.rlGeneralItem = rlGeneralItem;
        }

        public ImageView getIvFoto() {
            return ivFoto;
        }

        public void setIvFoto(ImageView ivFoto) {
            this.ivFoto = ivFoto;
        }

        public TextView getTvTitulo() {
            return tvTitulo;
        }

        public void setTvTitulo(TextView tvTitulo) {
            this.tvTitulo = tvTitulo;
        }

        public TextView getTvDetalle() {
            return tvDetalle;
        }

        public void setTvDetalle(TextView tvDetalle) {
            this.tvDetalle = tvDetalle;
        }
    }

    void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

}

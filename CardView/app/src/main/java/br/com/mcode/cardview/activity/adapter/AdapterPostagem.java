package br.com.mcode.cardview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.mcode.cardview.R;
import br.com.mcode.cardview.model.Postagem;

public class AdapterPostagem extends RecyclerView.Adapter<AdapterPostagem.MyViewHolder>{

    private List<Postagem> postagemList;

    public AdapterPostagem(List<Postagem> list){
        this.postagemList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.postagem_detalhe, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHlder, int i) {
        Postagem postagem = postagemList.get(i);
        myViewHlder.textNome.setText(postagem.getNome());
        myViewHlder.textPostagem.setText(postagem.getPostagem());
        myViewHlder.imagemPostagem.setImageResource(postagem.getImagem());

    }

    @Override
    public int getItemCount() {
        return postagemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //Atributos
        private TextView textNome;
        private TextView textPostagem;
        private ImageView imagemPostagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            textPostagem = itemView.findViewById(R.id.textPostagem);
            imagemPostagem = itemView.findViewById(R.id.imagePostagem);
        }
    }
}

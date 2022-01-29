package br.com.mcode.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.mcode.cardview.R;
import br.com.mcode.cardview.activity.adapter.AdapterPostagem;
import br.com.mcode.cardview.model.Postagem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> listpostagens = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Definir um layout
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        /*
        //Mudando a orientação do layout para o lado

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

         */
        //GridLayout
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerPostagem.setLayoutManager(layoutManager);

        //Definir um adapter
        this.preparaPostagem();
        AdapterPostagem adapter = new AdapterPostagem(listpostagens);
        recyclerPostagem.setAdapter(adapter);

    }

    public void preparaPostagem(){
        Postagem postagem = new Postagem("Marcio Cruz", "#Canada", R.drawable.imagem1);
        this.listpostagens.add(postagem);

        postagem = new Postagem("Adilma", "#Instambu", R.drawable.imagem2);
        this.listpostagens.add(postagem);

        postagem = new Postagem("Johnes Santana", "#Paris", R.drawable.imagem3);
        this.listpostagens.add(postagem);

        postagem = new Postagem("Eliene dos Santos", "#Bahia Salvador", R.drawable.imagem4);
        this.listpostagens.add(postagem);
    }
}
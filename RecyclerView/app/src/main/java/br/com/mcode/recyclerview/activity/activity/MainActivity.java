package br.com.mcode.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mcode.recyclerview.R;
import br.com.mcode.recyclerview.activity.RecyclerItemClickListener;
import br.com.mcode.recyclerview.activity.adapter.Adapter;
import br.com.mcode.recyclerview.activity.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Configurar adapter

        Adapter adapter = new Adapter(listaFilmes);
        criarFilmes();


        //Configurar RecyclerView
        //criando um gerenciador de layout
        RecyclerView.LayoutManager layoutManger = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManger);
        recyclerView.setHasFixedSize(true);//tamanho fixo
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de Click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                        filme.getTitulo(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemlick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                        filme.getTitulo() + " click long",
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){

        Filme filmes = new Filme("Homem Aranha", "2017", "Ação");
        listaFilmes.add(filmes);

        filmes = new Filme("Liga da Justiça", "2019", "Aventura");
        listaFilmes.add(filmes);

        filmes = new Filme("It: A coisa", "2020", "Terror");
        listaFilmes.add(filmes);

        filmes = new Filme("A Bela e a Ferra", "2022", "Drama / Romance");
        listaFilmes.add(filmes);

        filmes = new Filme("Capitão America", "2003", "Aventura");
        listaFilmes.add(filmes);

        filmes = new Filme("Mulher Maravilha", "2016", "Ação / Aventura");
        listaFilmes.add(filmes);

        filmes = new Filme("Velozes e Furiosos 7", "2020", "Ação / Aventura");
        listaFilmes.add(filmes);

        filmes = new Filme("CIS", "2020", "Policial/ Aventura");
        listaFilmes.add(filmes);

        filmes = new Filme("La Casa de Papel", "2020", "Policial/ Aventura");
        listaFilmes.add(filmes);
    }
}
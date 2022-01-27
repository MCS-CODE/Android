package br.com.mcode.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.mcode.cardview.R;
import br.com.mcode.cardview.activity.adapter.AdapterPostagem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Definir um layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);

        //Definir um adapter
        AdapterPostagem adapter = new AdapterPostagem();
        recyclerPostagem.setAdapter(adapter);
    }
}
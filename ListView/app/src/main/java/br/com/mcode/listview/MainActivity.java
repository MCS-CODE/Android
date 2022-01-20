package br.com.mcode.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaLocais;
    private String[] itens = {
            "Angra dos Reis", "Morro de São Paulo", "Ilhéus",
            "Salvador", "Feira de Santana", "Pernanbuco",
            "Rio Grande do Sul", "Itália", "Argentina",
            "Estado Unidos", "Tókio", "Canadá","Horlando"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLocais = findViewById(R.id.listaLocais);


        //Criando adaptador para lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                //contexto
                getApplicationContext(),
                //Layout
                android.R.layout.simple_list_item_1,
                //identificador dos campos do layout
                android.R.id.text1,
                //listagem
                itens
        );

        //Adicionar adaptador para a lista
        listaLocais.setAdapter(adaptador);

        //Adicionado clique na lista
        listaLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valorSelecionado = listaLocais.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),valorSelecionado,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package br.com.mcode.fragments.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.mcode.fragments.R;
import br.com.mcode.fragments.fragments.ContatoFragment;
import br.com.mcode.fragments.fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {
    /*
    * Na activity.xml principal add o FrameLayout pois ele é um container*/

    private Button btnContato, btnConversas;

    //Criando um acesso para o fragments Conversas
    private ConversasFragment conversasFragment;
    private ContatoFragment contatoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //config buttons
        btnContato = findViewById(R.id.buttonContatos);
        btnConversas = findViewById(R.id.buttonConversa);

        //removendo a sonbra da actionBar
        getSupportActionBar().setElevation(0);

        //instanciando o fragmento
        conversasFragment = new ConversasFragment();
        contatoFragment = new ContatoFragment();

        //Configurando um objeto para o Fragmento iniciando uma transação
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, conversasFragment);
        //fechando a transaçao
        transaction.commit();

        btnContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatoFragment);
                transaction.commit();
            }
        });

        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();
            }
        });

    }
}


package br.com.mcode.passandodadosparaactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    private TextView textNome, textIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome = findViewById(R.id.textView_nome);
        textIdade = findViewById(R.id.textView_idade);

        //Recuperar os dados enviados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");

        //recuperando dados de um objeto
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        //passando dados do objeto para view
        textNome.setText(usuario.getNome());
        textIdade.setText(usuario.getEmail());

        //passando dados para view
        //textNome.setText(nome);
        //textIdade.setText(String.valueOf(idade));
    }
}
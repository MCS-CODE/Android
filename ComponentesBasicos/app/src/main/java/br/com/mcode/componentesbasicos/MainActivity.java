package br.com.mcode.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.editText_nome);
        campoEmail = findViewById(R.id.editText_email);
        textResultado = findViewById(R.id.txt_resultado);
    }

    public void exibirResultado(View view){

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textResultado.setText("Nome: "+ nome + "\nEmail: " + email);
    }

    public void limpar(View view){

        campoNome.setText("");
        campoEmail.setText("");
    }
}
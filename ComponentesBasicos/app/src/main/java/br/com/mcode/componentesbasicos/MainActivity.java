package br.com.mcode.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textResultado;

    //checkBox
    private CheckBox checkverde, checkvermelho, checkbranco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.editText_nome);
        campoEmail = findViewById(R.id.editText_email);
        textResultado = findViewById(R.id.txt_resultado);
        //=============================================

        checkverde = findViewById(R.id.checkbox_verde);
        checkbranco = findViewById(R.id.checkbox_branco);
        checkvermelho = findViewById(R.id.checkbox_vermelho);
    }

    public void exibirResultado(View view){
        checkBox();

        /*

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textResultado.setText("Nome: "+ nome + "\nEmail: " + email);

         */
    }

    public void limpar(View view){

        campoNome.setText("");
        campoEmail.setText("");
    }

    public void checkBox(){
        String texto = "";

        if (checkbranco.isChecked()){
            String corSelecionada = checkbranco.getText().toString();
            texto = corSelecionada;
            textResultado.setText(texto);
        }
        if (checkverde.isChecked()){
            String corSelecionada = checkverde.getText().toString();
            texto = texto +" " +  corSelecionada;
            textResultado.setText(texto);
        }
        if (checkvermelho.isChecked()){
            texto = texto + "vermelho selecionado -> ";
            textResultado.setText(texto);
        }
    }


}
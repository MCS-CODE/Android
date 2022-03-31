package br.com.mcode.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.button_salvar);
        editNome = findViewById(R.id.edit_nome);
        textResultado = findViewById(R.id.text_resultado);



        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                //Validar Nome
                if (editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Digite o seu nome!!!", Toast.LENGTH_LONG).show();
                }else {
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textResultado.setText("Olá... " + nome);
                }
            }
        });

        //Recuperando dados
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        //Valida se temos o nome preferences
        if (preferences.contains("nome")){
            String nome = preferences.getString("nome", "Usuario nao encontrado");
            textResultado.setText("Esta salvo "+ nome);


        }else {
            textResultado.setText("Usuario nao definido");
        }

    }
}
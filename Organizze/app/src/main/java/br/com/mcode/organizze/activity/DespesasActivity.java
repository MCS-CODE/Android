package br.com.mcode.organizze.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import br.com.mcode.organizze.R;
import br.com.mcode.organizze.helper.DateCustom;

public class DespesasActivity extends AppCompatActivity {

    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        campoData = findViewById(R.id.edit_data);
        campoCategoria = findViewById(R.id.edit_categoria);
        campoDescricao = findViewById(R.id.edit_descricao);
        campoValor = findViewById(R.id.edit_valor);

        //Pegando data atual
        campoData.setText(DateCustom.dataAtual());

    }
}
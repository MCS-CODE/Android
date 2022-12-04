package br.com.mcode.organizze.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import br.com.mcode.organizze.R;
import br.com.mcode.organizze.helper.DateCustom;
import br.com.mcode.organizze.model.Movimentacao;

public class DespesasActivity extends AppCompatActivity {

    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;
    private Movimentacao movimentacao;

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

    public void salvarDespesas(View view){
        movimentacao = new Movimentacao();
        movimentacao.setValor(Double.parseDouble(campoValor.getText().toString()));
        movimentacao.setCategoria(campoCategoria.getText().toString());
        movimentacao.setData(campoData.getText().toString());
        movimentacao.setDescricao(campoDescricao.getText().toString());
        movimentacao.setTipo("d");
        String mesAno = campoData.getText().toString();

        movimentacao.salvar(mesAno);
    }


}
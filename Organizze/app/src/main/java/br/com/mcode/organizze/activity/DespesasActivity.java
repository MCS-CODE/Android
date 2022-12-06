package br.com.mcode.organizze.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        if(validarCampoDespesa()) {
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

    public boolean validarCampoDespesa(){
        String textData = campoData.getText().toString();
        String textCategoria = campoCategoria.getText().toString();
        String textDescricao = campoDescricao.getText().toString();
        String textValor = campoValor.getText().toString();

        if ( !textData.isEmpty()){
            if ( !textCategoria.isEmpty()){
                if ( !textDescricao.isEmpty()){
                    if ( !textValor.isEmpty()){
                        return true;
                    }else {
                        Toast.makeText(DespesasActivity.this, "Campo Valor não preenchido!", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }else {
                    Toast.makeText(DespesasActivity.this, "Campo Descrição não preenchido!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else {
                Toast.makeText(DespesasActivity.this, "Campo Categoria não preenchido!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else {
            Toast.makeText(DespesasActivity.this, "Campo data não preenchido!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
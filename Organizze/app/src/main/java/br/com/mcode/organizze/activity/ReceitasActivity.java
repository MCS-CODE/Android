package br.com.mcode.organizze.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import br.com.mcode.organizze.R;
import br.com.mcode.organizze.config.ConfigFirebase;
import br.com.mcode.organizze.helper.Base64Custom;
import br.com.mcode.organizze.helper.DateCustom;
import br.com.mcode.organizze.model.Movimentacao;
import br.com.mcode.organizze.model.Usuario;

public class ReceitasActivity extends AppCompatActivity {

    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;
    private Movimentacao movimentacao;
    private DatabaseReference databaseReference = ConfigFirebase.getFirebaseDatabase();
    private FirebaseAuth autenticacao = ConfigFirebase.getFirebadeAutenticacao();
    private double receitaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);

        campoData = findViewById(R.id.edite_data_r);
        campoCategoria = findViewById(R.id.edite_categoria_r);
        campoDescricao = findViewById(R.id.edite_descricao_r);
        campoValor = findViewById(R.id.edite_valor_r);

        //Pegando data atual
        campoData.setText(DateCustom.dataAtual());
        recuperarReceitaTotal();
    }

    public void salvarReceita(View view){

        if(validarCampoReceita()) {
            movimentacao = new Movimentacao();
            Double valorRecuperado = Double.parseDouble(campoValor.getText().toString());
            movimentacao.setValor(valorRecuperado);
            movimentacao.setCategoria(campoCategoria.getText().toString());
            movimentacao.setData(campoData.getText().toString());
            movimentacao.setDescricao(campoDescricao.getText().toString());
            movimentacao.setTipo("r");
            String mesAno = campoData.getText().toString();

            Double receitaAtualizada = valorRecuperado + receitaTotal;
            atualizarReceita(receitaAtualizada);

            movimentacao.salvar(mesAno);
            finish();
        }
    }

    public boolean validarCampoReceita(){
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
                        Toast.makeText(ReceitasActivity.this, "Campo Valor não preenchido!", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }else {
                    Toast.makeText(ReceitasActivity.this, "Campo Descrição não preenchido!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else {
                Toast.makeText(ReceitasActivity.this, "Campo Categoria não preenchido!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else {
            Toast.makeText(ReceitasActivity.this, "Campo data não preenchido!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void recuperarReceitaTotal(){
        String idUserMail = autenticacao.getCurrentUser().getEmail();
        String idusuario = Base64Custom.codificarBase64(idUserMail);
        DatabaseReference idUserRef = databaseReference.child("usuarios").child(idusuario);

        idUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuario usuario = snapshot.getValue(Usuario.class);
                receitaTotal = usuario.getReceitaTotal();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void atualizarReceita(Double receita){
        String idUserMail = autenticacao.getCurrentUser().getEmail();
        String idusuario = Base64Custom.codificarBase64(idUserMail);
        DatabaseReference idUserRef = databaseReference.child("usuarios").child(idusuario);

        idUserRef.child("receitaTotal").setValue(receita);
    }

}

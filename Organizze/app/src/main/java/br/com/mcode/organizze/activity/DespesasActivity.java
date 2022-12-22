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

public class DespesasActivity extends AppCompatActivity {

    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;
    private Movimentacao movimentacao;
    private DatabaseReference databaseReference = ConfigFirebase.getFirebaseDatabase();
    private FirebaseAuth autenticacao = ConfigFirebase.getFirebadeAutenticacao();
    private double despesaTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        campoData = findViewById(R.id.edite_data);
        campoCategoria = findViewById(R.id.edite_categoria);
        campoDescricao = findViewById(R.id.edit_descricao);
        campoValor = findViewById(R.id.edite_valor);

        //Pegando data atual
        campoData.setText(DateCustom.dataAtual());
        recuperarDespesaTotal();

    }

    public void salvarDespesas(View view){

        if(validarCampoDespesa()) {
            movimentacao = new Movimentacao();
            Double valorRecuperado = Double.parseDouble(campoValor.getText().toString());
            movimentacao.setValor(valorRecuperado);
            movimentacao.setCategoria(campoCategoria.getText().toString());
            movimentacao.setData(campoData.getText().toString());
            movimentacao.setDescricao(campoDescricao.getText().toString());
            movimentacao.setTipo("d");
            String mesAno = campoData.getText().toString();

           Double despesaAtualizada = valorRecuperado + despesaTotal;
           atualizarDespesa(despesaAtualizada);

            movimentacao.salvar(mesAno);
            finish();
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

    public void recuperarDespesaTotal(){
        String idUserMail = autenticacao.getCurrentUser().getEmail();
        String idusuario = Base64Custom.codificarBase64(idUserMail);
        DatabaseReference idUserRef = databaseReference.child("usuarios").child(idusuario);

        idUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuario usuario = snapshot.getValue(Usuario.class);
                despesaTotal = usuario.getDespesaTotal();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void atualizarDespesa(Double despesa){
        String idUserMail = autenticacao.getCurrentUser().getEmail();
        String idusuario = Base64Custom.codificarBase64(idUserMail);
        DatabaseReference idUserRef = databaseReference.child("usuarios").child(idusuario);

        idUserRef.child("despesaTotal").setValue(despesa);
    }

}
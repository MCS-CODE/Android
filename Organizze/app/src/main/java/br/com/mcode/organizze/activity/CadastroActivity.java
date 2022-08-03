package br.com.mcode.organizze.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import br.com.mcode.organizze.R;
import br.com.mcode.organizze.config.ConfigFirebase;
import br.com.mcode.organizze.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button btnCadastrar;
    private FirebaseAuth autenticacao;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.edit_nome);
        campoEmail = findViewById(R.id.edit_email);
        campoSenha = findViewById(R.id.edit_senha);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textNome = campoNome.getText().toString();
                String textEmail = campoEmail.getText().toString();
                String textSenha = campoSenha.getText().toString();

                if ( !textNome.isEmpty()){
                    if (!textEmail.isEmpty()){
                        if(!textSenha.isEmpty()){
                            usuario = new Usuario();
                            usuario.setNome(textNome);
                            usuario.setEmail(textEmail);
                            usuario.setSenha(textSenha);
                            cadastrarUsuario();
                        }else {
                            Toast.makeText(CadastroActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(CadastroActivity.this, "Preencha o email", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(CadastroActivity.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void cadastrarUsuario(){
        autenticacao = ConfigFirebase.getFirebadeAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                }else {
                    String excecao = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        excecao = "Digite uma Senha mais Forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "O email não é valido";
                    }catch (FirebaseAuthUserCollisionException e){
                        excecao = "Esse email já foi cadastrado";
                    }catch (Exception e){
                        excecao =" Erro ao cadastrar usuario: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
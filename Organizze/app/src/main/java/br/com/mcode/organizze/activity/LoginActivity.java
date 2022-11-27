package br.com.mcode.organizze.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import br.com.mcode.organizze.R;
import br.com.mcode.organizze.config.ConfigFirebase;
import br.com.mcode.organizze.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Button btnLogar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.edit_email_login);
        campoSenha = findViewById(R.id.edit_senha_login);
        btnLogar = findViewById(R.id.btn_logar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEmail = campoEmail.getText().toString();
                String textSenha = campoSenha.getText().toString();
                if (!textEmail.isEmpty()){
                    if(!textSenha.isEmpty()){
                        usuario = new Usuario();
                        usuario.setEmail(textEmail);
                        usuario.setSenha(textSenha);
                        validarLogin();

                    }else {
                        Toast.makeText(LoginActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(LoginActivity.this, "Preencha o email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void validarLogin(){
        autenticacao = ConfigFirebase.getFirebadeAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirTelaPrincipal();
                }else {

                    String excecao = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Usuario nao esta cadastrado";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Email ou senha invalida";
                    }catch (Exception e){
                        excecao =" Erro ao cadastrar usuario: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, PrincipalActivity.class));
        finish();
    }
}
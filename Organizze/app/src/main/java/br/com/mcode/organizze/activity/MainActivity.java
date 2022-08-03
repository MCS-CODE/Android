package br.com.mcode.organizze.activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import br.com.mcode.organizze.PrincipalActivity;
import br.com.mcode.organizze.R;
import br.com.mcode.organizze.activity.CadastroActivity;
import br.com.mcode.organizze.activity.LoginActivity;
import br.com.mcode.organizze.config.ConfigFirebase;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_one)
                .background(android.R.color.white)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_two)
                .background(android.R.color.white)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_tree)
                .background(android.R.color.white)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_four)
                .background(android.R.color.white)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_cadastro)
                .background(android.R.color.black)
                .build()
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        userLogado();
    }

    public void cadastreSe(View view){

        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void entrarConta(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void userLogado(){
        autenticacao = ConfigFirebase.getFirebadeAutenticacao();
        //autenticacao.signOut();

        if (autenticacao.getCurrentUser() != null){
            abrirTelaPrincipal();
        }
    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, PrincipalActivity.class));
    }
}
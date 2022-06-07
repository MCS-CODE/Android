package br.com.mcode.organizze;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import br.com.mcode.organizze.activity.CadastroActivity;
import br.com.mcode.organizze.activity.LoginActivity;

public class MainActivity extends IntroActivity {

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

    public void cadastreSe(View view){

        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void entrarConta(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
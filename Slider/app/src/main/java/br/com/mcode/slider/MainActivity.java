package br.com.mcode.slider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import br.com.mcode.slider.activity.CadastrarActivity;
import br.com.mcode.slider.activity.LoginActivity;


public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                .background(android.R.color.black)
                .fragment(R.layout.intro_cadastro)
                .build()
        );

    }

    public void btEntrar(View view){
        startActivity(new Intent(this, LoginActivity.class));

    }

    public void btCadastrar(View view){
        startActivity(new Intent(this, CadastrarActivity.class));
    }
}
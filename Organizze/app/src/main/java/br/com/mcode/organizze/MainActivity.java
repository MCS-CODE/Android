package br.com.mcode.organizze;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import br.com.mcode.organizze.activity.CadastroActivity;
import br.com.mcode.organizze.activity.LoginActivity;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_cadastro)
                .background(android.R.color.darker_gray)
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
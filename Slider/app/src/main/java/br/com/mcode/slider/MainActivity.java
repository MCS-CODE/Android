package br.com.mcode.slider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

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
}
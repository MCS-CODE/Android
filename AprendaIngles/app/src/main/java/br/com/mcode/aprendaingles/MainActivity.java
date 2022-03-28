package br.com.mcode.aprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.mcode.aprendaingles.fragments.animal.AnimaisFragment;
import br.com.mcode.aprendaingles.fragments.letras.VogaisFragment;
import br.com.mcode.aprendaingles.fragments.numeros.NumerosFragment;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter fragmentPagerItemAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add(R.string.animais_title, AnimaisFragment.class)
                        .add(R.string.numeros_title, NumerosFragment.class)
                        .add(R.string.vogais_title, VogaisFragment.class)
                .create()
        );

        viewPager.setAdapter(fragmentPagerItemAdapter);
        smartTabLayout.setViewPager(viewPager);

    }
}
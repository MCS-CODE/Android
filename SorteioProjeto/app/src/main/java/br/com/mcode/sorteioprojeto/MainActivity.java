package br.com.mcode.sorteioprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortear(View view){
        int numero = new Random().nextInt(11);

        TextView txt = findViewById(R.id.txt_resultado);

        txt.setText(""+numero);
    }

}
package br.com.mcode.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ResultadoActivity2 extends AppCompatActivity {

    private Button btnVoltar;
    private ImageView imgResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado2);

        btnVoltar = findViewById(R.id.button_voltar);
        imgResultado = findViewById(R.id.image_resultado);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                //posso chamar a activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                 */
                //Posso usar o metodo finsh() para fechar a activity
                finish();
            }
        });

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        if (numero == 0){//Cara
            imgResultado.setImageResource(R.drawable.moeda_cara);
        }else {//Coroa
            imgResultado.setImageResource(R.drawable.moeda_coroa);
        }
    }
}
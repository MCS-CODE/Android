package br.com.mcode.passandodadosparaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.button_enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                //instanciando um objeto
                Usuario usuario = new Usuario("Marcio Cruz da Silva", "m.c.s@msn.com");


                //passar dados
                intent.putExtra("nome", "Márcio Cruz da Siva");
                intent.putExtra("idade", 35);
                //passando um objeto
                intent.putExtra("objeto", usuario);
                startActivity(intent);
            }
        });
    }
}
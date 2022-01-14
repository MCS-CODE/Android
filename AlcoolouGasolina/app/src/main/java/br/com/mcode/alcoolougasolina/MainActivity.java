package br.com.mcode.alcoolougasolina;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoGasolina, precoAlcool;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoGasolina = findViewById(R.id.preco_gasolina);
        precoAlcool = findViewById(R.id.preco_alcool);
        textResultado = findViewById(R.id.text_resultado);

    }

    public void calcular(View view){
       //recuperar os valores digitados
        String preco_alcool = precoAlcool.getText().toString();
        String preco_gasolina = precoGasolina.getText().toString();

        //Validar campos


    }


}
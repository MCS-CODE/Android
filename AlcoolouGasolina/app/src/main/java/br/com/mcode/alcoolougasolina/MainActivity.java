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
        boolean camposValidos = validarCanpos(preco_alcool, preco_gasolina);

        if (camposValidos){
            //Converter string para números
            Double valorAlcool = Double.parseDouble(preco_alcool);
            Double valorGaslina = Double.parseDouble(preco_gasolina);

            Double resultado = valorAlcool / valorGaslina;
            if (resultado >= 0.7){
                textResultado.setText("Melhor utilizar gasolina ;)");
            }else {
                textResultado.setText("Melhor utilizar alcool ;)");
            }

        }
    }

    public boolean validarCanpos(String pAlcool, String pGasolina){

        boolean camposValidos = true;

        if (pAlcool == null || pAlcool.equalsIgnoreCase("")){
            camposValidos  = false;
        } else if (pGasolina == null || pGasolina.equalsIgnoreCase("")){
            camposValidos = false;
        }
        return camposValidos;
    }
}
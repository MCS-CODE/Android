package br.com.mcode.calculadoradegorjeta;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;
    private TextInputEditText textAviso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);


        //Add listener seekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    porcentagem = i;
                    textPorcentagem.setText(Math.round(porcentagem) + "%");
                    calcularGorgeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcularGorgeta(){

        String valor = editValor.getText().toString();
        if(valor == null || valor.equalsIgnoreCase("")){

            Toast.makeText(getApplicationContext(),
                    "Porvafor digite o valor da conta!",
                    Toast.LENGTH_SHORT).show();
        }else{
            //converter string para dooble
            double valorConta = Double.parseDouble(valor);

            //calcular gorjeta total
            //double valorGorgeta = (valorConta / 100) * seekBarGorjeta.getProgress() + valorConta;
            double valorGorgeta = valorConta * (porcentagem/100);

            //exibir gorjeta total
            //double totalGorjeta = (valorConta / 100) * seekBarGorjeta.getProgress();
            double totalGorjeta = valorConta + valorGorgeta;

            //textGorjeta.setText("R$ " + Math.round(valorGorgeta));
            textGorjeta.setText("R$ " + valorGorgeta);

            textTotal.setText("R$ " + totalGorjeta);
        }


    }


}
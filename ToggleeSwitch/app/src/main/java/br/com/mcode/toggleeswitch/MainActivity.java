package br.com.mcode.toggleeswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch switchSenha;
    private ToggleButton toggleButtonSenha;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSenha = findViewById(R.id.switchSenha);
        toggleButtonSenha = findViewById(R.id.toggleButtonSenha);
        textResultado = findViewById(R.id.textResultado);
    }

    public void enviar(View view){

        if (switchSenha.isChecked()){
            textResultado.setText("switch ligado");
        }else {
            textResultado.setText("switch desligado");
        }
    }
}
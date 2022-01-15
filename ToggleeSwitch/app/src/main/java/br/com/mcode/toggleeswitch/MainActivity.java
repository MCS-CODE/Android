package br.com.mcode.toggleeswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch switchSenha;
    private ToggleButton toggleButtonSenha;
    private TextView textResultado;
    private CheckBox lembrtarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSenha = findViewById(R.id.switchSenha);
        toggleButtonSenha = findViewById(R.id.toggleButtonSenha);
        textResultado = findViewById(R.id.textResultado);
        lembrtarSenha = findViewById(R.id.checkBoxSenha);

        adicionarListener();
    }

    public void enviar(View view){

        if (switchSenha.isChecked()){
            textResultado.setText("btn_enviar_ligado");
        }else {
            textResultado.setText("btn_enviar_desligado");
        }
    }

    public void adicionarListener(){
        lembrtarSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (lembrtarSenha.isChecked()){
                    textResultado.setText("ligado");
                }else {
                    textResultado.setText("desligado");
                }
            }
        });
    }
}
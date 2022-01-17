package br.com.mcode.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarEscala;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarEscala = findViewById(R.id.seekBarEscala);
        txtResultado = findViewById(R.id.textResultado);

        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtResultado.setText("progresso: "+ i + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtResultado.setText("tocar");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtResultado.setText("soltar");
            }
        });
    }

    public void escala(View view){
        txtResultado.setText("escolhido " + seekBarEscala.getProgress());
    }
}
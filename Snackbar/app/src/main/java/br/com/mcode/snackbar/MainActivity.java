package br.com.mcode.snackbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btnSnacbar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSnacbar = findViewById(R.id.button_snackbar);


        btnSnacbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar = Snackbar.make(
                        view,
                        "Botão snackbar",
                        Snackbar.LENGTH_SHORT
                ).setAction("confirmar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btnSnacbar.setText("btn Alterado");
                    }
                    //muda a cor do texto
                }).setActionTextColor(getResources().getColor(R.color.purple_700));


                snackbar.show();
                //Fechar snackbar
                snackbar.dismiss();
            }
        });






    }


}
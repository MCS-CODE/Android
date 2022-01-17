package br.com.mcode.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal, progressBarCircular;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular.setVisibility(View.GONE);

    }

    public void carregarProgresssBar(View view){
        //progresBarHorizontal
        this.progresso++;
        progressBarHorizontal.setProgress(this.progresso);

        //progresBarCircular
        progressBarCircular.setVisibility(View.VISIBLE);
        if (this.progresso == 10){
            progressBarCircular.setVisibility(View.GONE);
        }
    }
}
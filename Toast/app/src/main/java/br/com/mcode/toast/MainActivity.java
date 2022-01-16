package br.com.mcode.toast;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirToast(View view){
/*
        Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso",
                Toast.LENGTH_LONG
        ).show();

 */
        //Toast personalizado
        ImageView image = new ImageView(getApplicationContext());
        image.setImageResource(android.R.drawable.alert_dark_frame);

        TextView txtToast = new TextView(getApplicationContext());
        txtToast.setBackgroundResource(R.color.purple_500);
        txtToast.setText("Óla toast :)");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        //toast.setView(image);
        toast.setView(txtToast);
        toast.show();
    }


}
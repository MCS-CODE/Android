package br.com.mcode.arletdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlertDialog(View view){
        //Instanciar AlertDialog

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //Configurar titulo de msn

        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da Dialog");
        //permitir usuario sair da tela do alertdialog
        dialog.setCancelable(false);
        dialog.setIcon(android.R.drawable.star_big_on);

        //Configurar açoes para sim e nao
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplication(),
                        "Você clicou sim",
                        Toast.LENGTH_SHORT
                        ).show();

            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplication(),
                        "Você clicou no não",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
    }
}
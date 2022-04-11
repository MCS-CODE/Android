package br.com.mcode.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Criar menu customizado
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflar é Converter um arquivo xml em uma view
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // Adicionar evento de click no menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSalvar:
                Toast.makeText(MainActivity.this,"Salvar",Toast.LENGTH_LONG).show();
                //Log.i("click","Salvar");
                break;
            case R.id.itemEditar:
                Toast.makeText(MainActivity.this,"Editar",Toast.LENGTH_LONG).show();
               // Log.i("click","Editar");
                break;
            case R.id.itemConfiracao:
                Toast.makeText(MainActivity.this,"Configurações",Toast.LENGTH_LONG).show();
                //Log.i("click","Configuração");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
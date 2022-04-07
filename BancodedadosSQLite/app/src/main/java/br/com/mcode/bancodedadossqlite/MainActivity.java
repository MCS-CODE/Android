package br.com.mcode.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criar db
            SQLiteDatabase db = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            //db.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3)) ");
            //db.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3)) ");

            //Inserir dados

            //db.execSQL("INSERT INTO pessoas(nome, idade) VALUES('MarcioCruz', 35)");
            //db.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Adilma', 35)");
            //db.execSQL("INSERT INTO pessoas(nome, idade) VALUES('John', 5)");
            //db.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Dilma', 55)");
            //db.execSQL("INSERT INTO pessoas(nome, idade) VALUES('mcs', 107)");
            //db.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Romario', 65)");
            //db.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Ana', 17)");






            //Recuperar dados
            //String consulta = "SELECT id, nome, idade FROM pessoas ";
            String consulta = "SELECT * FROM pessoas ";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'marcio' AND idade = 35";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade >= 35 OR idade = 4";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome IN('marcio', 'john')";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 30 AND 35";
            //String filtro = "mar";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%" + filtro + "%' ";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade ASC ";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade DESC ";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY nome ASC LIMIT 3";
            Cursor cursor = db.rawQuery(consulta, null);

            //Atualizando dados
            //db.execSQL("UPDATE pessoas SET nome = 'MarcioCruz' WHERE id = 1");

            //Deletando tabela
            //db.execSQL("DROP TABLE pessoas");

            // Deletando Registros do db
            //db.execSQL("DELETE FROM pessoas WHERE id = 5");
            // Deleta todos os registros da tabela
            //db.execSQL("DELETE FROM pessoas");


            //Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceId = cursor.getColumnIndex("id");

            cursor.moveToFirst();
            while (cursor != null){

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);

                Log.i("RESULTADO-id ",id +" nome: " +  nome + "  idade: " + idade);
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
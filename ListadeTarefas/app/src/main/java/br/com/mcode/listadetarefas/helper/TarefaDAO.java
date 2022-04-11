package br.com.mcode.listadetarefas.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.mcode.listadetarefas.model.Tarefa;

public class TarefaDAO implements ITarefaDAO{
    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();


    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", tarefa.getNome());

        try {

            escreve.insert(DbHelper.TABELA_TAREFAS, null, contentValues);
            Log.e("INFO", "Tarefa salva com sucesso");

        }catch (Exception e){
            Log.e("INFO", "Erro ao salvar tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", tarefa.getNome());
        try {
            String[] args = {tarefa.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, contentValues, "id = ?", args);
            Log.e("INFO", "Tarefa atualizada com sucesso");

        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try {
            String[] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS, "id = ?", args);
            Log.e("INFO", "Tarefa removida com sucesso");

        }catch (Exception e){
            Log.e("INFO", "Erro ao remover tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Tarefa> listar() {
        List<Tarefa> tarefaList = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + ";";

        Cursor cursor = ler.rawQuery(sql, null);

        while (cursor.moveToNext()){

            Tarefa tarefa = new Tarefa();

            @SuppressLint("Range") Long id = cursor.getLong(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String nomeTarefa = cursor.getString(cursor.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNome(nomeTarefa);

            tarefaList.add(tarefa);
        }
        return tarefaList;
    }
}

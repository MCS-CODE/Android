package br.com.mcode.listadetarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import br.com.mcode.listadetarefas.R;
import br.com.mcode.listadetarefas.databinding.ActivityAdicionarTarefasBinding;
import br.com.mcode.listadetarefas.helper.TarefaDAO;
import br.com.mcode.listadetarefas.model.Tarefa;

public class AdicionarTarefasActivity extends AppCompatActivity {

    private ActivityAdicionarTarefasBinding bindingTarefas;
    private Tarefa tarefaAtual;
    private TextInputEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefas);

        bindingTarefas = ActivityAdicionarTarefasBinding.inflate(getLayoutInflater());
        setContentView(bindingTarefas.getRoot());

        editText = findViewById(R.id.text_tarefa);

        // Recuperar tarefa caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");
        // Configurando a tarefa na caixa de texto
        if (tarefaAtual != null ){
            editText.setText(tarefaAtual.getNome());
        }


        bindingTarefas.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_tarefas,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_salvar:
                // Salvar item
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                String nomeTarefa = editText.getText().toString();


                if(tarefaAtual != null){//Editar
                    if (!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNome(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

                        // Atualizar no banco de dados
                        if (tarefaDAO.atualizar(tarefa)){
                            finish();
                            Toast.makeText(this,"Tarefa atualizada com sucesso", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this,"Erro ao atualizar tarefa", Toast.LENGTH_SHORT).show();
                        };
                    }

                }else {//Salvar
                    if (!nomeTarefa.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNome(nomeTarefa);
                        if (tarefaDAO.salvar(tarefa)){
                            finish();
                            Toast.makeText(this,"Tarefa salva com sucesso", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this,"Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
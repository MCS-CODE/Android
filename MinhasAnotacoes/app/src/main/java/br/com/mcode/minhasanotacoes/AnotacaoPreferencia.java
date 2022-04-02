package br.com.mcode.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencia {

    private Context context;
    private SharedPreferences sharedPreferences;
    private final String ARQUIVO_ANOTACAO = "Anotacao.preferencias";
    private SharedPreferences.Editor editor;
    private final String CHAVE_NOME = "nome";

    public AnotacaoPreferencia(Context c) {
        this.context = c;
        sharedPreferences = context.getSharedPreferences(ARQUIVO_ANOTACAO, 0);
        editor = sharedPreferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao(){
        return sharedPreferences.getString(CHAVE_NOME,"");
    }


}

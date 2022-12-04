package br.com.mcode.organizze.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import br.com.mcode.organizze.config.ConfigFirebase;
import br.com.mcode.organizze.helper.Base64Custom;
import br.com.mcode.organizze.helper.DateCustom;

public class Movimentacao {
    private String data;
    private String categoria;
    private String descricao;
    private String tipo;
    private double valor;

    public Movimentacao() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }

    public void salvar(String data){

        //Recuperando o email do usuario e passando para base64

        FirebaseAuth autenticacao = ConfigFirebase.getFirebadeAutenticacao();
        String idUser = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());

        String mesAno = DateCustom.mesAnoDespesa(data);
        DatabaseReference databaseReference = ConfigFirebase.getFirebaseDatabase();
        databaseReference.child("movimentacao")
                .child(idUser)
                .child(mesAno)
                .push()
                .setValue(this);
    }
}

package br.com.mcode.organizze.config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfigFirebase {
    private static FirebaseAuth autenticacao;

    public static FirebaseAuth getFirebadeAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }
}

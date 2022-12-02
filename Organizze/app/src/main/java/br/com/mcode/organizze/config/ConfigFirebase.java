package br.com.mcode.organizze.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigFirebase {
    private static FirebaseAuth autenticacao;
    private static DatabaseReference fireBaseDataBase;

    //Retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebadeAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

    //Retorna a instancia do FirebaseDataBase
    public static DatabaseReference getFirebaseDatabase(){
        if(fireBaseDataBase == null){
            fireBaseDataBase = FirebaseDatabase.getInstance().getReference();
        }
        return fireBaseDataBase;
    }
}

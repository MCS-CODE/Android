package br.com.mcode.myapplicationfirebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    // Recuperando objeto DB
    private DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();

    // Recuperando objeto Auth
    private FirebaseAuth firebaseAuthUser = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criando referencia
        DatabaseReference UserDatabaseRef = mDatabaseRef.child("usuarios");
        Usuario usuario = new Usuario();
        usuario.setNome("Jose");
        usuario.setIdade(31);

        UserDatabaseRef.push().setValue(usuario);

        /*
        //Criando referencias
        DatabaseReference usuarios = mDatabaseRef.child("usuarios");
        DatabaseReference produtos = mDatabaseRef.child("produtos");


        Salvando dados no firebase


        //Criando objetos
        Usuario usuario = new Usuario();
        usuario.setNome("Marcio");
        usuario.setIdade(35);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Adilma");
        usuario2.setIdade(33);

        Produto produto = new Produto();
        produto.setDescricao("Ventilador");
        produto.setQuantidade(2);
        produto.setPreco(259.99);

        Produto produto2 = new Produto();
        produto2.setDescricao("Geladeira");
        produto2.setQuantidade(1);
        produto2.setPreco(3459.99);


        //Salvando objetos no firebase
        usuarios.child("001").setValue(usuario);
        usuarios.child("002").setValue(usuario2);

        produtos.child("001").setValue(produto);
        produtos.child("002").setValue(produto2);
         */
        /*
        //Recuperando dados no firebase

        //Recuperando usuario especifico
        DatabaseReference usuarios = mDatabaseRef.child("usuarios").child("001");

        DatabaseReference produtos = mDatabaseRef.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("Firebase", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
         */
        /*
        // Cadastro de usuarios
        firebaseAuthUser.createUserWithEmailAndPassword("mcode.microsfire@outlook.com", "mcs007700")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("CreateUser", "SUCESSO-> ao criar user");
                        }else {
                            Log.i("CreateUser", "ERRO-> ao criar user");
                        }
                    }
                });
         */
        /*
        //verificar usuario logado
        if (firebaseAuthUser.getCurrentUser() != null){
            Log.i("user", "logado");
        }else {
            Log.i("user", "deslogado");
        }
        */
        /*
        // Deslogar usuario
        firebaseAuthUser.signOut();
        */
        /*
        // Logando usuario
        firebaseAuthUser.signInWithEmailAndPassword("mcode.microsfire@outlook.com", "mcs007700")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("LogandoUser", "User Logou");
                        }else {
                            Log.i("LogandoUser", "User NÃO Logou");
                        }
                    }
                });
         */


    }

}

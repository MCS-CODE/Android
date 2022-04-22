package br.com.mcode.myapplicationfirebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    // Atributos para upload
    private ImageView imageFoto;
    private Button buttonUpload;

    /*
    // Recuperando objeto DB
    private DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();

    // Recuperando objeto Auth
    private FirebaseAuth firebaseAuthUser = FirebaseAuth.getInstance();
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Upload de Imagens
        imageFoto = findViewById(R.id.image_foto);
        buttonUpload = findViewById(R.id.button_upload);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the data from an ImageView as bytes
                imageFoto.setDrawingCacheEnabled(true);
                imageFoto.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imageFoto.getDrawable()).getBitmap();

                // Comprimindo bitmap para um formato png/jpeg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                // Converte o baos para pixel brutos em uma matrix de bytes dados da imagem
                byte[] dadosImagem = baos.toByteArray();

                // Definindo nos para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagemFolder = storageReference.child("IMAGENS");
                StorageReference imagemRef = imagemFolder.child("celular.jpeg");

                // Retorna o objeto que irá controlar o upload
                UploadTask uploadTask = imagemRef.putBytes(dadosImagem);
                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(MainActivity.this, "Upload da imagem falhou " + exception.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        // ...
                        taskSnapshot.getMetadata();
                        Toast.makeText(MainActivity.this, "Upload da imagem feito com sucesso ",
                                Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


        /*
        // Criando referencia
        DatabaseReference UserDatabaseRef = mDatabaseRef.child("usuarios");
        Usuario usuario = new Usuario();
        usuario.setNome("Jose");
        usuario.setIdade(31);

        UserDatabaseRef.push().setValue(usuario);
        */
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

        // Pegando usuario pelo id

        //DatabaseReference usuarios = mDatabaseRef.child("usuarios");
        //DatabaseReference usuarioPesquisa = usuarios.child("-N-k8NUVjE_6_ncOQU6V");

        // Pesquisa ordenado pelo nome
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Marcio Cruz");

        //Pesquisa ordenado pelos (2) primeiros
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);

        //Pesquisa ordenado pelos (2) ultimos
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);

        //Pesquisa pelos >= maior ou igual
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(35);

        //Pesquisa pelos <= menor ou igual
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(40);

        /*//Pesquisa entre dois valores
        Query usuarioPesquisa = usuarios.orderByChild("idade")
                .startAt(30)
                .endAt(40);*/
/*
        //Filtrar palavras
        Query usuarioPesquisa = usuarios.orderByChild("nome")
                .startAt("A")
                .endAt("A" + "\uf8ff");

        //Criando um observer de eventos
        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Usuario usuario = snapshot.getValue(Usuario.class);
                //Log.i("UserDados: ", "nome: " + usuario.getNome() + " idade: " + usuario.getIdade());
                Log.i("UserDados: ", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



 */



    }

}

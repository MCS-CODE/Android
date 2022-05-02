package br.com.mcode.myapplicationfirebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.UUID;
public class MainActivity extends AppCompatActivity {
    // Atributos para upload
    private ImageView imageFoto;
    private Button buttonUpload;


    // Recuperando objeto DB
    private DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();

    // Recuperando objeto Auth
    private FirebaseAuth firebaseAuthUser = FirebaseAuth.getInstance();


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
                //Nome do arquivo

                //String nomeArquivo = UUID.randomUUID().toString();
                //final StorageReference imagemRef = imagemFolder.child( nomeArquivo + ".jpeg");
                StorageReference imagemRef = imagemFolder.child("celular.jpeg");

                //Fazendo download de imagem que esta no Storage para uma imageview
                Glide.with(MainActivity.this)
                        .load(imagemRef)
                        .into(imageFoto);



                /*
                // Deletando um arquivo
                final StorageReference imagemRef = imagemFolder.child("8127c575-2d89-4fd6-a621-f4bf0844b981.jpeg");
                imagemRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erro ao deletar a imagem " +  e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Sucesso ao deletar a imagem ",
                                Toast.LENGTH_SHORT).show();
                    }
                });*/


                /*// Retorna o objeto que irá controlar o upload
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
                        // Recuperando a url
                        imagemRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                               Uri url = task.getResult();
                                Toast.makeText(MainActivity.this, "Upload da imagem feito com sucesso " + url.toString(),
                                        Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });//end upload

                 */



            }
        }); //End buttonUpload


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

        /*// Logando usuario

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
                });*/


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

    // methold for download in imageview

    public void loadWithGlide() {
        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();

        // ImageView in your Activity
        ImageView imageView = findViewById(R.id.image_foto);

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        Glide.with(this /* context */)
                .load(storageReference)
                .into(imageView);
        // [END storage_load_with_glide]
    }

}



package br.com.mcode.pedrapapaeltesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void selecionarPedra(View view){
        opcaoSelecionada("pedra");
        mudarCorTextoDescricao("pedra");


    }

    public void selecionarPapel(View view){
        opcaoSelecionada("papel");
        mudarCorTextoDescricao("papel");

    }

    public void selecionarTesoura(View view){
        opcaoSelecionada("tesoura");
        mudarCorTextoDescricao("tesoura");

    }

    public void opcaoSelecionada(String op){

        TextView textView = findViewById(R.id.txt_escolha);
        TextView textDescricao = findViewById(R.id.txt_descrição);

        int posicao = new Random().nextInt(3);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opApp = opcoes[posicao];


        ImageView img = findViewById(R.id.img_escolha_maquina);

        switch (opApp){
            case "pedra":
                img.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                img.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                img.setImageResource(R.drawable.tesoura);
                break;
            default:
                img.setImageResource(R.drawable.padrao);
        }

        if (op == "pedra" && opApp == "papel"){
            textView.setText("Você PERDEU :(");
            textDescricao.setText("O papel embrulha a pedra.");
        }else if(op == "papel" && opApp == "pedra"){
            textView.setText("Você GANHOU :)");
            textDescricao.setText("O papel embrula a pedra.");
        }else if(op == "papel" && opApp == "tesoura"){
            textView.setText("Você PERDEU :(");
            textDescricao.setText("A tesoura corta o papel.");
        }else if (op == "tesoura" && opApp == "papel"){
            textView.setText("Você GANHOU :)");
            textDescricao.setText("A tesoura corta o papel.");
        }else if (op == "pedra" && opApp == "tesoura"){
            textView.setText("Você GANHOU :)");
            textDescricao.setText("A pedra amassa a tesoura.");
        }else if (op == "tesoura" && opApp == "pedra"){
            textView.setText("Você PERDEU :(");
            textDescricao.setText("A pedra amassa a tesoura.");
        }else {
            textView.setText("Escolha uma opção!!!");
            textDescricao.setText("Escolhemos o mesmo item...");
        }
    }

    public void mudarCorTextoDescricao(String opcao){
        TextView txtWhitePedra = findViewById(R.id.text_name_pedra);
        TextView txtWhitePapel = findViewById(R.id.text_name_papel);
        TextView txtWhiteTesoura = findViewById(R.id.text_name_tesoura);

        int colorTextDescricao = getResources().getColor(R.color.txt_PPT_green);
        int colorTextDescricaoNeutra = getResources().getColor(R.color.txt_PPT);

        switch (opcao){
            case "pedra":
                txtWhitePedra.setTextColor(colorTextDescricao);
                txtWhitePapel.setTextColor(colorTextDescricaoNeutra);
                txtWhiteTesoura.setTextColor(colorTextDescricaoNeutra);
                break;
            case "papel":
                txtWhitePapel.setTextColor(colorTextDescricao);
                txtWhitePedra.setTextColor(colorTextDescricaoNeutra);
                txtWhiteTesoura.setTextColor(colorTextDescricaoNeutra);
                break;
            case "tesoura":
                txtWhiteTesoura.setTextColor(colorTextDescricao);
                txtWhitePapel.setTextColor(colorTextDescricaoNeutra);
                txtWhitePedra.setTextColor(colorTextDescricaoNeutra);
                break;
        }


    }
}
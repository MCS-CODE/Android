package br.com.mcode.frasesdodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] frases = {
            "Que o dia comece bem e termine ainda melhor.",
            "Pra hoje: sorrisos bobos, uma mente tranquila e um coração cheio de paz.",
            "Às vezes as coisas demoram, mas acontecem. O importante é saber esperar e não perder a fé!",
            "Imagine uma nova história para a sua vida e acredite nela.",
            "Nem todos os dias são bons, mas há algo bom em cada dia.",
            "Sorria! Deus acaba de te dar um novo dia e coisas extraordinárias podem acontecer se você acreditar.",
            "Levanta, sacode a poeira e dá a volta por cima.",
            "Um pequeno pensamento positivo pela manhã pode mudar todo o seu dia.",
            "Que os dias ruins se tornem raros e os bons virem rotina.",
            "Todo dia é uma ocasião especial. Guarde apenas o que tem que ser guardado: lembranças, sorrisos, poemas, cheiros, saudades, momentos…",
            "Cultive o amor, tristeza não dá flor.",
            "Não se preocupe em entender, viver ultrapassa qualquer entendimento.",
            "Seja a mudança que você deseja ver no mundo.",
            "Só existem dois dias no ano em que nada pode ser feito. Um se chama ontem e o outro se chama amanhã," +
                    " portanto hoje é o dia certo para amar, acreditar, fazer e principalmente viver.",
            "A mudança que você quer está na decisão que você toma.",
            "Viva sua vida com quem te deixa feliz e não com quem você tenha que agradar.",
            "Na plenitude da felicidade, cada dia é uma vida inteira.",
            "Sonhar, viver e todo dia agradecer.",
            "Que o dia seja leve, que a tristeza seja breve e que o dia seja feliz.",
            "A maior conquista da vida é estar em paz.",
            "A simplicidade é o mais alto grau de sofisticação.",
            "Todo mundo crê em algo. Eu creio que tomarei outra xícara de café.",
            "Pare de reclamar da segunda-feira e aproveite a semana.",
            "A forma que você decide enxergar as coisas faz toda a diferença.",
            "Você está vivendo aquilo que precisa viver, isso vai te fazer crescer.",
            "Situações difíceis constroem pessoas mais fortes.",
            "Um brinde ao que é vivido e não postado.",
            "Ninguém é o que já foi. Aceite a mudança.",
            "Comece acreditando que é possível.",
            "Cada segundo é tempo para mudar tudo para sempre.",
            "Não há dias cinzentos para quem sonha colorido.",
            "Você nunca encontrará um arco-íris se estiver olhando para baixo.",
            "O sol nunca vai embora para quem tem alma de girassol.",
            "Já que é preciso aceitar a vida, que seja então corajosamente."

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarFrases(View view){
        int numero = new Random().nextInt(35);

        TextView txt = findViewById(R.id.id_frases);
        txt.setText(frases[numero]);
    }
}
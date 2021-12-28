package br.com.mcode.caixinhadepromessas;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    String[] promessas = {
            "Tu conservarás em paz aquele cuja mente está firme em ti; porque ele confia em ti. (Isaías 26:3)",
            "E em nenhum outro há salvação, porque também debaixo do céu nenhum outro nome há, dado entre os homens, pelo qual devamos ser salvos. (Atos 4:12)",
            "Porque Deus enviou o seu Filho ao mundo não para que condenasse o mundo, mas para que o mundo fosse salvo por ele. (João 3:17)",
            "Deleita-te também no Senhor, e ele te concederá o que deseja o teu coração. (Salmos 37:4)",
            "Cheguemos, pois, com confiança ao trono da graça, para que possamos alcançar misericórdia e achar graça, a fim de sermos ajudados em tempo oportuno. (Hebreus 4:16)",
            "Como o orvalho do Hermom, que desce sobre os montes de Sião; porque ali o Senhor ordena a bênção e a vida para sempre. (Salmos 133:3)",
            "Tendo por certo isto mesmo: que aquele que em vós começou a boa obra a aperfeiçoará até ao Dia de Jesus Cristo. (Filipenses 1:6)",
            "pelas quais ele nos tem dado grandíssimas e preciosas promessas, para que por elas fiqueis participantes da natureza divina, havendo escapado da corrupção, que, pela concupiscência, há no mundo, (2 Pedro 1:4)",
            "não deixando a nossa congregação, como é costume de alguns; antes, admoestando-nos uns aos outros; e tanto mais quanto vedes que se vai aproximando aquele Dia. (Hebreus 10:25)",
            "nem a altura, nem a profundidade, nem alguma outra criatura nos poderá separar do amor de Deus, que está em Cristo Jesus, nosso Senhor! (Romanos 8:39)",
            "Nisto todos conhecerão que sois meus discípulos, se vos amardes uns aos outros. (João 13:35)",
            "Porque não temos um sumo sacerdote que não possa compadecer-se das nossas fraquezas; porém um que, como nós, em tudo foi tentado, mas sem pecado. (Hebreus 4:15)",
            "Porque os meus pensamentos não são os vossos pensamentos, nem os vossos caminhos, os meus caminhos, diz o Senhor. (Isaías 55:8)",
            "Assim resplandeça a vossa luz diante dos homens, para que vejam as vossas boas obras e glorifiquem o vosso Pai, que está nos céus. (Mateus 5:16)",
            "É como o óleo precioso sobre a cabeça, que desce sobre a barba, a barba de Arão, e que desce à orla das suas vestes.” (Salmos 133:2)",
            "E Jesus disse-lhe: Amarás o Senhor, teu Deus, de todo o teu coração, e de toda a tua alma, e de todo o teu pensamento.” (Mateus 22:37)",
            "E, tudo quanto fizerdes, fazei-o de todo o coração, como ao Senhor e não aos homens, (Colossenses 3:23)",
            "E, chegando-se Jesus, falou-lhes, dizendo: É-me dado todo o poder no céu e na terra.” (Mateus 28:18)",
            "Não se aparte da tua boca o livro desta Lei; antes, medita nele dia e noite, para que tenhas cuidado de fazer conforme tudo quanto nele está escrito; porque, então, farás prosperar o teu caminho e, então, prudentemente te conduzirás. (Josué 1:8)",
            "levando ele mesmo em seu corpo os nossos pecados sobre o madeiro, para que, mortos para os pecados, pudéssemos viver para a justiça; e pelas suas feridas fostes sarados. (1 Pedro 2:24)",
            "Porque estou certo de que nem a morte, nem a vida, nem os anjos, nem os principados, nem as potestades, nem o presente, nem o porvir, (Romanos 8:38)",
            "sabendo que a prova da vossa fé produz a paciência.” (Tiago 1:3)",
            "Bem-aventurado o varão que sofre a tentação; porque, quando for provado, receberá a coroa da vida, a qual o Senhor tem prometido aos que o amam. (Tiago 1:12)",
            "Mas a todos quantos o receberam deu-lhes o poder de serem feitos filhos de Deus: aos que creem no seu nome, (João 1:12)",
            "De sorte que a fé é pelo ouvir, e o ouvir pela palavra de Deus. (Romanos 10:17)",
            "Ele te declarou, ó homem, o que é bom; e que é o que o Senhor pede de ti, senão que pratiques a justiça, e ames a beneficência, e andes humildemente com o teu Deus? (Miquéias 6:8)",
            "Ninguém tem maior amor do que este: de dar alguém a sua vida pelos seus amigos. (João 15:13)",
            "Porque a palavra de Deus é viva, e eficaz, e mais penetrante do que qualquer espada de dois gumes, e penetra até à divisão da alma, e do espírito, e das juntas e medulas, e é apta para discernir os pensamentos e intenções do coração. (Hebreus 4:12)",
            "Deixo-vos a paz, a minha paz vos dou; não vo-la dou como o mundo a dá. Não se turbe o vosso coração, nem se atemorize. (João 14:27)",
            "Oh! Quão bom e quão suave é que os irmãos vivam em união! (Salmos 133:1)",
            "Conhecemos o amor nisto: que ele deu a sua vida por nós, e nós devemos dar a vida pelos irmãos. (1 João 3:16)",
            "Ou não sabeis que o nosso corpo é o templo do Espírito Santo, que habita em vós, proveniente de Deus, e que não sois de vós mesmos? (1 Coríntios 6:19)",
            "No princípio, era o Verbo, e o Verbo estava com Deus, e o Verbo era Deus. (João 1:1)",
            "O meu Deus, segundo as suas riquezas, suprirá todas as vossas necessidades em glória, por Cristo Jesus. (Filipenses 4:19)",
            "Ora, estes foram mais nobres do que os que estavam em Tessalônica, porque de bom grado receberam a palavra, examinando cada dia nas Escrituras se estas coisas eram assim. (Atos 17:11)",
            "Confessai as vossas culpas uns aos outros e orai uns pelos outros, para que sareis; a oração feita por um justo pode muito em seus efeitos. (Tiago 5:16)",
            "Portanto, nós também, pois, que estamos rodeados de uma tão grande nuvem de testemunhas, deixemos todo embaraço e o pecado que tão de perto nos rodeia e corramos, com paciência, a carreira que nos está proposta, (Hebreus 12:1)",
            "Revesti-vos, pois, como eleitos de Deus, santos e amados, de entranhas de misericórdia, de benignidade, humildade, mansidão, longanimidade, (Colossenses 3:12)",
            "E criou Deus o homem à sua imagem; à imagem de Deus o criou; macho e fêmea os criou. (Gênesis 1:27)",
            "Porque o meu jugo é suave, e o meu fardo é leve.” (Mateus 11:30)",
            "Ora, àquele que é poderoso para fazer tudo muito mais abundantemente além daquilo que pedimos ou pensamos, segundo o poder que em nós opera, (Efésios 3:20)",
            "E disse-lhes Pedro: Arrependei-vos, e cada um de vós seja batizado em nome de Jesus Cristo para perdão dos pecados, e recebereis o dom do Espírito Santo. (Atos 2:38)",
            "Todos nós andamos desgarrados como ovelhas; cada um se desviava pelo seu caminho, mas o Senhor fez cair sobre ele a iniquidade de nós todos. (Isaías 53:6)",
            "Meus irmãos, tende grande gozo quando cairdes em várias tentações, (Tiago 1:2)",
            "Na verdade, na verdade vos digo que quem ouve a minha palavra e crê naquele que me enviou tem a vida eterna e não entrará em condenação, mas passou da morte para a vida. (João 5:24)",
            "Ora, sem fé é impossível agradar-lhe, porque é necessário que aquele que se aproxima de Deus creia que ele existe e que é galardoador dos que o buscam. (Hebreus 11:6)",
            "Disse-lhe Jesus: Eu sou a ressurreição e a vida; quem crê em mim, ainda que esteja morto, viverá; (João 11:25)",
            "Ora, o Deus de esperança vos encha de todo o gozo e paz em crença, para que abundeis em esperança pela virtude do Espírito Santo. (Romanos 15:13)",
            "Àquele que não conheceu pecado, o fez pecado por nós; para que, nele, fôssemos feitos justiça de Deus. (2 Coríntios 5:21)",
            "Verdadeiramente, ele tomou sobre si as nossas enfermidades e as nossas dores levou sobre si; e nós o reputamos por aflito, ferido de Deus e oprimido. (Isaías 53:4)",
            "Porque Deus não nos deu o espírito de temor, mas de fortaleza, e de amor, e de moderação. (2 Timóteo 1:7)",
            "Mas recebereis a virtude do Espírito Santo, que há de vir sobre vós; e ser-me-eis testemunhas tanto em Jerusalém como em toda a Judeia e Samaria e até aos confins da terra. (Atos 1:8)",
            "Tenho-vos dito isso, para que em mim tenhais paz; no mundo tereis aflições, mas tende bom ânimo; eu venci o mundo. (João 16:33)",
            "Tomai sobre vós o meu jugo, e aprendei de mim, que sou manso e humilde de coração, e encontrareis descanso para a vossa alma. (Mateus 11:29)",
            "E disse Deus: Façamos o homem à nossa imagem, conforme a nossa semelhança; e domine sobre os peixes do mar, e sobre as aves dos céus, e sobre o gado, e sobre toda a terra, e sobre todo réptil que se move sobre a terra. (Gênesis 1:26)",
            "não temas, porque eu sou contigo; não te assombres, porque eu sou o teu Deus; eu te esforço, e te ajudo, e te sustento com a destra da minha justiça. (Isaías 41:10)",
            "a saber: Se, com a tua boca, confessares ao Senhor Jesus e, em teu coração, creres que Deus o ressuscitou dos mortos, serás salvo. (Romanos 10:9)",
            "E disse-me: A minha graça te basta, porque o meu poder se aperfeiçoa na fraqueza. De boa vontade, pois, me gloriarei nas minhas fraquezas, para que em mim habite o poder de Cristo. (2 Coríntios 12:9)",
            "Sejam vossos costumes sem avareza, contentando-vos com o que tendes; porque ele disse: Não te deixarei, nem te desampararei. (Hebreus 13:5)",
            "Assim que, se alguém está em Cristo, nova criatura é: as coisas velhas já passaram; eis que tudo se fez novo. (2 Coríntios 5:17)",
            "Ora, a fé é o firme fundamento das coisas que se esperam e a prova das coisas que se não veem. (Hebreus 11:1)",
            "Vinde a mim, todos os que estais cansados e oprimidos, e eu vos aliviarei (Mateus 11:28)",
            "Não veio sobre vós tentação, senão humana; mas fiel é Deus, que vos não deixará tentar acima do que podeis; antes, com a tentação dará também o escape, para que a possais suportar. (1 Coríntios 10:13)",
            "Porque somos feitura sua, criados em Cristo Jesus para as boas obras, as quais Deus preparou para que andássemos nelas. (Efésios 2:10)",
            "lançando sobre ele toda a vossa ansiedade, porque ele tem cuidado de vós. (1 Pedro 5:7)",
            "olhando para Jesus, autor e consumador da fé, o qual, pelo gozo que lhe estava proposto, suportou a cruz, desprezando a afronta, e assentou-se à destra do trono de Deus. (Hebreus 12:2)",
            "Mas buscai primeiro o Reino de Deus, e a sua justiça, e todas essas coisas vos serão acrescentadas. (Mateus 6:33)",
            "Toda Escritura divinamente inspirada é proveitosa para ensinar, para redarguir, para corrigir, para instruir em justiça, (2 Timóteo 3:16)",
            "antes, santificai a Cristo, como Senhor, em vosso coração; e estai sempre preparados para responder com mansidão e temor a qualquer que vos pedir a razão da esperança que há em vós, (1 Pedro 3:15)",
            "Mas ele foi ferido pelas nossas transgressões e moído pelas nossas iniquidades; o castigo que nos traz a paz estava sobre ele, e, pelas suas pisaduras, fomos sarados. (Isaías 53:5)",
            "Contra essas coisas não há lei. (Gálatas 5:23)",
            "Porque o salário do pecado é a morte, mas o dom gratuito de Deus é a vida eterna, por Cristo Jesus, nosso Senhor. (Romanos 6:23)",
            "Não vem das obras, para que ninguém se glorie. (Efésios 2:9)",
            "Mas os que esperam no Senhor renovarão as suas forças e subirão com asas como águias; correrão e não se cansarão; caminharão e não se fatigarão. (Isaías 40:31)",
            "Não to mandei eu? Esforça-te e tem bom ânimo; não pasmes, nem te espantes, porque o Senhor, teu Deus, é contigo, por onde quer que andares. (Josué 1:9)",
            "E a paz de Deus, que excede todo o entendimento, guardará os vossos corações e os vossos sentimentos em Cristo Jesus. (Filipenses 4:7)",
            "Quanto ao mais, irmãos, tudo o que é verdadeiro, tudo o que é honesto, tudo o que é justo, tudo o que é puro, tudo o que é amável, tudo o que é de boa fama, se há alguma virtude, e se há algum louvor, nisso pensai. (Filipenses 4:8)",
            "Mas Deus prova o seu amor para conosco em que Cristo morreu por nós, sendo nós ainda pecadores. (Romanos 5:8)",
            "ensinando-as a guardar todas as coisas que eu vos tenho mandado; e eis que eu estou convosco todos os dias, até à consumação dos séculos. Amém! (Mateus 28:20)",
            "Disse-lhe Jesus: Eu sou o caminho, e a verdade, e a vida. Ninguém vem ao Pai senão por mim. (João 14:6)",
            "Porque todos pecaram e destituídos estão da glória de Deus (Romanos 3:23)",
            "Se confessarmos os nossos pecados, ele é fiel e justo para nos perdoar os pecados e nos purificar de toda injustiça. (1 João 1:9)",
            "Já estou crucificado com Cristo; e vivo, não mais eu, mas Cristo vive em mim; e a vida que agora vivo na carne vivo-a na fé do Filho de Deus, o qual me amou e se entregou a si mesmo por mim. (Gálatas 2:20)",
            "E ficou ali um ano e seis meses, ensinando entre eles a palavra de Deus. (Atos 18:11)",
            "E disse o Senhor, em visão, a Paulo: Não temas, mas fala e não te cales; (Atos 18:9)",
            "porque eu sou contigo, e ninguém lançará mão de ti para te fazer mal, pois tenho muito povo nesta cidade. (Atos 18:10)",
            "O ladrão não vem senão a roubar, a matar e a destruir; eu vim para que tenham vida e a tenham com abundância. (João 10:10)",
            "Rogo-vos, pois, irmãos, pela compaixão de Deus, que apresenteis o vosso corpo em sacrifício vivo, santo e agradável a Deus, que é o vosso culto racional. (Romanos 12:1)",
            "Mas o fruto do Espírito é: amor, gozo, paz, longanimidade, benignidade, bondade, fé, mansidão, temperança. (Gálatas 5:22)",
            "Porque pela graça sois salvos, por meio da fé; e isso não vem de vós; é dom de Deus. (Efésios 2:8)",
            "Portanto, ide, ensinai todas as nações, batizando-as em nome do Pai, e do Filho, e do Espírito Santo; (Mateus 28:19)",
            "Não estejais inquietos por coisa alguma; antes, as vossas petições sejam em tudo conhecidas diante de Deus, pela oração e súplicas, com ação de graças. (Filipenses 4:6)",
            "E não vos conformeis com este mundo, mas transformai-vos pela renovação do vosso entendimento, para que experimenteis qual seja a boa, agradável e perfeita vontade de Deus. (Romanos 12:2)",
            "Reconhece-o em todos os teus caminhos, e ele endireitará as tuas veredas. (Provérbios 3:6)",
            "Confia no Senhor de todo o teu coração e não te estribes no teu próprioentendimento. (Provérbios 3:5)",
            "No princípio, criou Deus os céus e a terra. (Gênesis 1:1)",
            "Posso todas as coisas naquele que me fortalece. (Filipenses 4:13)",
            "E sabemos que todas as coisas contribuem juntamente para o bem daqueles que amam a Deus, daqueles que são chamados por seu decreto. (Romanos 8:28)",
            "Porque eu bem sei os pensamentos que penso de vós, diz o Senhor; pensamentos de paz e não de mal, para vos dar o fim que esperais. (Jeremias 29:11)",
            "Porque Deus amou o mundo de tal maneira que deu o seu Filho unigênito, para que todo aquele que nele crê não pereça, mas tenha a vida eterna. (João 3:16)"

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void gerarPromessas(View view){

        Drawable border = getResources().getDrawable(R.drawable.border_arredondada);


        int[] bgTextPromessas = getResources().getIntArray(R.array.bg_text_promessas);
        int numeroBgTextPromessas = new Random().nextInt(bgTextPromessas.length);
        int txtPromessasWhite = getResources().getColor(R.color.txt_promesssas);

        int numeropromessas = new Random().nextInt(promessas.length);

        TextView txtPromessas = findViewById(R.id.txt_promessas);
        txtPromessas.setText(promessas[numeropromessas]);
        txtPromessas.setTextColor(txtPromessasWhite);
        txtPromessas.setBackgroundColor(bgTextPromessas[numeroBgTextPromessas]);


    }
}
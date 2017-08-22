package canatustecnologia.com.br.jogoforca.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by PATRICK on 30/12/2016.
 */
public class Palavras {

    private String[] palavras = new String[] {"AVIÃO", "AERONAVE", "AUTOMÓVEL", "MOTOCICLETA",
            "BICICLETA", "IATE", "NAVIO", "TERRA", "MERCÚRIO", "PLUTÃO", "MARTE", "JUPTER", "NETUNO",
            "ELEFANTE", "ESCORPIÃO", "RINOCERONTE", "DINOSSAURO", "REFRIGERADOR", "LIQUIDIFICADOR",
            "TELEVISOR", "POLTRONA", "SECADORA", "ESCORREDOR", "BRASIL", "ÁFRICA", "EUROPA", "AMSTERDÃ", "ESTADOS UNIDOS",
            "GRÉCIA", "ARGENTINA", "VENEZUELA", "BOTAFOGO", "SÃO PAULO", "FLAMENGO", "PALMEIRAS", "FLUMINENSE", "AMOR",
            "INTELECTUAL", "SÁBIO", "CULTURA", "SABEDORIA", "TUCANO", "BEIJA-FLOR", "ZEBRA", "CRUZEIRO", "COMPUTADOR",
            "FACULDADE", "PIPOCA", "MACARRÃO", "FEIJOADA", "SABÃO EM PÓ", "LAVANDERIA", "COZINHA", "CHURRASCO",
            "CATARINENSE", "AFRICANO", "BRASILEIRO", "AMERICANO", "GAÚCHO", "PARANAENSE", "MINEIRO", "SANTISTA",
            "LIXEIRO", "PROGRAMADOR", "LUMINÁRIA", "LUTADOR", "COZINHEIRO", "CARTEIRO", "VENDEDOR", "FLORICULTURA",
            "JAPÃO", "ARÁBIA SAUDITA", "EQUADOR", "MÉXICO", "PORTUGUAL", "ALEMANHA", "PROFESSOR", "CHAVEIRO", "DOCUMENTOS",
            "DOCUMENTÁRIO", "FAMÍLIA", "FAMILIARES", "LANCHONETE"};

    public Palavras() {
    }


    public String sorteio() {
        //db.getAllPalavras();
        //ArrayList<HashMap<String, String>> palavras =  db.getAllPalavras(); //
        //String palavraSorteada = palavras[(int)(random() * palavras.length())];
        return "";//palavraSorteada;
    }

    public static double random() {
        Random r = new Random();

        return r.nextDouble();
    }
}

package br.com.mcode.organizze.helper;


import android.util.Base64;

public class Base64Custom {

    public static String codificarBase64(String codificarTexto){
       return Base64.encodeToString(codificarTexto.getBytes(), Base64.DEFAULT).replaceAll(("\\n|\\r"), "");
    }

    public static String decodificarBase64(String textoCodificado){
        return new String(Base64.decode(textoCodificado, Base64.DEFAULT));
    }
}

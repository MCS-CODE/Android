package br.com.mcode.organizze.helper;

import java.text.SimpleDateFormat;
public class DateCustom {

    public static String dataAtual(){
        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/yyyy hh:mm:ss" );
        String dataString = simpleDateFormat.format(data);
        return dataString;
    }
}

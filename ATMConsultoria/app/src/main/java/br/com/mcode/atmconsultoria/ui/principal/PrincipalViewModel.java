package br.com.mcode.atmconsultoria.ui.principal;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import br.com.mcode.atmconsultoria.R;

public class PrincipalViewModel extends ViewModel {

    //private final MutableLiveData<String> mText;
    private final MutableLiveData<Integer> mImage;


    public PrincipalViewModel() {
        // TextView
        /*
        mText = new MutableLiveData<>();
        mText.setValue("Home");

         */
        // imageView
        mImage = new MutableLiveData<>();
        mImage.setValue(R.drawable.logo);
    }

    // recupera um texto TextView
    /*
    public LiveData<String> getText() {
        return mText;
    }

     */


    // Recupera uma imagem ImagemView
    public LiveData<Integer> getImage(){
        return mImage;
    }
}
package br.com.mcode.atmconsultoria.ui.contato;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class EmailViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EmailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("m.c.s@msn.com");
    }

    public LiveData<String> getText(){
        return mText;
    }
}

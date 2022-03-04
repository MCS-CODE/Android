package br.com.mcode.atmconsultoria.ui.servicos;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ServicosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ServicosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Servicos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}


package br.com.mcode.atmconsultoria.ui.clientes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ClientesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ClientesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Clientes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
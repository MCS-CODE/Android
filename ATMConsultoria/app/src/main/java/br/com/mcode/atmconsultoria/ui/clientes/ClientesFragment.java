package br.com.mcode.atmconsultoria.ui.clientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import br.com.mcode.atmconsultoria.databinding.FragmentClientesBinding;


public class ClientesFragment extends Fragment {

    private FragmentClientesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClientesViewModel clientesViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ClientesViewModel.class);

        binding = FragmentClientesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textSlideshow;
        //clientesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
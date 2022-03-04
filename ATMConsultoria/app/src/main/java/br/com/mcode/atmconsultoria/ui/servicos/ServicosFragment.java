package br.com.mcode.atmconsultoria.ui.servicos;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.mcode.atmconsultoria.databinding.FragmentServicosBinding;


public class ServicosFragment extends Fragment {

    private FragmentServicosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ServicosViewModel servicosViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ServicosViewModel.class);

        binding = FragmentServicosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        final TextView textView = binding.textTtulo;
        servicosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

         */
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
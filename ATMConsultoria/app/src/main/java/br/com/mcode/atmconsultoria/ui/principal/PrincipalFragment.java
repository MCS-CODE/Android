package br.com.mcode.atmconsultoria.ui.principal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import br.com.mcode.atmconsultoria.databinding.FragmentPrincipalBinding;

public class PrincipalFragment extends Fragment {

    private FragmentPrincipalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PrincipalViewModel homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(PrincipalViewModel.class);

        binding = FragmentPrincipalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Recuperando um texView por meio do id
        /*
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

         */

        final ImageView imageView = binding.imgLogo;
        homeViewModel.getImage().observe(getViewLifecycleOwner(), imageView::setImageResource);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
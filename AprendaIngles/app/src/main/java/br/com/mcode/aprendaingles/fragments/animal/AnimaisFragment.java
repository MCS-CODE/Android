package br.com.mcode.aprendaingles.fragments.animal;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import br.com.mcode.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimaisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimaisFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ImageView btnCao, btnMacaco, btnOvelha, btnGato, btnLeao, btnVaca;
    private MediaPlayer mediaPlayer;

    public AnimaisFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimaisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimaisFragment newInstance(String param1, String param2) {
        AnimaisFragment fragment = new AnimaisFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animais, container, false);

        // Criando referencias
        btnCao = view.findViewById(R.id.btn_cao);
        btnGato = view.findViewById(R.id.btn_gato);
        btnLeao = view.findViewById(R.id.btn_leao);
        btnMacaco = view.findViewById(R.id.btn_macaco);
        btnOvelha = view.findViewById(R.id.btn_ovelha);
        btnVaca = view.findViewById(R.id.btn_vaca);

        // Aplicar eventos de click

        btnCao.setOnClickListener(this);
        btnOvelha.setOnClickListener(this);
        btnVaca.setOnClickListener(this);
        btnMacaco.setOnClickListener(this);
        btnLeao.setOnClickListener(this);
        btnGato.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;
            case R.id.btn_gato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.btn_macaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.btn_leao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.btn_ovelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.btn_vaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null);
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
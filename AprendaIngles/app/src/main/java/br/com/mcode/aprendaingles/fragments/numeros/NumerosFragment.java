package br.com.mcode.aprendaingles.fragments.numeros;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.mcode.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //My parameters
    private ImageView btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
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
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        //Createing references

        btnOne = view.findViewById(R.id.btn_1);
        btnTwo = view.findViewById(R.id.btn_2);
        btnThree = view.findViewById(R.id.btn_3);
        btnFour = view.findViewById(R.id.btn_4);
        btnFive = view.findViewById(R.id.btn_5);
        btnSix = view.findViewById(R.id.btn_6);

        // Aplication event click

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);

        return view;
    }

    public void startSound(){
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
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_1:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                startSound();
                break;
            case R.id.btn_2:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                startSound();
                break;
            case R.id.btn_3:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                startSound();
                break;
            case R.id.btn_4:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                startSound();
                break;
            case R.id.btn_5:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                startSound();
                break;
            case R.id.btn_6:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                startSound();
                break;
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
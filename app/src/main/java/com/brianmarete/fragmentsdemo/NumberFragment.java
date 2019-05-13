package com.brianmarete.fragmentsdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {

    public static final String ARG_NUMBER = "number";

    private String number;
    TextView numberTextView;


    public static NumberFragment newInstance(int number) {
        NumberFragment fragment = new NumberFragment();

        Bundle args = new Bundle();
        args.putString(ARG_NUMBER, String.valueOf(number));
        NumberFragment numberFragment = new NumberFragment();
        numberFragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            number = getArguments().getString("number");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number, container, false);

        numberTextView = view.findViewById(R.id.tv_number_fragment);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        numberTextView.setText(number);
    }
}

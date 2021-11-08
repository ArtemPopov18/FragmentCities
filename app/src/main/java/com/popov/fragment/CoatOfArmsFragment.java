package com.popov.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CoatOfArmsFragment extends Fragment {

    public static final String  KEY_INDEX = "index";
    private int index;

    public CoatOfArmsFragment() {
        // Required empty public constructor
    }

    public static CoatOfArmsFragment newInstance(int index) {
        CoatOfArmsFragment fragment = new CoatOfArmsFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(KEY_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coat_of_arms, container, false);
        TextView textView = view.findViewById(R.id.coat_of_arms);
        TextView noteDateView = view.findViewById(R.id.note_date);
        String[] text = getResources().getStringArray(R.array.note_text);
        String[] date = getResources().getStringArray(R.array.note_date);
        textView.setText(text[index]);
        noteDateView.setText(date[index]);
        return view;
    }
}
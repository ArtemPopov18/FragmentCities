package com.popov.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
        ImageView imageView = view.findViewById(R.id.coat_of_arms);
        TypedArray images = (getResources().obtainTypedArray(R.array.coat_of_arms_imgs));
        imageView.setImageResource(images.getResourceId(index, -1));
        return view;
    }
}
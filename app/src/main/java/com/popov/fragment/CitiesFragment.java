package com.popov.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class CitiesFragment extends Fragment {

    private boolean isLandscape;
    int currentPosition = 0;
    String CURRENT_POSITION = "pos";


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_POSITION, currentPosition);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if(savedInstanceState != null){
            currentPosition = savedInstanceState.getInt(CURRENT_POSITION, 0);
        }

        if(isLandscape){
            showLandCoatOfArms(currentPosition);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createTextViewList((LinearLayout) view);
    }

    private void createTextViewList(LinearLayout view) {
        String[] noteTitle = getResources().getStringArray(R.array.note_title);
        for(int i = 0; i < noteTitle.length; i++){
            TextView textView = new TextView(getContext());
            textView.setText(noteTitle[i]);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentPosition = finalI;
                    if(isLandscape){
                        showLandCoatOfArms(currentPosition);
                    }else
                        showPortCoatOfArms(currentPosition);
                }
            });
            textView.setTextSize(35);
            view.addView(textView);
        }
    }

    private void showLandCoatOfArms(int finalI) {
        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(finalI);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container_land, coatOfArmsFragment).commit();
    }

    private void showPortCoatOfArms(int finalI) {
        Intent intent = new Intent(getActivity(), CoatOfArmsPortActivity.class);
        intent.putExtra(CoatOfArmsFragment.KEY_INDEX, finalI);
        startActivity(intent);
    }

    public static CitiesFragment newInstance(String param1, String param2) {
        CitiesFragment fragment = new CitiesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


}
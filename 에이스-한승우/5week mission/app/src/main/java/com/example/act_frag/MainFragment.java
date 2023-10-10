package com.example.act_frag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView textMessage = view.findViewById(R.id.textMessage);

        //넘어온 메시지 변수에 담기
        String message = this.getArguments().getString("message");

        //메시지 텍스트뷰에 담기
        textMessage.setText(message);

        return view;
    }
}
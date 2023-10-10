package com.example.act_frag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editMessage;
    Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMessage = findViewById(R.id.editMessage);
        btnSend = findViewById(R.id.btnSend);

        //버튼 클릭 이벤트
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //프래그먼트 작업
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                //데이터 넘기기 위해 필요함
                Bundle bundle = new Bundle();

                //1.입력메시지
                String message = editMessage.getText().toString();
                //2.데이터 담기
                bundle.putString("message", message);
                //3.프래그먼터 선언
                MainFragment mainFragment = new MainFragment();
                //4.프래그먼트에 데이터 넘기기
                mainFragment.setArguments(bundle);
                //5.프래그먼트 화면에 보여주기
                transaction.replace(R.id.fragmentLayout, mainFragment);
            }
        });
    }
}
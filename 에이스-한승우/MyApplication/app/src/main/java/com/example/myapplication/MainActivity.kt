package com.example.ex_sharedpreferences

import android.R
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var editText: EditText? = null
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<EditText>(R.id.editText)
        textView = findViewById<TextView>(R.id.textView)
    } // onCreate()..

    fun clickSetBt(view: View?) {    // Set버튼 클릭 시    SharedPreferences에 값 저장.
        if (editText!!.text.toString().isEmpty()) { // 공백 또는 size=0이면
            Toast.makeText(this, "값을 입력해주세요.", Toast.LENGTH_SHORT).show()
        } else {
            val sharedPreferences = getSharedPreferences("test", MODE_PRIVATE) // test 이름의 기본모드 설정
            val editor = sharedPreferences.edit() //sharedPreferences를 제어할 editor를 선언
            editor.putString("inputText", editText!!.text.toString()) // key,value 형식으로 저장
            editor.commit() //최종 커밋. 커밋을 해야 저장이 된다.
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
        }
    } // clickSetBt()..

    fun clickGetBt(view: View?) {     // Get버튼 클릭 시   SharedPreferences에 값 불러오기.
        val sharedPreferences = getSharedPreferences(
            "test",
            MODE_PRIVATE
        ) // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        val inputText = sharedPreferences.getString("inputText", "")
        textView!!.text = inputText // TextView에 SharedPreferences에 저장되어있던 값 찍기.
        Toast.makeText(this, "불러오기 하였습니다..", Toast.LENGTH_SHORT).show()
    } // clickGetBt()..
} // MainActivity class..

package com.catnip.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName

    private var count = 1

    //1. declare variable from xml
    private lateinit var btnClickMe: Button
    private lateinit var flHello: FrameLayout
    private lateinit var tvHello: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //first method to bind layout to activity
        setContentView(R.layout.activity_main)
        bindViews()
        setClickListeners()
    }

    private fun bindViews() {
        //2. bind views , we find the component by id of component
        btnClickMe = findViewById(R.id.btn_click_me)
        flHello = findViewById(R.id.fl_hello)
        tvHello = findViewById(R.id.tv_hello)
    }

    private fun setClickListeners(){
        //3. do whatever you want from the xml component
        btnClickMe.setOnClickListener {
            if (count <= 30) {
                //set text to textview
                tvHello.text = count.toString()
                if (count % 2 == 0) {
                    //set color of textview
                    tvHello.setTextColor(ContextCompat.getColor(this,R.color.black))
                    //set background color of frame layout
                    flHello.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                }else{
                    tvHello.setTextColor(ContextCompat.getColor(this,R.color.white))
                    flHello.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
                }
                //logging
                Log.d(TAG, "Button Clicked ! Count is = $count")
                count++
            } else {
                Log.d(TAG, "bindViews: count already 30")
            }
        }
    }
}
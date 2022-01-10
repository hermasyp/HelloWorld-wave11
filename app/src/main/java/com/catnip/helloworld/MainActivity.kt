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

    private lateinit var btnClickMe: Button
    private lateinit var flHello: FrameLayout
    private lateinit var tvHello: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }

    private fun bindViews() {
        btnClickMe = findViewById(R.id.btn_click_me)
        flHello = findViewById(R.id.fl_hello)
        tvHello = findViewById(R.id.tv_hello)

        btnClickMe.setOnClickListener {
            if (count <= 30) {
                tvHello.text = count.toString()
                if (count % 2 == 0) {
                    tvHello.setTextColor(ContextCompat.getColor(this,R.color.black))
                    flHello.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                }else{
                    tvHello.setTextColor(ContextCompat.getColor(this,R.color.white))
                    flHello.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
                }
                Log.d(TAG, "Button Clicked ! Count is = $count")
                count++
            } else {
                Log.d(TAG, "bindViews: count already 30")
            }
        }
    }
}
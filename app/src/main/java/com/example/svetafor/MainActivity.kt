package com.example.svetafor

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.sql.Time
import java.util.*
import kotlin.concurrent.timer

class MainActivity : Activity() {
    var imSemafor: ImageView? = null
    var counter: Int = 0 //счетчик, который будет считать коробки в массиве
    var timer: Timer? = null //таймер
    var is_run = false

    var imageArray : IntArray =
        intArrayOf(R.drawable.semafor_red, R.drawable.semafor_green, R.drawable.semafor_yellow)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imSemafor = findViewById(R.id.imSemafor)
       // imSemafor?.setImageResource(R.drawable.semafor_green)
        imSemafor?.setImageResource(imageArray[1])
    }
    fun onClickStartStop(view: View) {
        view as ImageButton
        if (!is_run) {
            startStop()
            timer = Timer()
            view.setImageResource((R.drawable.button_stop))
            is_run = true
        }
        else
        {
            imSemafor?.setImageResource(R.drawable.semafor_green)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            is_run = false
        }
    }



            fun startStop(){
                timer = Timer()
                timer?.schedule(object : TimerTask() {
                    override fun run() {
                        imSemafor?.setImageResource(imageArray[counter])
                        counter++
                        if (counter == 3) counter = 0


                    }
                },0,1000)
        }
}
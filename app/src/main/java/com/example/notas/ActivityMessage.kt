package com.example.notas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.notas.R

class ActivityMessage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        var textNotes=findViewById<TextView>(R.id.textView3)
        var textMessage=findViewById<TextView>(R.id.textView4)
        val myBundle:Bundle?=this.intent.extras

        if(myBundle!=null){
            textNotes.text="sus notas son: \n ${myBundle?.getDouble("note1")}\n ${myBundle?.getDouble("note2")}\n ${myBundle?.getDouble("note3")} \n Promedio:\n ${myBundle?.getDouble("average")}"
            var message=myBundle?.getString("message")
            if(myBundle?.getDouble("average")!! >=3.5){
                textMessage.text=message
                textMessage.setTextColor(Color.GREEN)

            }else{
                textMessage.text=message
                textMessage.setTextColor(Color.RED)

            }

        }
        val exitButton=findViewById<Button>(R.id.button)
        fun exit(){
            finish()

        }
        exitButton.setOnClickListener{exit()}
    }
}
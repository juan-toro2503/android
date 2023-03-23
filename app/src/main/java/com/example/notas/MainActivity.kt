package com.example.notas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun activity(a:Int){
            val note1=findViewById<EditText>(R.id.number1)
            val note2=findViewById<EditText>(R.id.number2)
            val note3=findViewById<EditText>(R.id.number3)
            val notes=findViewById<TextView>(R.id.notes)
            val showMessage=findViewById<TextView>(R.id.message)
            val number1:Double=note1.text.toString().toDouble()
            val number2:Double=note2.text.toString().toDouble()
            val number3:Double=note3.text.toString().toDouble()
            val average=(number1+number2+number3)/3

            var message=""
            if(average>=3.5){
                message="Aprobo"
            }else{
                message="Reprobo"
            }
            if(a==1){
                val intent= Intent(this,ActivityMessage::class.java)
                val myBundle=Bundle()
                myBundle.putDouble("note1", number1)
                myBundle.putDouble("note2", number2)
                myBundle.putDouble("note3", number3)
                myBundle.putDouble("average", average)
                myBundle.putString("message", message)


                intent.putExtras(myBundle)
                startActivity(intent)

            }else if(a==2){
                notes.text="notas: \n${number1} \n ${number2}\n ${number3} \n promedio: \n ${average} "
                if(average>=3.5){
                    showMessage.text=message
                    showMessage.setTextColor(Color.GREEN)
                }else{
                    showMessage.text=message
                    showMessage.setTextColor(Color.RED)
                }

            }



        }
        val button1: Button =findViewById(R.id.button1)
        val button2: Button =findViewById(R.id.button2)
        button1.setOnClickListener{activity(2)}
        button2.setOnClickListener{activity(1)}



    }

}
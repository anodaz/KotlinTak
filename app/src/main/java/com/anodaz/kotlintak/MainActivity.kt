package com.anodaz.kotlintak

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {
    var pl=true
    var pla=true
    var pl1=ArrayList<Int>()
    var pl2=ArrayList<Int>()
    var Cpl1=0
    var Cpl2=0
    var iswin=false
    var contwin=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView2.setText("Player 1 : X")
        textView2.setBackgroundResource(R.color.pp1)
        bt1.setOnClickListener({
            check(1,bt1)
        })
        bt2.setOnClickListener({
            check(2,bt2)
        })
        bt3.setOnClickListener({
            check(3,bt3)
        })
        bt4.setOnClickListener({
            check(4,bt4)
        })
        bt5.setOnClickListener({
            check(5,bt5)
        })
        bt6.setOnClickListener({
            check(6,bt6)
        })
        bt7.setOnClickListener({
            check(7,bt7)
        })
        bt8.setOnClickListener({
            check(8,bt8)
        })
        bt9.setOnClickListener({
            check(9,bt9)
        })
        GNext.setOnClickListener({
            if((iswin || contwin==9) && contwin!=0){
                enablB()
                pl1.clear()
                pl2.clear()
                if (pla){
                    textView2.setText("Player 1 : X")
                    textView2.setBackgroundResource(R.color.pp1)
                }
                else{
                    textView2.setText("Player 2 : O")
                    textView2.setBackgroundResource(R.color.pp2)
                }
                pla=!pla
                contwin=0
            }

        })
        PlayA.setOnClickListener({
                enablB()
                pl1.clear()
                pl2.clear()
                    textView2.setText("Player 1 : X")
                    textView2.setBackgroundResource(R.color.pp1)
                contwin=0
                Cpl1=0
                Tp1.setText("P1="+Cpl1)
                Cpl2=0
                Tp2.setText("P2="+Cpl2)
        })
        btC.setOnClickListener({
            finish();
        })
    }
    fun desanlB(){
        bt1.isEnabled=false
        bt2.isEnabled=false
        bt3.isEnabled=false
        bt4.isEnabled=false
        bt5.isEnabled=false
        bt6.isEnabled=false
        bt7.isEnabled=false
        bt8.isEnabled=false
        bt9.isEnabled=false
    }
    fun enablB(){
        bt1.setText("")
        bt2.setText("")
        bt3.setText("")
        bt4.setText("")
        bt5.setText("")
        bt6.setText("")
        bt7.setText("")
        bt8.setText("")
        bt9.setText("")
        bt1.isEnabled=true
        bt2.isEnabled=true
        bt3.isEnabled=true
        bt4.isEnabled=true
        bt5.isEnabled=true
        bt6.isEnabled=true
        bt7.isEnabled=true
        bt8.isEnabled=true
        bt9.isEnabled=true
    }
    fun iswin(bl:ArrayList<Int>): Boolean {
        when {
            bl.containsAll(mutableListOf(1, 2, 3)) ||
                    bl.containsAll(mutableListOf(4, 5, 6)) ||
                    bl.containsAll(mutableListOf(7, 8, 9)) ||
                    bl.containsAll(mutableListOf(1, 4, 7)) ||
                    bl.containsAll(mutableListOf(2, 5, 8)) ||
                    bl.containsAll(mutableListOf(3, 6, 9)) ||
                    bl.containsAll(mutableListOf(3, 5, 7)) ||
                    bl.containsAll(mutableListOf(1, 5, 9)) ->return true
            else ->return false
        }
    }
    fun winner(Cc:Int,Pl:Int,Tp:TextView){
        val simpleAlert = AlertDialog.Builder(this@MainActivity).create()
        simpleAlert.setTitle("Winner")
        simpleAlert.setMessage("Player "+Pl+" Win The Game ")
        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", {
            dialogInterface, i ->
        })
        simpleAlert.show()
        textView2.setText("Player "+Pl+" Win")
        Tp.setText("P"+Pl+"="+Cc)
        iswin=true
        desanlB()
    }
    fun check(id:Int,Bt:Button){
        contwin++
        if (pl){
            textView2.setBackgroundResource(R.color.pp2)
            Bt.setText("X")
            textView2.setText("Player 2 : O")
            pl=false
            pl1.add(id)
        }
        else{
            Bt.setText("O")
            textView2.setBackgroundResource(R.color.pp1)
            textView2.setText("Player 1 : X")
            pl=true
            pl2.add(id)
        }
        Bt.isEnabled=false
        if (iswin(pl1)){
            Cpl1++
            winner(Cpl1,1,Tp1)
        }
        if (iswin(pl2)){
            Cpl2++
            winner(Cpl2,2,Tp2)
        }
    }
}
package com.example.f1standing

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.f1standing.databinding.ActivityMain2Binding
import java.util.Arrays


private lateinit var binding : ActivityMain2Binding
    var heart1_check : Boolean = false
    var index : Int = 0
    lateinit var alLines : ArrayList<LinearLayout>

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        FavAlert()
        heartSelectionEvent()

    }
    private fun heartSelectionEvent(){

        alLines = ArrayList<LinearLayout>(Arrays.asList(binding.line1, binding.line2, binding.line3,
            binding.line4, binding.line5, binding.line6, binding.line7, binding.line8, binding.line9,
            binding.line10))

        for(i in alLines.indices){
            selectHeart(alLines[i])
        }
    }
    private fun selectHeart(line: LinearLayout){

        val hearts : Array<ImageView> = arrayOf(binding.heart1, binding.heart2, binding.heart3,
        binding.heart4, binding.heart5, binding.heart6, binding.heart7, binding.heart8,
            binding.heart9, binding.heart10)
        val texts : Array<TextView> = arrayOf(binding.text1, binding.text2, binding.text3,
            binding.text4,binding.text5,binding.text6,binding.text7,binding.text8,
            binding.text9,binding.text10)
        val line_indexs : Int = alLines.indexOf(line)

        line.setOnClickListener {
            Toast.makeText(this@MainActivity2, texts[line_indexs].getText().substring(3), Toast.LENGTH_SHORT).show()
            setAllHeartsEmpty(hearts)
            fillOneHeart(hearts, line)
            SendingData(texts[line_indexs].getText().toString())

        }

    }
    private fun setAllHeartsEmpty (hearts : Array<ImageView>){
        for (heart in hearts){
            heart.setImageResource(R.drawable.heart_empty)
        }
    }
    private fun fillOneHeart (hearts : Array<ImageView>, line : LinearLayout){
        val line_index : Int = alLines.indexOf(line)
        hearts[line_index].setImageResource(R.drawable.heart_fill)
    }
    private fun SendingData(data : String){
        val intent = Intent()
        println("HI??")
        intent.action = Intent.ACTION_SENDTO
        intent.putExtra(Intent.EXTRA_TEXT, data)
        intent.type = "text/plain" //기본 글씨 MIME TYPE
        intent.putExtra(Intent.EXTRA_TITLE, "텍스트 공유")
        startActivity(intent)

        finishAffinity(); // 액티비티 종료 + 태스크 리스트에서 지우기


        }


    private fun FavAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("팔로우할 선수를 골라주세요..")
            .setPositiveButton("확인",
                DialogInterface.OnClickListener{ dialog, id->

                })
            .show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this@MainActivity2, "PAUSE - NEW", Toast.LENGTH_SHORT)
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(this@MainActivity2, "STOP - NEW", Toast.LENGTH_SHORT)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this@MainActivity2, "DESTROY - NEW", Toast.LENGTH_SHORT)

        /*        moveTaskToBack(true);
                finishAndRemoveTask();
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0)*/
    }
}
package com.example.photoframeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView


var currentImage = 0
   lateinit var image :ImageView
var names = arrayOf("Cristiano Ronaldo","Lionel Messi", "Neymar", "Michael Gerard Tyson", "Roman Reigns")
class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val prev = findViewById<AppCompatImageView>(R.id.imgPrev)
        val next = findViewById<AppCompatImageView>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.textView)

        //CONCEPT FOR SHOWING PREVIOUS IMAGE

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
                //convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5 + currentImage - 1)%5
            val idImageToShowString = "pic$currentImage"
            //convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            text.text = names[currentImage]

        }

        //NOW CONCEPT FOR SHOWING NEXT IMAGE

        next.setOnClickListener {

            val idCurrentImageString = "pic$currentImage"
            //convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5 + currentImage + 1)%5
            val idImageToShowString = "pic$currentImage"
            //convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            text.text = names[currentImage]

        }




    }
}
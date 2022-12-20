package com.example.taskmanager.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.taskmanager.R
import java.net.URL

fun ImageView.loadImage(url: String){
    Glide.with(this).load(url).placeholder(R.drawable.img_baground).into(this)
}
package com.example.themovieapp.utils

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.themovieapp.R
import com.squareup.picasso.Picasso

//확장함수 제작

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String){
    if(TextUtils.isEmpty(imageUrl)){
        Picasso.get().load(R.mipmap.ic_launcher).into(this)
    }else{
        Picasso.get().load(imageUrl)
            .placeholder(R.drawable.img_default)
            .centerCrop()
            .fit()
            .into(this)
    }
}
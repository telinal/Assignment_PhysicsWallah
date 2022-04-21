package com.example.physicswallah.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageURL")
fun setImageURL(image: ImageView, url: String) {
    Glide.with(image).load(url).into(image)
}
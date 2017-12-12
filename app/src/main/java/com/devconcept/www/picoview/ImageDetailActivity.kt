package com.devconcept.www.picoview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_detail.*

class ImageDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        val imageUrl = intent.getStringExtra(IMAGE_KEY)
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.loading_rect)
                .error(R.drawable.loading_failed_rect)
                .into(detailImage)
    }
}

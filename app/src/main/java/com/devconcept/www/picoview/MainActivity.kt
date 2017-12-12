package com.devconcept.www.picoview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ImageAdapter(this, ImageService.images) { url ->
            val detailImageIntert = Intent(this, ImageDetailActivity::class.java)
            detailImageIntert.putExtra(IMAGE_KEY, url)
            startActivity(detailImageIntert)
        }

        val layoutManager = GridLayoutManager(this, 2)
        gridView.adapter = adapter //like datasource = self
        gridView.layoutManager = layoutManager //like delegate = self
    }
}

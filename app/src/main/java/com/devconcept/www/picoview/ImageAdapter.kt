package com.devconcept.www.picoview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by harry on 12/12/2017.
 */
class ImageAdapter (val context: Context, val images: Array<String>, val itemClick: (String) -> Unit): RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    //like numberOfRowAtIndexPath
    override fun getItemCount(): Int {
        return images.size
    }

    //like let cell = collectionView.dequeresuablecell("", indexPath) as! xxx, return cell
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_element, parent, false)
        return ImageHolder(view, itemClick)
    }

    //like cell.image = image
    override fun onBindViewHolder(holder: ImageHolder?, position: Int) {
        holder?.bindImage(position)
    }

    //like ImageHolderCollectionViewCell.swift
    inner class ImageHolder(itemView: View?, val itemClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val image = itemView?.findViewById<ImageView>(R.id.gridElementImage)

        fun bindImage(index: Int) {
            Picasso.with(context)
                    .load(images[index])
                    .placeholder(R.drawable.loading_square)
                    .error(R.drawable.load_failed_square)
                    .into(image)
            itemView.setOnClickListener {
                itemClick(images[index])
            }
        }

    }
}
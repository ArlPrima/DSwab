package com.example.dswap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class introSliderAdapter(private val introSlides: List<introSlide>) :
    RecyclerView.Adapter<introSliderAdapter.IntroSliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSliderViewHolder {
        return IntroSliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slide_item_container, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return introSlides.size
    }
    override fun onBindViewHolder(holder: IntroSliderViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }

    inner class IntroSliderViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val textTitle:TextView = view.findViewById(R.id.textTitle)
        private val textDescription:TextView = view.findViewById(R.id.textDescription)
        private val imageIcon:ImageView = view.findViewById(R.id.imageSlideIcon)
        fun bind(introSlide: introSlide){
            textTitle.text = introSlide.title
            textDescription.text = introSlide.description
            imageIcon.setImageResource(introSlide.icon)
        }
    }
}
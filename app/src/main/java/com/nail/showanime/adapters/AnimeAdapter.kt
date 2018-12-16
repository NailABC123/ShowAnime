package com.nail.showanime.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nail.showanime.R
import com.nail.showanime.activities.InfoAnimeActivity
import com.nail.showanime.models.AnimeClass
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_anime_layout.view.*

class AnimeAdapter(val animeList: List<AnimeClass>) :
    RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime_layout, parent, false)
        return AnimeViewHolder(view)


    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        viewHolder.setAnime(animeList[position])
    }


    inner class AnimeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


        fun setAnime(anime: AnimeClass) {


            view.animeTitleTextView.text = anime.title
            //val animeItem = animeList[layoutPosition]
            //val urlAnime = anime.url


            view.setOnClickListener() {


                val intent = Intent(view.context, InfoAnimeActivity::class.java)
                intent.putExtra("animeKey", anime)
                view.context.startActivity(intent)
            }

            Picasso.get()
                .load(anime.imageUrl)
                .into(view.animeItemImageView)


        }//end of function setAnime


    }//end of AnimeViewHolder class


}



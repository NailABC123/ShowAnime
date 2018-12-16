package com.nail.showanime.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nail.showanime.R
import com.nail.showanime.models.AnimeClass
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_info_anime.*
import kotlinx.android.synthetic.main.content_info_anime_layout.*

class InfoAnimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_anime)
        setSupportActionBar(toolbar)




        //**************************************************************************
        val animeInfo :AnimeClass =intent.getParcelableExtra("animeKey")

        ContentFullText.text="Type : "+animeInfo.type + "\nscore : "+animeInfo.score+
                "\nsynopsis : \n\n\n\n\n"+animeInfo.synopsis

        Titel_toolbar_layout.title= animeInfo.title
        Picasso.get()
            .load(animeInfo.imageUrl)
            .into(animeInfoImageView)


        //**************************************************************************


        animeFab.setOnClickListener { view ->
           val urlIntent =  Intent(Intent.ACTION_VIEW, Uri.parse(animeInfo.url))
               startActivity(urlIntent)

        }



    }//end of onCreate function



}

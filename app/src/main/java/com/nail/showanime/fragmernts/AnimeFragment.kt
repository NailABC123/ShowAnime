package com.nail.showanime.fragmernts


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.nail.showanime.R
import com.nail.showanime.adapters.AnimeAdapter
import com.nail.showanime.interfaces.AnimeSearchInterface
import com.nail.showanime.models.AnimeClass
import com.nail.showanime.models.AnimeSearchResponse
import com.nail.showanime.units.Consts
import com.nail.showanime.units.loadHistoryCounterNumber
import com.nail.showanime.units.setTextChangedListener
import kotlinx.android.synthetic.main.activity_search_anime_main.*
import kotlinx.android.synthetic.main.activity_search_anime_main.view.*
import kotlinx.android.synthetic.main.fragment_anime_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class AnimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_layout, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        historyCounterNumber = loadHistoryCounterNumber(view.context)

        showHistoryButton.setOnClickListener {

            if (historyCounterNumber == 0) {
                Toast.makeText(view.context, "Epmty history", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var bufferAllHistoryString = ""

            for (aValLoop: Int in 1..historyCounterNumber) {
                bufferAllHistoryString += loadHistorySharedPreferences(view.context, aValLoop) + " : " + aValLoop + "\n"
            }

            if (bufferAllHistoryString !== "")
                Toast.makeText(view.context, bufferAllHistoryString, Toast.LENGTH_LONG).show()

        }

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {


//                if (recyclerView.adapter?.itemCount ==0)
//                    searchNoImageView.visibility=View.VISIBLE
//                else
//                    searchNoImageView.visibility=View.INVISIBLE

                if (searchEditText.text.length > 2) {

                    searchNoImageView.visibility = View.INVISIBLE
                    search(s.toString())

                    //if (recyclerView.childCount ==0)
                    saveHistorySharedPreferences(view.context, searchEditText.text.toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //recyclerView.layoutManager?.removeAllViews()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })





        deleteHistoryButton.setOnClickListener {
            historyCounterNumber = 0
        }

    }//end of function onCreate


//    override fun onStop(){
//        super.onStopView()//not found
//        saveHistoryCounterNumber(view.context)
//
//    }

//        @SuppressLint("MissingSuperCall")
//        override fun onStop(){
//        super.onDestroyView()
//        saveHistoryCounterNumber(view.context) //error
//
//    }



    private fun search(searchQuery: String) {


        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val searchInterface = retrofit.create(AnimeSearchInterface::class.java)

        searchInterface.searchAnime(searchQuery)
            .enqueue(object : Callback<AnimeSearchResponse> {
                override fun onFailure(call: Call<AnimeSearchResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<AnimeSearchResponse>, response: Response<AnimeSearchResponse>) {
                    response.body()?.animeResults?.let {
                        prepareRecyclerView(it)
                    }
                }

            })

    }


    private fun prepareRecyclerView(animeList: List<AnimeClass>) {
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = AnimeAdapter(animeList)

    }


    //*******************************************************************************
    //*******************************************************************************

    var historyCounterNumber: Int = 0
    val historyCounterKey = "history"


    fun saveHistorySharedPreferences(contextVar: Context, sendValue: String) {

//        Toast.makeText(contextVar,"beforeSave : "+historyCounterNumber,Toast.LENGTH_SHORT).show()
        historyCounterNumber++

        val sharedPreferences_save = PreferenceManager.getDefaultSharedPreferences(contextVar)
        val editor = sharedPreferences_save.edit()
        editor.putString(historyCounterKey + historyCounterNumber, sendValue)
        editor.apply()

//        Toast.makeText(contextVar,"AfterSave : "+historyCounterNumber,Toast.LENGTH_SHORT).show()
    }

    fun loadHistorySharedPreferences(contextVar: Context, bufferHistoryCounterNumber: Int): String {

        val sharedPreferences_load = PreferenceManager.getDefaultSharedPreferences(contextVar)
        val loadedValue = sharedPreferences_load.getString(historyCounterKey + bufferHistoryCounterNumber, "")
        return loadedValue
    }



    //*******************************************************************************
    //*******************************************************************************


} //end of this class




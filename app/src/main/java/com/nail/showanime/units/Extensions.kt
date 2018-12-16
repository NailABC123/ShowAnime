package com.nail.showanime.units

import android.content.Context
import android.preference.PreferenceManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.util.*

fun EditText.setTextChangedListener(callback: (text: String) -> Unit) {

    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            callback(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })

}

fun ImageView.loadImageFromURL(url: String) {

    Picasso.get()
        .load(url)
        .into(this)

}

fun save_data_one_item_string (passingClass: Context, key_name : String, value :String)
{
    val sharedPreferences_save = PreferenceManager.getDefaultSharedPreferences(passingClass)
    val editor = sharedPreferences_save.edit()
    editor.putString(key_name,value)
    editor.apply()
}

fun save_data_one_item_int (passingClass: Context, key_name : String, value :Int)
{
    val sharedPreferences_save = PreferenceManager.getDefaultSharedPreferences(passingClass)
    val editor = sharedPreferences_save.edit()
    editor.putInt(key_name,value)
    editor.apply()
}

fun load_data_one_item_string (passingClass: Context, key_name : String) : String
{
    val sharedPreferences_load = PreferenceManager.getDefaultSharedPreferences(passingClass)
    var value = sharedPreferences_load.getString(key_name, "player")
    return value
}

fun load_data_one_item_int (passingClass: Context, key_name : String) : Int
{
    val sharedPreferences_load = PreferenceManager.getDefaultSharedPreferences(passingClass)
    var value = sharedPreferences_load.getInt(key_name, 0)
    return value
}
//*****************************************
fun saveHistoryCounterNumber(contextVar: Context,sendValue :Int) {

//        Toast.makeText(contextVar,"beforeSave : "+historyCounterNumber,Toast.LENGTH_SHORT).show()

    val sharedPreferences_save = PreferenceManager.getDefaultSharedPreferences(contextVar)
    val editor = sharedPreferences_save.edit()
    editor.putInt("historyCounterNumberKey", sendValue)
    editor.apply()

    historyCounterNumberExtentions=sendValue

//        Toast.makeText(contextVar,"AfterSave : "+historyCounterNumber,Toast.LENGTH_SHORT).show()
}

fun loadHistoryCounterNumber(contextVar: Context): Int {

    val sharedPreferences_load = PreferenceManager.getDefaultSharedPreferences(contextVar)
    val loadedValue = sharedPreferences_load.getInt("historyCounterNumberKey" , 0)
    return loadedValue
}

var historyCounterNumberExtentions =0

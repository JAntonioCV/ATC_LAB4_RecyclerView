package com.jantonioc.lab7recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jantonioc.lab7recyclerview.data.PlaceListAdapter
import com.jantonioc.lab7recyclerview.model.Place

class MainActivity : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private var adapter:PlaceListAdapter?= null
    private var countryList:ArrayList<Place>? = null
    private var layoutManager:RecyclerView.LayoutManager?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.myReciclerView)

        countryList = ArrayList<Place>()
        layoutManager = LinearLayoutManager(this)
        adapter = PlaceListAdapter(countryList!!,this)

        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.adapter = adapter

        var countryNameList:Array<String> = arrayOf("Canada","USA","Mexico","Columbia","Malaysia","Singapore","Turke","Nicaragua","India","Italy","Tunisia", "Chile", "Argentina", "Spain" , "Peru")

        var citiesNameList:Array<String> = arrayOf("Ottawa","Washington,D.C." , "Mexico City", "Bogota", "Kuala Lumpur", "Singapore" , "Ankara", "Managua" , "New Delhi", "Rome" , "Tunis", "Santiago", "Buenos Aires", "Madrid" , "Lima")

            for (i in 0..14) {
                var place=Place()
                place.CountryName = countryNameList[i]
                place.CityName = citiesNameList[i]
                countryList?. add (place)
            }

        adapter!!.notifyDataSetChanged ( )



    }
}
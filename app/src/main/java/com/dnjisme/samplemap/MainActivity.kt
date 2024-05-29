package com.dnjisme.samplemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.dnjisme.samplemap.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var requestQueue: RequestQueue
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvQuotes
        recyclerView.layoutManager = LinearLayoutManager(this)

        requestQueue = Volley.newRequestQueue(this)

    }

    private fun parseJSON(jsonObject : JSONObject) : ArrayList<Quotes>{
        val quotesList = ArrayList<Quotes>()

        try {
            val quotesArray = jsonObject.getJSONArray("quotes")
            for (i in 0 until quotesArray.length()){
                val quoteObject = quotesArray.getJSONObject(i)
                val quoteAuthor = quoteObject.getString("author")
                val quoteContent = quoteObject.getString("quote")
                quotesList.add(Quotes(quoteContent, quoteAuthor))
            }
        }
        catch (e : JSONException) {
            e.printStackTrace()
        }
        return quotesList
    }

}
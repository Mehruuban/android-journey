package com.mehru.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var newsArrayList : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.contac_logo10,
            R.drawable.contac_logo13,
            R.drawable.contac_logo11,
            R.drawable.contac_logo12,
            R.drawable.contac_logo13,
            R.drawable.contac_logo14,
            R.drawable.contac_logo13,
            R.drawable.contac_logo11,
            R.drawable.contac_logo12,
            R.drawable.contac_logo13
        )

        val newsHeadingArray = arrayOf(
            "Government Launches New Digital Education Program for Rural Students",
            "India and Japan Sign Strategic Deal on Renewable Energy Projects" ,
            "Tech Giants Announce 20,000+ Job Openings for Fresh Graduates",
            "India Wins Thriller Against Australia in ICC T20 World Cup Final",
            "Heavy Rainfall Alert Issued in Northern India for Next 3 Days",
            "Bollywood Star Announces Comeback with Big-Budget Sci-Fi Film",
            "India and Japan Sign Strategic Deal on Renewable Energy Projects" ,
            "Tech Giants Announce 20,000+ Job Openings for Fresh Graduates",
            "India Wins Thriller Against Australia in ICC T20 World Cup Final",
            "Heavy Rainfall Alert Issued in Northern India for Next 3 Days"
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for (index in newsImageArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index])
            newsArrayList.add(news)
        }

        recyclerView.adapter = NewsAdapter(newsArrayList,this)

        
    }
}
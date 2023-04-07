package com.example.fetchdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    lateinit var adapter:FetchAdapter
    lateinit var progress:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.dataRecyclerView)
        progress = findViewById(R.id.progressbar)
        getdata()
        Log.d("oncreate","oncreate")
    }
    fun getdata() {
        Log.d("getdata","getdata")
        retroInstance.dataInterface.getData().enqueue(object : Callback<ArrayList<Datamodel>?> {
            override fun onResponse(
                call: Call<ArrayList<Datamodel>?>,
                response: Response<ArrayList<Datamodel>?>
            ) {
                progress.visibility = View.GONE
                var data = response.body()
                if(data!=null){
                    adapter = FetchAdapter(this@MainActivity, data)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<ArrayList<Datamodel>?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error in API", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
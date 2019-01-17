package com.example.korpsdai

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.korpsdai.response.ListDai
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var progress : ProgressDialog
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress = ProgressDialog(this)
        rv_profile.layoutManager = LinearLayoutManager(this)
        rv_profile.setHasFixedSize(true)
        loadProfile()

        fab_add.setOnClickListener {
            val intent = Intent(this, Upload::class.java)
            startActivity(intent)
        }

    }

    private fun loadProfile() {
        progress.setMessage("Memuat data")
        progress.show()


        val call = ApiConfig().getInstance().myFileList()
        call.enqueue(object  : retrofit2.Callback<ListDai>{
            override fun onFailure(call: Call<ListDai>, t: Throwable) {
                progress.dismiss()
                Toast.makeText(applicationContext, "GAGAL MEMUAT DATA", Toast.LENGTH_SHORT).show()
                Log.d("ON FAILURE", t.toString())
            }

            override fun onResponse(call: Call<ListDai>, response: Response<ListDai>) {
                if (true){
                    if (response.isSuccessful){
                        progress.dismiss()

                        Toast.makeText(applicationContext,"BERHASIL", Toast.LENGTH_SHORT).show()
                        Log.d("ON RESPONSE", response.body()?.allfiles.toString())

                        adapter = MainAdapter(this@MainActivity, response.body()?.allfiles)
                        rv_profile.adapter = adapter

                    }
                }
            }


        })
    }
}

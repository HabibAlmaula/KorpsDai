package com.example.korpsdai

import com.example.korpsdai.response.Default
import com.example.korpsdai.response.ListDai
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import com.google.gson.GsonBuilder
import com.google.gson.Gson



class ApiConfig {

    companion object {
        val baseUrl = "http://192.168.100.58/korps_dai_fkam/"
        val imageUrl = "http://192.168.100.58/korps_dai_fkam/img/"
    }


    val gson = GsonBuilder()
        .setLenient()
        .create()

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getInstance() : ApiInterface{
        return getRetrofit().create(ApiInterface::class.java)
    }

}

interface ApiInterface{
    @GET("myfilelist.php")
    fun myFileList(): Call<ListDai>

    @Multipart
    @POST("upload.php")
    fun upload (
        @Part("nama") nama: RequestBody?,
        @Part("email") email : RequestBody?,
        @Part("tmpt_lahir") tmpt_lahir: RequestBody?,
        @Part("tgl_lahir") tgl_lahir: RequestBody?,
        @Part file: MultipartBody.Part,
        @Part("dpd") dpd: RequestBody?,
        @Part("password") password: RequestBody?
    ) : Call<Default>

}

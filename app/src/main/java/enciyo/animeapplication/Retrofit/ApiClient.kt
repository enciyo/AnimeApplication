package enciyo.animeapplication.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


    companion object {

        private var retrofit: Retrofit? = null
        private val BASE_URL = "https://api.jikan.moe/v3/"

        fun getClient() : Retrofit {
            if(retrofit==null){
                retrofit=Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient())
                    .build()
                return retrofit!!
            }
            return retrofit!!
        }

    }


}
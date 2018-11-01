package enciyo.animeapplication.Retrofit
import enciyo.animeapplication.Pojo.TrendRepo
import retrofit2.http.GET

interface myInterface {
    @GET("top/anime/1/upcoming")
    fun getTrend(): retrofit2.Call<TrendRepo>

    @GET("producer/1/1")
    fun getMagazine(): retrofit2.Call<TrendRepo>

}
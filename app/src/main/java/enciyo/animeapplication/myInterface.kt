package enciyo.animeapplication
import enciyo.animeapplication.Pojo.TrendRepo
import retrofit2.http.GET

interface myInterface {
    @GET("top/anime/1/upcoming")
    fun getTrend(): retrofit2.Call<TrendRepo>
}
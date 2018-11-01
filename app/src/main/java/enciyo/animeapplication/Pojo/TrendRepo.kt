package enciyo.animeapplication.Pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TrendRepo {

    @SerializedName("request_hash")
    @Expose
    var requestHash: String? = null

    @SerializedName("request_cached")
    @Expose
    var requestCached: Boolean? = null

    @SerializedName("request_cache_expiry")
    @Expose
    var requestCacheExpiry: Int? = null

    @SerializedName("top")
    @Expose
    var top: List<Top>? = null

    @SerializedName("anime")
    @Expose
    var anime: List<Magazine>? = null

    inner class Top {

        @SerializedName("mal_id")
        @Expose
        var malId: Int? = null

        @SerializedName("rank")
        @Expose
        var rank: Int? = null

        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("image_url")
        @Expose
        var imageUrl: String? = null

        @SerializedName("type")
        @Expose
        var typer: String? = null


        @SerializedName("start_date")
        @Expose
        var startDate: String? = null

        @SerializedName("members")
        @Expose
        var members: Int? = null

        @SerializedName("score")
        @Expose
        var score: Int? = null

    }

    inner class Magazine {
        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("synopsis")
        @Expose
        var synopsis: String? = null

        @SerializedName("members")
        @Expose
        var member: Int? = null

        @SerializedName("airing_start")
        @Expose
        var airing_start: String? = null

        @SerializedName("type")
        @Expose
        var mtype: String? = null

        @SerializedName("image_url")
        @Expose
        var imageUrl: String? = null

    }

}
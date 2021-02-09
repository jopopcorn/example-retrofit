package com.example.exretrofit

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("lastBuildDate") var lastBuildDate : String,
    @SerializedName("total") var total : Int,
    @SerializedName("start") var start : Int,
    @SerializedName("display") var display : Int,
    @SerializedName("items") var items : List<Items>
)

data class Items(
    @SerializedName("title") var title: String,
    @SerializedName("originallink") var originallink : String,
    @SerializedName("link") var link: String,
    @SerializedName("description") var description: String,
    @SerializedName("pubDate") var pubDate: String
)
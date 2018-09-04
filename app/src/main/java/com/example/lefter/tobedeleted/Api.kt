package com.example.lefter.tobedeleted

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface JsonApi {


    @GET("users")
    fun getUsers(): Observable<List<UserModel>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Observable<UserModel>


    companion object {
        fun getInstance(): JsonApi {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl(json_helper_base_url)
                    .build()

            return retrofit.create(JsonApi::class.java)
        }
    }
}
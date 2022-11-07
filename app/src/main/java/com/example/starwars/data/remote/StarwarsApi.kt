package com.example.starwars.data.remote

import com.example.starwars.data.remote.responses.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarwarsApi {

    @GET("")
    suspend fun getCategoryList(
    ): Category

    @GET("people")
    suspend fun getPeopleList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): People

    @GET("planets")
    suspend fun getPlanetsList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Planets

    @GET("films")
    suspend fun getFilmsList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Films

    @GET("species")
    suspend fun getSpeciesList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Species

    @GET("vehicles")
    suspend fun getVehiclesList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Vehicles

    @GET("starships")
    suspend fun getStarshipsList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Starships

    @GET("people/{index}")
    suspend fun getPeopleInfo(
        @Path("index") index: Int
    ): Result

    @GET("planets/{index}")
    suspend fun getPlanetInfo(
        @Path("index") index: Int
    ): ResultX

    @GET("films/{index}")
    suspend fun getFilmInfo(
        @Path("index") index: Int
    ): ResultXX

    @GET("species/{index}")
    suspend fun getSpeciesInfo(
        @Path("index") index: Int
    ): ResultXXX

    @GET("vehicles/{index}")
    suspend fun getVehicleInfo(
        @Path("index") index: Int
    ): ResultXXXX

    @GET("starships/{index}")
    suspend fun getStarshipInfo(
        @Path("index") index: Int
    ): ResultXXXXX

}

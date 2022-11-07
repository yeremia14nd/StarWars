package com.example.starwars.repository

import com.example.starwars.data.remote.StarwarsApi
import com.example.starwars.data.remote.responses.*
import com.example.starwars.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class StarwarsRepository @Inject constructor(
    private val api: StarwarsApi
) {

    suspend fun getCategoryList(): Resource<Category> {
        val response = try {
            api.getCategoryList()
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getPeopleList(limit: Int, offset: Int): Resource<People> {
        val response = try {
            api.getPeopleList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getPlanetsList(limit: Int, offset: Int): Resource<Planets> {
        val response = try {
            api.getPlanetsList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getFilmsList(limit: Int, offset: Int): Resource<Films> {
        val response = try {
            api.getFilmsList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getSpeciesList(limit: Int, offset: Int): Resource<Species> {
        val response = try {
            api.getSpeciesList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getVehiclesList(limit: Int, offset: Int): Resource<Vehicles> {
        val response = try {
            api.getVehiclesList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getStarshipsList(limit: Int, offset: Int): Resource<Starships> {
        val response = try {
            api.getStarshipsList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getPeopleInfo(index: Int): Resource<Result> {
        val response = try {
            api.getPeopleInfo(index)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getPlanetInfo(index: Int): Resource<ResultX> {
        val response = try {
            api.getPlanetInfo(index)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getFilmInfo(index: Int): Resource<ResultXX> {
        val response = try {
            api.getFilmInfo(index)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getSpeciesInfo(index: Int): Resource<ResultXXX> {
        val response = try {
            api.getSpeciesInfo(index)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }

    suspend fun getVehicleInfo(index: Int): Resource<ResultXXXX> {
        val response = try {
            api.getVehicleInfo(index)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }
    suspend fun getStarshipInfo(index: Int): Resource<ResultXXXXX> {
        val response = try {
            api.getStarshipInfo(index)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return  Resource.Success(response)
    }
}
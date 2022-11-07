package com.example.starwars.di

import com.example.starwars.data.remote.StarwarsApi
import com.example.starwars.repository.StarwarsRepository
import com.example.starwars.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideStarwarsRepository(
        api: StarwarsApi
    ) = StarwarsRepository(api)

    @Singleton
    @Provides
    fun provideStarwarsApi(): StarwarsApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(StarwarsApi::class.java)
    }


}
package br.com.easypallet.data

import br.com.easypallet.data.models.ResponseLoads
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*
import java.util.concurrent.TimeUnit

interface ApiService {

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                val client = OkHttpClient.Builder()
                client.addInterceptor(HttpLoggingInterceptor())
                apiService = Retrofit.Builder()
                    .baseUrl("https://development.easypallet.app")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                    .client(client.build())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

    @GET(Endpoints.ENDPOINT_USER_LOAD)
    fun getPagedUserLoads(
        @Path("id") userId: Int?,
        @Query("locality_id") localityId: Int?,
        @Header("Authorization") token: String?
    ): Call<ResponseLoads>
}
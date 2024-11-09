package com.example.casofuturo039

import com.example.casofuturo039.Modelo.Remote.RetrofitClient
import junit.framework.TestCase.assertEquals
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceTest {


    // test unitario
    // EL doble de Prueba
    private lateinit var mockWebServer: MockWebServer


    @Before
    fun setUp() {

        mockWebServer = MockWebServer()
    }

    @After
    fun tearDown() {

        mockWebServer.shutdown()
    }


    @Test
    fun testRetrofit() {

        val expectedBaseUrl = mockWebServer.url("/").toString()
        val retrofit = Retrofit.Builder()
            .baseUrl(expectedBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // asignar la instancia real de retofit a la propiedad retrofitIntance de Retrofitcliente
        RetrofitClient.retrofitInstance = retrofit
        val retrofitInstance = RetrofitClient.retrofitInstance
// true la prueba .
        assertEquals(expectedBaseUrl, retrofitInstance.baseUrl().toString())

    }


}
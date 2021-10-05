package com.example.debateonapp

import android.content.Context
import com.apollographql.apollo.ApolloClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

val okHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain: Interceptor.Chain ->
        val original: Request = chain.request()
        val builder: Request.Builder =
            original.newBuilder().method(original.method(), original.body())
        builder.header("api-key", "demoKeyOfApi")
        chain.proceed(builder.build())
    }
    .build()


val apolloClient = ApolloClient.builder()
    .serverUrl("http://debaters.world:8080/graphql")
    .okHttpClient(okHttpClient)
    .build()



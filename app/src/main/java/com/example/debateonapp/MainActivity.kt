package com.example.debateonapp

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.Logger
import com.apollographql.apollo.exception.ApolloException
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.orhanobut.logger.AndroidLogAdapter
import okhttp3.Response



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout = LinearLayoutManager(this)

        val response = apolloClient.query(DebaterListQuery())

        response.enqueue(object : ApolloCall.Callback<DebaterListQuery.Data>() {
            override fun onResponse(response: com.apollographql.apollo.api.Response<DebaterListQuery.Data>) {
                Log.d("DebaterList", "Success ${response.data}")
                val DebateList = response?.data?.homeDebates?.filterNotNull()
                if (DebateList != null && !response.hasErrors()) {
                    val adapter = DebateListAdapter(DebateList)

                    debatelist.adapter = adapter
                    adapter.notifyDataSetChanged()
                    debatelist.layoutManager = layout
                }

            }

            override fun onFailure(e: ApolloException) {
                Log.e(e.localizedMessage , "Error")
            }
        })

    }
}


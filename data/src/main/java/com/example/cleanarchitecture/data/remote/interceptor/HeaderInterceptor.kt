package com.example.cleanarchitecture.data.remote.interceptor

import android.content.Context
import android.util.Log
import com.example.cleanarchitecture.data.local.pref.AppPrefs
import com.example.cleanarchitecture.data.model.Token
import com.google.gson.Gson
import okhttp3.*
import javax.inject.Inject


class HeaderInterceptor @Inject constructor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token: Token? = AppPrefs(context, Gson()).getToken()
        getJson("search.json")
        var request = chain.request()
        if (request.url().toString().contains("newsfeed"))
            return Response.Builder()
                .code(200)
                .message(getJson("newsfeed.json"))
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(
                    ResponseBody.create(
                        MediaType.parse("application/json"),
                        getJson("newsfeed.json")
                    )
                )
                .addHeader("content-type", "application/json")
                .build()
        else
            request = request?.newBuilder()
                ?.addHeader("Content-Type", "application/json")
                ?.addHeader("Accept", "application/json")
                ?.apply { token?.token?.let { addHeader("Authorization", "Bearer $it") } }
                ?.build()
        return chain.proceed(request)
    }

    private fun getJson(fileName: String): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
        Log.d("TAGGG", inputStream.toString() + "input")
        val out = StringBuilder()
        inputStream?.bufferedReader()?.useLines { lines ->
            lines.forEach { line ->
                out.append(line)
            }
        }
        Log.d("TAGGG", "out" + out.toString())
        return out.toString()
    }

}
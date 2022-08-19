package com.example.githubdemo.utils

import android.content.Context
import android.graphics.Color
import org.json.JSONObject
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

object LanguageColorsHelper {

    private var colorMap: MutableMap<String, Int>? = null
    private var defaultColor = 0
    fun getColor(context: Context, languageName: String): Int {
        if (colorMap == null) {
            initColorMap(context)
            defaultColor = Color.parseColor("#CCCCCC")
        }
        return if (colorMap!!.containsKey(languageName)) colorMap!![languageName]!! else defaultColor
    }

    private fun initColorMap( context: Context) {
        try {
            colorMap = HashMap<String, Int>()
            val inputStream = context.assets.open("language_colors.json")
            val content = convertStreamToString(inputStream)
            val jsonObject = JSONObject(content)
            val iterator = jsonObject.keys()
            while (iterator.hasNext()) {
                val name = iterator.next()
                val language = jsonObject.getJSONObject(name)
                val colorStr = language.getString("color")
                if (colorStr == null || colorStr == "null") {
                    continue
                }
                val color = Color.parseColor(colorStr)
                colorMap?.set(name, color)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun convertStreamToString(`is`: InputStream): String {
        val reader = BufferedReader(InputStreamReader(`is`))
        val sb = StringBuilder()
        var line: String? = null
        try {
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                `is`.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return sb.toString()
    }
}
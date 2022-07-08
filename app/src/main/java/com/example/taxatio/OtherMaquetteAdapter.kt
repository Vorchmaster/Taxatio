package com.example.taxatio

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class OtherMaquetteAdapter(private var context: Context, private var list: JSONArray) : BaseAdapter() {
    override fun getCount(): Int {
        return list.length()
    }

    override fun getItem(p0: Int): Any {
        var a = list.get(p0) as JSONObject

        return a.toString()
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.maquette_other_item, p2, false)
        var a = list.get(p0) as JSONObject

        val text: TextView? = view.findViewById(R.id.listTextView)
        text?.setText("Макет " + a.get("NUMBER").toString()  + ": " + a.get("N0"))

        val savedState: SharedPreferences = context.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )

        if(savedState.contains("MaquettesOtherData")){
            var data = JSONArray(savedState.getString("MaquettesOtherData", ""))
            for(i in 0 until data.length()){
                var b = data[i] as JSONObject
                if (b.get("MAKET") == (a.get("NUMBER"))) {
                    text?.setBackgroundResource(R.color.edited)
                }
            }
        }

        return view
    }
}
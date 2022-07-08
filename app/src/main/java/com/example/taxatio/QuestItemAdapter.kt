package com.example.taxatio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class QuestItemAdapter(private var c: Context, private var quests: JSONArray): BaseAdapter(){

    override fun getCount(): Int {
        return quests.length()
    }

    override fun getItem(i: Int): Any {
        return quests.get(i) as JSONObject
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        var view = view
        view = LayoutInflater.from(c).inflate(R.layout.quest_item, viewGroup, false)

        val vyd = this.getItem(i) as JSONObject
        val questText = view!!.findViewById<TextView>(R.id.gridTextView)

        questText.setText("Выдел " + vyd.get("NNN").toString())

        return view
    }
}
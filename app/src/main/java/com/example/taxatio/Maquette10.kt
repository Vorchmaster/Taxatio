package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject


class Maquette10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette10)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var maquette: JSONArray = JSONArray()

        if(savedState.contains("Maquette10")){
            maquette = JSONArray(savedState.getString("Maquette10", ""))
        }
        else {
            maquette = JSONArray("[{\"YAR\":\"\",\"KOFSOS\":\"\",\"POR\":\"\",\"VOZ\":\"\",\"VYS\":\"\",\"DIM\":\"\",\"KLSTOV\":\"\",\"PRS\":\"\",\"POL\":\"\",\"SPS\":\"\",\"ZAP\":\"\",\"ISTRUE\":\"true\"}]")
        }

        val maquette10ListView: ListView = findViewById(R.id.maquette10ListView)
        maquette10ListView.adapter=Maquette10Adapter(this,maquette)
        setListViewHeightBasedOnChildren(maquette10ListView)

        val addButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.addButton)
        val deleteButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.deleteButton)
        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)


        addButton?.setOnClickListener { View ->
            maquette.put(maquette.length(), JSONObject("{\"YAR\":\"\",\"KOFSOS\":\"\",\"POR\":\"\",\"VOZ\":\"\",\"VYS\":\"\",\"DIM\":\"\",\"KLSTOV\":\"\",\"PRS\":\"\",\"POL\":\"\",\"SPS\":\"\",\"ZAP\":\"\",\"ISTRUE\":\"true\"}"))
            maquette10ListView.adapter=Maquette10Adapter(this,maquette)
            setListViewHeightBasedOnChildren(maquette10ListView)
        }

        deleteButton?.setOnClickListener { View ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Удаление строки")
            builder.setMessage("Вы уверены, что хотите удалить строку?")
            builder.setNegativeButton("Нет"){ dialog, id -> }
            builder.setPositiveButton(
                "Да") { dialog, id ->
                maquette.remove(maquette.length() - 1)
                maquette10ListView.adapter = Maquette10Adapter(this, maquette)
                setListViewHeightBasedOnChildren(maquette10ListView)
            }
            builder.show()
        }

        sendButton?.setOnClickListener { View ->
            var rez = true
            for (i in 0 until maquette.length()){
                var a = maquette.get(i) as JSONObject
                rez = rez and a.getBoolean("ISTRUE")
            }
            if (rez) {
                editor.putString("Maquette10", maquette.toString())
                editor.apply()

                val taxatioCardIntent = Intent(this, taxatioCardActivity::class.java)
                startActivity(taxatioCardIntent)
            }
            else{
                val toast = Toast.makeText(this, "Допущены ошибки в заполнении", Toast.LENGTH_LONG)
                toast.show()
            }
        }

        retreatButton?.setOnClickListener { View ->
            val taxatioCardIntent = Intent(this, taxatioCardActivity::class.java)
            startActivity(taxatioCardIntent)
        }
    }

    fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter = listView.adapter ?: return
        val desiredWidth = MeasureSpec.makeMeasureSpec(listView.width, MeasureSpec.UNSPECIFIED)
        var totalHeight = 0
        var view: View? = null
        for (i in 0 until listAdapter.count) {
            view = listAdapter.getView(i, view, listView)
            if (i == 0) view.layoutParams =
                ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
            view.measure(desiredWidth, MeasureSpec.UNSPECIFIED)
            totalHeight += view.measuredHeight
        }
        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        listView.layoutParams = params
        listView.requestLayout()
    }
}
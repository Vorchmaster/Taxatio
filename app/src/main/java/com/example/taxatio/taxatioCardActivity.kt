package com.example.taxatio

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class taxatioCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxatio_card)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var VydInfo: JSONObject
        var list: JSONArray
        //var data: JSONObject
        if(!savedState.getString("VydInfo","").equals("",true) and !savedState.getString("VydInfo","").equals("FAILURE",true)) {
            VydInfo = JSONObject(savedState.getString("VydInfo",""))
            if (!(savedState.contains("Maquette1"))) {
                if (VydInfo.has("Maquette1")) {
                    editor.putString("Maquette1", VydInfo.get("Maquette1").toString())
                    editor.apply()
                }
            }
            if (!(savedState.contains("Maquette2"))) {
                if (VydInfo.has("Maquette2")) {
                    editor.putString("Maquette2", VydInfo.get("Maquette2").toString())
                    editor.apply()
                }
            }
            if (!(savedState.contains("Maquette3"))) {
                if (VydInfo.has("Maquette3")) {
                    editor.putString("Maquette3", VydInfo.get("Maquette3").toString())
                    editor.apply()
                }
            }
            if (!(savedState.contains("Maquette4"))) {
                if (VydInfo.has("Maquette4")) {
                    editor.putString("Maquette4", VydInfo.get("Maquette4").toString())
                    editor.apply()
                }
            }
        }

        if ((savedState.contains("MaquettesOther"))) {
            list = JSONArray(savedState.getString("MaquettesOther",""))
        } else {
            list = JSONArray("[]")
        }

        val maquette1Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.maquette1Button)
        maquette1Button.setOnClickListener { view ->
            val maquette1Intent = Intent(this, Maquette1::class.java)
            startActivity(maquette1Intent)
        }
        if(savedState.contains("Maquette1")){
            maquette1Button.setBackgroundResource(R.color.edited)
        }

        val maquette2Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.maquette2Button)
        maquette2Button.setOnClickListener { view ->
            val maquette2Intent = Intent(this, Maquette2::class.java)
            startActivity(maquette2Intent)
        }
        if(savedState.contains("Maquette2")){
            maquette2Button.setBackgroundResource(R.color.edited)
        }

        val maquette3Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.maquette3Button)
        maquette3Button.setOnClickListener { view ->
            val maquette3Intent = Intent(this, Maquette3::class.java)
            startActivity(maquette3Intent)
        }
        if(savedState.contains("Maquette3")){
            maquette3Button.setBackgroundResource(R.color.edited)
        }

        val maquette4Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.maquette4Button)
        maquette4Button.setOnClickListener { view ->
            val maquette4Intent = Intent(this, Maquette4::class.java)
            startActivity(maquette4Intent)
        }
        if(savedState.contains("Maquette4")){
            maquette4Button.setBackgroundResource(R.color.edited)
        }

        val maquette10Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.maquette10Button)
        maquette10Button.setOnClickListener { view ->
            val maquette10Intent = Intent(this, Maquette10::class.java)
            startActivity(maquette10Intent)
        }
        if(savedState.contains("Maquette10")){
            maquette10Button.setBackgroundResource(R.color.edited)
        }

        val maquette31Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.maquette31Button)
        maquette31Button.setOnClickListener { view ->
            val maquette31Intent = Intent(this, Maquette31::class.java)
            startActivity(maquette31Intent)
        }
        if(savedState.contains("Maquette31")){
            maquette31Button.setBackgroundResource(R.color.edited)
        }

        val maquette32Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.maquette32Button)
        maquette32Button.setOnClickListener { view ->
            val maquette32Intent = Intent(this, Maquette32::class.java)
            startActivity(maquette32Intent)
        }
        if(savedState.contains("Maquette32")){
            maquette32Button.setBackgroundResource(R.color.edited)
        }

        val maquetteOtherListView: ListView = findViewById(R.id.maquetteOtherListView)
        maquetteOtherListView.adapter=OtherMaquetteAdapter(this, list)
        setListViewHeightBasedOnChildren(maquetteOtherListView)

        maquetteOtherListView.setOnItemClickListener { adapterView, view, i, l ->
            val maquetteOtherIntent = Intent(this, MaquetteOther::class.java)
            maquetteOtherIntent.putExtra("fields", list.get(i).toString())
            startActivity(maquetteOtherIntent)
        }

        val sendButton = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.sendButton)
        sendButton?.setOnClickListener { View ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Отправка данных")
            builder.setMessage("Вы уверены, что хотите отправить данные?")
            builder.setNegativeButton("Нет"){ dialog, id -> }
            builder.setPositiveButton(
                "Да") { dialog, id ->

                var data: JSONObject = JSONObject()
                data.put("NNN", savedState.getString("NNN", ""))
                editor.remove("NNN")
                data.put("Maquette1", JSONObject(savedState.getString("Maquette1", "")))
                editor.remove("Maquette1")
                data.put("Maquette2", JSONObject(savedState.getString("Maquette2", "")))
                editor.remove("Maquette2")
                data.put("Maquette3", JSONObject(savedState.getString("Maquette3", "")))
                editor.remove("Maquette3")
                data.put("Maquette4", JSONObject(savedState.getString("Maquette4", "")))
                editor.remove("Maquette4")
                data.put("Maquette10", JSONArray(savedState.getString("Maquette10", "")))
                editor.remove("Maquette10")
                data.put("Maquette31", JSONObject(savedState.getString("Maquette31", "")))
                editor.remove("Maquette31")
                data.put("Maquette32", JSONObject(savedState.getString("Maquette32", "")))
                editor.remove("Maquette32")
                data.put("MaquettesOtherData", JSONArray(savedState.getString("MaquettesOtherData", "")))
                editor.remove("MaquettesOtherData")
                editor.remove("VydInfo")
                editor.remove("MaquettesOther")
                editor.putBoolean("Started", false)
                editor.apply()

                var rez = data.toString()
                if(rez.contains("\""))
                    rez = rez.replace("\"","\\\"")
                rez = "\"" + rez + "\""

                Log.d("result", rez)

                val requestQueue = Volley.newRequestQueue(this)
                val auth_url = "http://192.168.1.66/json_d/get_json.php"
                val stringRequest: StringRequest = object : StringRequest(
                    Method.POST, auth_url,
                    Response.Listener { response ->
                        //Log.d("response", response.toString())
                    },
                    Response.ErrorListener { error -> Log.d("response", error.toString())
                        error.printStackTrace()
                        val toast = Toast.makeText(this, error.toString(), Toast.LENGTH_LONG)
                        toast.show() }) {
                    override fun getParams(): Map<String, String>? {
                        val params: MutableMap<String, String> = HashMap()
                        params["data"] = rez
                        return params
                    }
                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        val params: MutableMap<String, String> = HashMap()
                        params["Content-Type"] = "application/x-www-form-urlencoded"
                        return params
                    }
                }
                requestQueue.add(stringRequest)

                val mainActivityIntent = Intent(this, MainActivity::class.java)
                startActivity(mainActivityIntent)
            }
            builder.show()
        }

        val retreatButton = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.retreatButton)
        retreatButton?.setOnClickListener { View ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Прекращение работы")
            builder.setMessage("Вы уверены, что хотите прекратить работу с выделом?")
            builder.setNegativeButton("Нет"){ dialog, id -> }
            builder.setPositiveButton("Да") { dialog, id ->
                editor.remove("NNN")
                editor.remove("Maquette1")
                editor.remove("Maquette2")
                editor.remove("Maquette3")
                editor.remove("Maquette4")
                editor.remove("Maquette10")
                editor.remove("Maquette31")
                editor.remove("Maquette32")
                editor.remove("MaquettesOtherData")
                editor.remove("VydInfo")
                editor.remove("MaquettesOther")
                editor.putBoolean("Started", false)
                editor.apply()
                val mainActivityIntent = Intent(this, MainActivity::class.java)
                startActivity(mainActivityIntent)
            }
            builder.show()
        }
    }

    fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter = listView.adapter ?: return
        val desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.width, View.MeasureSpec.UNSPECIFIED)
        var totalHeight = 0
        var view: View? = null
        for (i in 0 until listAdapter.count) {
            view = listAdapter.getView(i, view, listView)
            if (i == 0) view.layoutParams =
                ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.MATCH_PARENT)
            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
            totalHeight += view.measuredHeight
        }
        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        listView.layoutParams = params
        listView.requestLayout()
    }
}
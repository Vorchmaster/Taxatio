package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class VydSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vyd_select)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var list: JSONArray = JSONArray(intent.getStringExtra("list"))

        val gridView = findViewById<GridView>(R.id.questsGridView)
        val adapter = QuestItemAdapter(this, list)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { adapterView, view, i, l ->

            var par = gridView.adapter.getItem(i) as JSONObject
            var string = ""
            val requestQueue = Volley.newRequestQueue(this)
            val url = "http://192.168.1.66/json_d/Json_pol_vydel.php"
            val stringRequest: StringRequest = object : StringRequest(
                Method.POST, url,
                Response.Listener { response -> //let's parse json data
                    string = response.toString()
                    Log.d("response", response.toString())
                    if(string.contains("}},"))
                        string = string.replace("}},","}")
                    if (!(response.toString().equals("FAILURE", true))) {
                        var str = JSONObject(string)
                        Log.d("rez", str.toString())
                        editor.putString("VydInfo", str.toString())
                        editor.apply()
                    }
                    else{
                        editor.putString("VydInfo", "")
                        editor.apply()
                    }
                },
                Response.ErrorListener { error -> Log.d("response", error.toString())
                    error.printStackTrace()
                    val toast = Toast.makeText(this, error.toString(), Toast.LENGTH_LONG)
                    toast.show() }) {
                override fun getParams(): Map<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["NNN"] = par.get("NNN").toString()
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


            var maq = ""
            val dop_url = "http://192.168.1.66/json_d/dop_info.php"
            val stringRequest1: StringRequest = object : StringRequest(
                Method.POST, dop_url,
                Response.Listener { response -> //let's parse json data
                    maq = response.toString()
                    Log.d("response", response.toString())
                    if(maq.contains("}},"))
                        maq = maq.replace("}},","}")
                    editor.putString("VydInfo",  string)
                    if(maq.contains("\\/"))
                        maq = maq.replace("\\/","/")
                    if(maq.contains(",]"))
                        maq = maq.replace(",]","]")
                    Log.d("response", maq)
                    var maquette = JSONArray(maq)
                    Log.d("rez", maquette.toString())
                    editor.putString("MaquettesOther",  maquette.toString())
                    editor.apply()
                },
                Response.ErrorListener { error -> Log.d("response", error.toString())
                    error.printStackTrace()
                    val toast = Toast.makeText(this, error.toString(), Toast.LENGTH_LONG)
                    toast.show() }) {
                override fun getParams(): Map<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["N"] = par.get("N").toString()
                    return params
                }
                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["Content-Type"] = "application/x-www-form-urlencoded"
                    return params
                }
            }
            requestQueue.add(stringRequest1)

            if (savedState.contains("VydInfo") and savedState.contains("MaquettesOther")) {
                val questItemIntent = Intent(this, taxatioCardActivity::class.java)
                editor.putString("NNN", par.get("NNN").toString())
                editor.putBoolean("Started",  true)
                editor.apply()
                startActivity(questItemIntent)
            }
            else{
                val toast = Toast.makeText(this, "Попробуйте снова!", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}
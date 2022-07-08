package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import org.json.JSONArray
import org.json.JSONObject

class MaquetteOther : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette_other)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var fields = JSONObject(intent.getStringExtra("fields"))
        var data: JSONArray
        var maquette = JSONObject()
        var ismaq = false
        if(savedState.contains("MaquettesOtherData")){
            data = JSONArray(savedState.getString("MaquettesOtherData", ""))
            maquette = JSONObject()
            for(i in 0 until data.length()){
                var a = data[i] as JSONObject
                if (a.get("MAKET") == (fields.getString("NUMBER")))
                ismaq=true
            }
        } else {
            data = JSONArray()
        }

        if (ismaq){
            for(i in 0..data.length()-1){
                var a = data[i] as JSONObject
                if (a.get("MAKET") == (fields.getString("NUMBER")))
                    maquette = a
            }
        }

        val MAKET: TextView? = findViewById(R.id.maquetteNumber)
        MAKET?.text = "Макет " + fields.get("NUMBER") + ": " + fields.get("N0")

        val N1text : TextView? = findViewById(R.id.N1)
        val N2text : TextView? = findViewById(R.id.N2)
        val N3text : TextView? = findViewById(R.id.N3)
        val N4text : TextView? = findViewById(R.id.N4)
        val N5text : TextView? = findViewById(R.id.N5)
        val N6text : TextView? = findViewById(R.id.N6)
        val N7text : TextView? = findViewById(R.id.N7)
        val N8text : TextView? = findViewById(R.id.N8)
        val N1: EditText? = findViewById(R.id.N1Edit)
        val N2: EditText? = findViewById(R.id.N2Edit)
        val N3: EditText? = findViewById(R.id.N3Edit)
        val N4: EditText? = findViewById(R.id.N4Edit)
        val N5: EditText? = findViewById(R.id.N5Edit)
        val N6: EditText? = findViewById(R.id.N6Edit)
        val N7: EditText? = findViewById(R.id.N7Edit)
        val N8: EditText? = findViewById(R.id.N8Edit)

        if (fields.has("N1") and !(fields.get("N1").toString().equals("null", true))) {
            N1text?.text = fields.get("N1").toString()
            if(maquette.has("N1"))
                N1?.setText(maquette.get("N1").toString())
        }
        else {
            N1text?.visibility = View.GONE
            N1?.visibility = View.GONE
        }

        if (fields.has("N2") and !(fields.get("N2").toString().equals("null", true))) {
            N2text?.text = fields.get("N2").toString()
            if(maquette.has("N2"))
                N2?.setText(maquette.get("N2").toString())
        }
        else {
            N2text?.visibility = View.GONE
            N2?.visibility = View.GONE
        }

        if (fields.has("N3") and !(fields.get("N3").toString().equals("null", true))) {
            N3text?.text = fields.get("N3").toString()
            if(maquette.has("N3"))
                N3?.setText(maquette.get("N3").toString())
        }
        else {
            N3text?.visibility = View.GONE
            N3?.visibility = View.GONE
        }

        if (fields.has("N4") and !(fields.get("N4").toString().equals("null", true))) {
            N4text?.text = fields.get("N4").toString()
            if(maquette.has("N4"))
                N4?.setText(maquette.get("N4").toString())
        }
        else {
            N4text?.visibility = View.GONE
            N4?.visibility = View.GONE
        }

        if (fields.has("N5") and !(fields.get("N5").toString().equals("null", true))) {
            N5text?.text = fields.get("N5").toString()
            if(maquette.has("N5"))
                N5?.setText(maquette.get("N5").toString())
        }
        else {
            N5text?.visibility = View.GONE
            N5?.visibility = View.GONE
        }

        if (fields.has("N6") and !(fields.get("N6").toString().equals("null", true))) {
            N6text?.text = fields.get("N6").toString()
            if(maquette.has("N6"))
                N5?.setText(maquette.get("N6").toString())
        }
        else {
            N6text?.visibility = View.GONE
            N6?.visibility = View.GONE
        }

        if (fields.has("N7") and !(fields.get("N7").toString().equals("null", true))) {
            N7text?.text = fields.get("N7").toString()
            if(maquette.has("N7"))
                N7?.setText(maquette.get("N7").toString())
        }
        else {
            N7text?.visibility = View.GONE
            N7?.visibility = View.GONE
        }

        if (fields.has("N8") and !(fields.get("N8").toString().equals("null", true))) {
            N8text?.text = fields.get("N8").toString()
            if(maquette.has("N8"))
                N8?.setText(maquette.get("N8").toString())
        }
        else {
            N8text?.visibility = View.GONE
            N8?.visibility = View.GONE
        }

        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)

        sendButton?.setOnClickListener { View ->
            maquette.put("MAKET", fields.get("NUMBER"))
            if (fields.has("N1"))
                maquette.put("N1", N1?.getText())
            else
                maquette.put("N1", null)
            if (fields.has("N2"))
                maquette.put("N2", N2?.getText())
            else
                maquette.put("N2", null)
            if (fields.has("N3"))
                maquette.put("N3", N3?.getText())
            else
                maquette.put("N3", null)
            if (fields.has("N4"))
                maquette.put("N4", N4?.getText())
            else
                maquette.put("N4", null)
            if (fields.has("N5"))
                maquette.put("N5", N5?.getText())
            else
                maquette.put("N5", null)
            if (fields.has("N6"))
                maquette.put("N6", N6?.getText())
            else
                maquette.put("N6", null)
            if (fields.has("N7"))
                maquette.put("N7", N7?.getText())
            else
                maquette.put("N7", null)
            if (fields.has("N8"))
                maquette.put("N8", N8?.getText())
            else
                maquette.put("N8", null)


            if(ismaq) {
                for (i in 0 until data.length()) {
                    var a = data[i] as JSONObject
                    if (a.get("MAKET") == (fields.getString("NUMBER"))) {
                        data.remove(i)
                        data.put(maquette)
                    }
                }
            }
            else{
                data.put(maquette)
            }

            Log.d("result", data.toString())
            editor.putString("MaquettesOtherData", data.toString())
            editor.apply()

            val taxatioCardIntent = Intent(this, taxatioCardActivity::class.java)
            startActivity(taxatioCardIntent)
        }

        retreatButton?.setOnClickListener { View ->
            val taxatioCardIntent = Intent(this, taxatioCardActivity::class.java)
            startActivity(taxatioCardIntent)
        }

    }
}
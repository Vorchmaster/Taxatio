package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.json.JSONObject

class Maquette32 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette32)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var maquette: JSONObject

        val GUSPDL: Spinner? = findViewById(R.id.densityEdit)
        val Gadapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.GUSPDLlist, R.layout.spinner_item)
        GUSPDL?.setAdapter(Gadapter)
        val PORPDL1: EditText? = findViewById(R.id.underGrowthType1Edit)
        val PORPDL2: EditText? = findViewById(R.id.underGrowthType2Edit)
        val PORPDL3: EditText? = findViewById(R.id.underGrowthType3Edit)

        val GUSPDLtext: TextView? = findViewById(R.id.density)
        GUSPDLtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Cтепень густоты подлеска в соответствии с классификатором (1-редкий, 2-средней густоты, 3-густой)", Toast.LENGTH_LONG)
            toast.show()
        }
        val PORPDL1text: TextView? = findViewById(R.id.underGrowthType1)
        PORPDL1text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Кодовое обозначение породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val PORPDL2text: TextView? = findViewById(R.id.underGrowthType2)
        PORPDL2text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Кодовое обозначение породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val PORPDL3text: TextView? = findViewById(R.id.underGrowthType3)
        PORPDL3text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Кодовое обозначение породы", Toast.LENGTH_LONG)
            toast.show()
        }

        if(savedState.contains("Maquette32")) {
            maquette = JSONObject(savedState.getString("Maquette32", ""))
            for(i in 0 .. 3) {
                GUSPDL?.setSelection(i)
                if(maquette.get("GUSPDL").toString() == GUSPDL?.getSelectedItem().toString())
                    break
                else
                    GUSPDL?.setSelection(0)
            }
            PORPDL1?.setText((maquette.get("PORPDL1").toString()), TextView.BufferType.EDITABLE)
            PORPDL2?.setText((maquette.get("PORPDL2").toString()), TextView.BufferType.EDITABLE)
            PORPDL3?.setText((maquette.get("PORPDL3").toString()), TextView.BufferType.EDITABLE)
        }  else {
            maquette = JSONObject()
        }

        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)

        sendButton?.setOnClickListener { View ->
            maquette.put("GUSPDL", GUSPDL?.getSelectedItem().toString())
            maquette.put("PORPDL1", PORPDL1?.getText())
            maquette.put("PORPDL2", PORPDL2?.getText())
            maquette.put("PORPDL3", PORPDL3?.getText())

            editor.putString("Maquette32", maquette.toString())
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
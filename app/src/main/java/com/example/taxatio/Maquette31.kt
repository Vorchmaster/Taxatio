package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import org.json.JSONObject

class Maquette31 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette31)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var maquette: JSONObject

        var KOLPODbool = true
        var VYSPODbool = true
        var VOZPODbool = true
        var KOFPOD1bool = true
        var KOFPOD2bool = true
        var KOFPOD3bool = true

        val KOLPOD: EditText? = findViewById(R.id.quantityEdit)
        KOLPOD?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KOLPOD?.getText().toString().toIntOrNull() == null){
                    KOLPOD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOLPODbool = false
                }
                else{
                    if (KOLPOD?.getText().toString().toInt() < 0) {
                        KOLPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPODbool = false
                    }
                    else {
                        KOLPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPODbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KOLPOD?.getText().toString().toIntOrNull() == null){
                    KOLPOD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOLPODbool = false
                }
                else{
                    if (KOLPOD?.getText().toString().toInt() < 0) {
                        KOLPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPODbool = false
                    }
                    else {
                        KOLPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPODbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val VYSPOD: EditText? = findViewById(R.id.underWoodHeightEdit)
        VYSPOD?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (VYSPOD?.getText().toString().toFloatOrNull() == null){
                    VYSPOD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    VYSPODbool = false
                }
                else{
                    if (VYSPOD?.getText().toString().toFloat() < 0) {
                        VYSPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSPODbool = false
                    }
                    else {
                        VYSPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSPODbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (VYSPOD?.getText().toString().toFloatOrNull() == null){
                    VYSPOD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    VYSPODbool = false
                }
                else{
                    if (VYSPOD?.getText().toString().toFloat() < 0) {
                        VYSPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSPODbool = false
                    }
                    else {
                        VYSPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSPODbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val VOZPOD: EditText? = findViewById(R.id.underWoodAgeEdit)
        VOZPOD?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (VOZPOD?.getText().toString().toIntOrNull() == null){
                    VOZPOD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    VOZPODbool = false
                }
                else{
                    if (VOZPOD?.getText().toString().toInt() < 0) {
                        VOZPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZPODbool = false
                    }
                    else {
                        VOZPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZPODbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (VOZPOD?.getText().toString().toIntOrNull() == null){
                    VOZPOD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    VOZPODbool = false
                }
                else{
                    if (VOZPOD?.getText().toString().toInt() < 0) {
                        VOZPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZPODbool = false
                    }
                    else {
                        VOZPOD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZPODbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val KOFPOD1: EditText? = findViewById(R.id.underWoodKoef1Edit)
        KOFPOD1?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KOFPOD1?.getText().toString().toFloatOrNull() == null){
                    KOFPOD1.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOFPOD1bool = false
                }
                else{
                    if (KOFPOD1?.getText().toString().toFloat() < 0){
                        KOFPOD1.getBackground().setColorFilter(getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP)
                        KOFPOD1bool = false
                    }
                    else {
                        KOFPOD1.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFPOD1bool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KOFPOD1?.getText().toString().toFloatOrNull() == null){
                    KOFPOD1.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOFPOD1bool = false
                }
                else{
                    if (KOFPOD1?.getText().toString().toFloat() < 0){
                        KOFPOD1.getBackground().setColorFilter(getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP)
                        KOFPOD1bool = false
                    }
                    else {
                        KOFPOD1.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFPOD1bool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val PORPOD1: EditText? = findViewById(R.id.underWoodType1Edit)

        val KOFPOD2: EditText? = findViewById(R.id.underWoodKoef2Edit)
        KOFPOD2?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KOFPOD2?.getText().toString().toFloatOrNull() == null){
                    KOFPOD2.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOFPOD2bool = false
                }
                else{
                    if (KOFPOD2?.getText().toString().toFloat() < 0){
                        KOFPOD2.getBackground().setColorFilter(getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP)
                        KOFPOD2bool = false
                    }
                    else {
                        KOFPOD2.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFPOD2bool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KOFPOD2?.getText().toString().toFloatOrNull() == null){
                    KOFPOD2.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOFPOD2bool = false
                }
                else{
                    if (KOFPOD2?.getText().toString().toFloat() < 0){
                        KOFPOD2.getBackground().setColorFilter(getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP)
                        KOFPOD2bool = false
                    }
                    else {
                        KOFPOD2.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFPOD2bool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val PORPOD2: EditText? = findViewById(R.id.underWoodType2Edit)

        val KOFPOD3: EditText? = findViewById(R.id.underWoodKoef3Edit)
        KOFPOD3?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KOFPOD3?.getText().toString().toFloatOrNull() == null){
                    KOFPOD3.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOFPOD3bool = false
                }
                else{
                    if (KOFPOD3?.getText().toString().toFloat() < 0){
                        KOFPOD3.getBackground().setColorFilter(getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP)
                        KOFPOD3bool = false
                    }
                    else {
                        KOFPOD3.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFPOD3bool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KOFPOD3?.getText().toString().toFloatOrNull() == null){
                    KOFPOD3.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOFPOD3bool = false
                }
                else{
                    if (KOFPOD3?.getText().toString().toFloat() < 0){
                        KOFPOD3.getBackground().setColorFilter(getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP)
                        KOFPOD3bool = false
                    }
                    else {
                        KOFPOD3.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFPOD3bool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val PORPOD3: EditText? = findViewById(R.id.underWoodType3Edit)

        val OSNPOR: Spinner? = findViewById(R.id.markEdit)
        val Oadapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.ERZSKLlist, R.layout.spinner_item)
        OSNPOR?.setAdapter(Oadapter)

        val KOLPODtext: TextView? = findViewById(R.id.quantity)
        KOLPODtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Количество подроста в тыс.шт на 1 га с точностью до 0,1", Toast.LENGTH_LONG)
            toast.show()
        }
        val VYSPODtext: TextView? = findViewById(R.id.underWoodHeight)
        VYSPODtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Средняя высота древесных пород, образующих подрост насаждения - в метрах, с точностью до 0,1", Toast.LENGTH_LONG)
            toast.show()
        }
        val VOZPODtext: TextView? = findViewById(R.id.underWoodAge)
        VOZPODtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Средний возраст, исчисленный для всех составляющих древесных пород", Toast.LENGTH_LONG)
            toast.show()
        }
        val KOFPOD1text: TextView? = findViewById(R.id.underWoodKoef1)
        KOFPOD1text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Коэффициент древесной породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val PORPOD1text: TextView? = findViewById(R.id.underWoodType1)
        PORPOD1text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Кодовое обозначение породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val KOFPOD2text: TextView? = findViewById(R.id.underWoodKoef2)
        KOFPOD2text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Коэффициент древесной породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val PORPOD2text: TextView? = findViewById(R.id.underWoodType2)
        PORPOD2text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Кодовое обозначение породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val KOFPOD3text: TextView? = findViewById(R.id.underWoodKoef3)
        KOFPOD3text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Коэффициент древесной породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val PORPOD3text: TextView? = findViewById(R.id.underWoodType3)
        PORPOD3text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Кодовое обозначение породы", Toast.LENGTH_LONG)
            toast.show()
        }
        val OSNPORtext: TextView? = findViewById(R.id.mark)
        OSNPORtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Идентификатор оценки подроста (1-благонадежный, 2-неблагонадежный)", Toast.LENGTH_LONG)
            toast.show()
        }

        if(savedState.contains("Maquette31")) {
            maquette = JSONObject(savedState.getString("Maquette31", ""))
            KOLPOD?.setText((maquette.get("KOLPOD").toString()), TextView.BufferType.EDITABLE)
            VYSPOD?.setText((maquette.get("VYSPOD").toString()), TextView.BufferType.EDITABLE)
            VOZPOD?.setText((maquette.get("VOZPOD").toString()), TextView.BufferType.EDITABLE)
            KOFPOD1?.setText((maquette.get("KOFPOD1").toString()), TextView.BufferType.EDITABLE)
            PORPOD1?.setText((maquette.get("PORPOD1").toString()), TextView.BufferType.EDITABLE)
            KOFPOD2?.setText((maquette.get("KOFPOD2").toString()), TextView.BufferType.EDITABLE)
            PORPOD2?.setText((maquette.get("PORPOD2").toString()), TextView.BufferType.EDITABLE)
            KOFPOD3?.setText((maquette.get("KOFPOD3").toString()), TextView.BufferType.EDITABLE)
            PORPOD3?.setText((maquette.get("PORPOD3").toString()), TextView.BufferType.EDITABLE)
            for(i in 0 .. 2) {
                OSNPOR?.setSelection(i)
                if(maquette.get("OSNPOR").toString() == OSNPOR?.getSelectedItem().toString())
                    break
                else
                    OSNPOR?.setSelection(0)
            }
        } else {
            maquette = JSONObject()
        }

        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)

        sendButton?.setOnClickListener { View ->
            if ((KOLPODbool) and (VYSPODbool) and (VOZPODbool) and (KOFPOD1bool) and (KOFPOD2bool) and (KOFPOD3bool)) {
                maquette.put("KOLPOD", KOLPOD?.getText())
                maquette.put("VYSPOD", VYSPOD?.getText())
                maquette.put("VOZPOD", VOZPOD?.getText())
                maquette.put("KOFPOD1", KOFPOD1?.getText())
                maquette.put("PORPOD1", PORPOD1?.getText())
                maquette.put("KOFPOD2", KOFPOD2?.getText())
                maquette.put("PORPOD2", PORPOD2?.getText())
                maquette.put("KOFPOD3", KOFPOD3?.getText())
                maquette.put("PORPOD3", PORPOD3?.getText())
                maquette.put("OSNPOR", OSNPOR?.getSelectedItem().toString())

                editor.putString("Maquette31", maquette.toString())
                editor.apply()

                val taxatioCardIntent = Intent(this, taxatioCardActivity::class.java)
                startActivity(taxatioCardIntent)
            }
            else {
                val toast = Toast.makeText(this, "Допущены ошибки в заполнении", Toast.LENGTH_LONG)
                toast.show()
            }
        }

        retreatButton?.setOnClickListener { View ->
            val taxatioCardIntent = Intent(this, taxatioCardActivity::class.java)
            startActivity(taxatioCardIntent)
        }

    }
}
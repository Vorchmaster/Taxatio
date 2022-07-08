package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject

class Maquette3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette3)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var maquette: JSONObject

        var GODVIRbool = true
        var KOLPNIbool = true
        var KPSbool = true
        var DIMPNIbool = true

        val POR: EditText? = findViewById(R.id.typeEdit)

        val BON: EditText? = findViewById(R.id.bonytetEdit)

        val TIPLES: EditText? = findViewById(R.id.forestTypeEdit)

        val TLU: EditText? = findViewById(R.id.TLUEdit)

        val GODVIR: EditText? = findViewById(R.id.chopYearEdit)
        GODVIR?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (GODVIR?.getText().toString().toIntOrNull() == null){
                    GODVIR.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    GODVIRbool = false
                }
                else{
                    if (GODVIR?.getText().toString().toInt() < 0) {
                        GODVIR.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        GODVIRbool = false
                    }
                    else {
                        GODVIR.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        GODVIRbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (GODVIR?.getText().toString().toIntOrNull() == null){
                    GODVIR.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    GODVIRbool = false
                }
                else{
                    if (GODVIR?.getText().toString().toInt() < 0) {
                        GODVIR.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        GODVIRbool = false
                    }
                    else {
                        GODVIR.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        GODVIRbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val KOLPNI: EditText? = findViewById(R.id.stumpsAllEdit)
        KOLPNI?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KOLPNI?.getText().toString().toIntOrNull() == null){
                    KOLPNI.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOLPNIbool = false
                }
                else{
                    if (KOLPNI?.getText().toString().toInt() < 0) {
                        KOLPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPNIbool = false
                    }
                    else {
                        KOLPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPNIbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KOLPNI?.getText().toString().toIntOrNull() == null){
                    KOLPNI.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KOLPNIbool = false
                }
                else{
                    if (KOLPNI?.getText().toString().toInt() < 0) {
                        KOLPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPNIbool = false
                    }
                    else {
                        KOLPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOLPNIbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val KPS: EditText? = findViewById(R.id.pineStumpsEdit)
        KPS?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KPS?.getText().toString().toIntOrNull() == null){
                    KPS.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KPSbool = false
                }
                else{
                    if (KPS?.getText().toString().toInt() < 0) {
                        KPS.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KPSbool = false
                    }
                    else {
                        KPS.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KPSbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KPS?.getText().toString().toIntOrNull() == null){
                    KPS.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    KPSbool = false
                }
                else{
                    if (KPS?.getText().toString().toInt() < 0) {
                        KPS.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KPSbool = false
                    }
                    else {
                        KPS.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KPSbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val DIMPNI: EditText? = findViewById(R.id.stumpsDEdit)
        DIMPNI?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (DIMPNI?.getText().toString().toIntOrNull() == null){
                    DIMPNI.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    DIMPNIbool = false
                }
                else{
                    if (DIMPNI?.getText().toString().toInt() < 0) {
                        DIMPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMPNIbool = false
                    }
                    else {
                        DIMPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMPNIbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (DIMPNI?.getText().toString().toIntOrNull() == null){
                    DIMPNI.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    DIMPNIbool = false
                }
                else{
                    if (DIMPNI?.getText().toString().toInt() < 0) {
                        DIMPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMPNIbool = false
                    }
                    else {
                        DIMPNI.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMPNIbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val TIPVYR: EditText? = findViewById(R.id.chopTypeEdit)


        val PORtext: TextView? = findViewById(R.id.type)
        PORtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Главная порода кодом по классификатору", Toast.LENGTH_LONG)
            toast.show()
        }
        val BONtext: TextView? = findViewById(R.id.bonytet)
        BONtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Класс бонитета - цифровыми индексами при необходимости с буквенным индексом (1б,1а,1,2,3,4,5,5а,5б)", Toast.LENGTH_LONG)
            toast.show()
        }
        val TIPLEStext: TextView? = findViewById(R.id.forestType)
        TIPLEStext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Индекс типа леса - принятые сокращения (максимум 5 символов)", Toast.LENGTH_LONG)
            toast.show()
        }
        val TLUtext: TextView? = findViewById(R.id.TLU)
        TLUtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Тип лесорастительных условий - код до 5 символов", Toast.LENGTH_LONG)
            toast.show()
        }
        val GODVIRtext: TextView? = findViewById(R.id.chopYear)
        GODVIRtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Год вырубки", Toast.LENGTH_LONG)
            toast.show()
        }
        val KOLPNItext: TextView? = findViewById(R.id.stumpsAll)
        KOLPNItext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Количество пней (шт на 1 га)", Toast.LENGTH_LONG)
            toast.show()
        }
        val KPStext: TextView? = findViewById(R.id.pineStumps)
        KPStext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Количество пней сосен (шт на 1 га)", Toast.LENGTH_LONG)
            toast.show()
        }
        val DIMPNItext: TextView? = findViewById(R.id.stumpsD)
        DIMPNItext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Средний диаметр пней в см", Toast.LENGTH_LONG)
            toast.show()
        }
        val TIPVYRtext: TextView? = findViewById(R.id.chopType)
        TIPVYRtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Тип вырубки\n" +
                    "лш-лишайниковая,\n" +
                    "вр-вересковая,\n" +
                    "ав-вейниковая,\n" +
                    "ал-луговиковая,\n" +
                    "к-кипрейная,\n" +
                    "ат-таволговая,\n" +
                    "д-долгомошная,\n" +
                    "щ-щучковая.", Toast.LENGTH_LONG)
            toast.show()
        }

        if(savedState.contains("Maquette3")) {
            maquette = JSONObject(savedState.getString("Maquette3", ""))
            POR?.setText((maquette.get("POR").toString()), TextView.BufferType.EDITABLE)
            BON?.setText((maquette.get("BON").toString()), TextView.BufferType.EDITABLE)
            TIPLES?.setText((maquette.get("TIPLES").toString()), TextView.BufferType.EDITABLE)
            TLU?.setText((maquette.get("TLU").toString()), TextView.BufferType.EDITABLE)
            GODVIR?.setText((maquette.get("GODVIR").toString()), TextView.BufferType.EDITABLE)
            KOLPNI?.setText((maquette.get("KOLPNI").toString()), TextView.BufferType.EDITABLE)
            KPS?.setText((maquette.get("KPS").toString()), TextView.BufferType.EDITABLE)
            DIMPNI?.setText((maquette.get("DIMPNI").toString()), TextView.BufferType.EDITABLE)
            TIPVYR?.setText((maquette.get("TIPVYR").toString()), TextView.BufferType.EDITABLE)
        } else {
            maquette = JSONObject()
        }

        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)

        sendButton?.setOnClickListener { View ->
            if ((GODVIRbool) and (KOLPNIbool) and (KPSbool) and (DIMPNIbool)) {
                maquette.put("POR", POR?.getText())
                maquette.put("BON", BON?.getText())
                maquette.put("TIPLES", TIPLES?.getText())
                maquette.put("TLU", TLU?.getText())
                maquette.put("GODVIR", GODVIR?.getText())
                maquette.put("KOLPNI", KOLPNI?.getText())
                maquette.put("KPS", KPS?.getText())
                maquette.put("DIMPNI", DIMPNI?.getText())
                maquette.put("TIPVYR", TIPVYR?.getText())

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
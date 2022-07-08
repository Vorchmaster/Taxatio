package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject

class Maquette2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette2)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var maquette: JSONObject

        var PRCVYR1bool = true

        val HOZMER1: EditText? = findViewById(R.id.meropr1Edit)

        val PRCVYR1: EditText? = findViewById(R.id.meropr1PercentEdit)
        PRCVYR1?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (PRCVYR1?.getText().toString().toIntOrNull() == null){
                    PRCVYR1.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    PRCVYR1bool = false
                }
                else{
                    if ((PRCVYR1?.getText().toString().toInt() > 100) or (PRCVYR1?.getText().toString().toInt() < 0)) {
                        PRCVYR1.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        PRCVYR1bool = false
                    }
                    else {
                        PRCVYR1.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        PRCVYR1bool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (PRCVYR1?.getText().toString().toIntOrNull() == null){
                    PRCVYR1.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    PRCVYR1bool = false
                }
                else{
                    if ((PRCVYR1?.getText().toString().toInt() > 100) or (PRCVYR1?.getText().toString().toInt() < 0)) {
                        PRCVYR1.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        PRCVYR1bool = false
                    }
                    else {
                        PRCVYR1.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        PRCVYR1bool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val NOMRTK1: EditText? = findViewById(R.id.meropr1RTKNumEdit)

        val HOZMER2: EditText? = findViewById(R.id.meropr2Edit)

        val NOMRTK2: EditText? = findViewById(R.id.meropr2RTKNumEdit)

        val HOZMER3: EditText? = findViewById(R.id.meropr3Edit)

        val NOMRTK3: EditText? = findViewById(R.id.meropr3RTKNumEdit)

        val CELPOR: EditText? = findViewById(R.id.targetTypeEdit)


        val HOZMER1text: TextView? = findViewById(R.id.meropr1)
        HOZMER1text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Мероприятия, имеющие процент вырубки запаса, ставится на 1-ое место. Если на выделе одно мероприятие, оно всегда записывается на первое место.", Toast.LENGTH_LONG)
            toast.show()
        }
        val PRCVYR1text: TextView? = findViewById(R.id.meropr1Percent)
        PRCVYR1text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Процент проектируемого к выборке запаса - для несплошных рубок главного пользования, рубок ухода, всех видов реконструктивных рубок и выборочных санитарных рубок, если предусматривается уборка поврежденных  сырорастущих деревьев (от 5 до 100%)", Toast.LENGTH_LONG)
            toast.show()
        }
        val NOMRTK1text: TextView? = findViewById(R.id.meropr1RTKNum)
        NOMRTK1text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Расчётно-технологическая карта - номер схем лесовосстановления на участках не покрытых лесом земель, реконструктируемых насаждений и сплошных санитарных рубок, а также и для других хозмероприятий, если ртк разработаны.", Toast.LENGTH_LONG)
            toast.show()
        }
        val HOZMER2text: TextView? = findViewById(R.id.meropr2Edit)
        HOZMER2text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Процент проектируемого к выборке запаса - для несплошных рубок главного пользования, рубок ухода, всех видов реконструктивных рубок и выборочных санитарных рубок, если предусматривается уборка поврежденных  сырорастущих деревьев (от 5 до 100%)", Toast.LENGTH_LONG)
            toast.show()
        }
        val NOMRTK2text: TextView? = findViewById(R.id.meropr2RTKNum)
        NOMRTK2text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Расчётно-технологическая карта - номер схем лесовосстановления на участках не покрытых лесом земель, реконструктируемых насаждений и сплошных санитарных рубок, а также и для других хозмероприятий, если ртк разработаны.", Toast.LENGTH_LONG)
            toast.show()
        }
        val HOZMER3text: TextView? = findViewById(R.id.meropr3Edit)
        HOZMER3text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Процент проектируемого к выборке запаса - для несплошных рубок главного пользования, рубок ухода, всех видов реконструктивных рубок и выборочных санитарных рубок, если предусматривается уборка поврежденных  сырорастущих деревьев (от 5 до 100%)", Toast.LENGTH_LONG)
            toast.show()
        }
        val NOMRTK3text: TextView? = findViewById(R.id.meropr3RTKNum)
        NOMRTK3text?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Расчётно-технологическая карта - номер схем лесовосстановления на участках не покрытых лесом земель, реконструктируемых насаждений и сплошных санитарных рубок, а также и для других хозмероприятий, если ртк разработаны.", Toast.LENGTH_LONG)
            toast.show()
        }
        val CELPORtext: TextView? = findViewById(R.id.targetType)
        CELPORtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Кодовое обозначение древесной породы, отвечающее целям лесного хозяйства", Toast.LENGTH_LONG)
            toast.show()
        }

        if (savedState.contains("Maquette2")){
            maquette = JSONObject(savedState.getString("Maquette2", ""))
            HOZMER1?.setText((maquette.get("HOZMER1").toString()), TextView.BufferType.EDITABLE)
            PRCVYR1?.setText((maquette.get("PRCVYR1").toString()), TextView.BufferType.EDITABLE)
            NOMRTK1?.setText((maquette.get("NOMRTK1").toString()), TextView.BufferType.EDITABLE)
            HOZMER2?.setText((maquette.get("HOZMER2").toString()), TextView.BufferType.EDITABLE)
            NOMRTK2?.setText((maquette.get("NOMRTK2").toString()), TextView.BufferType.EDITABLE)
            HOZMER3?.setText((maquette.get("HOZMER3").toString()), TextView.BufferType.EDITABLE)
            NOMRTK3?.setText((maquette.get("NOMRTK3").toString()), TextView.BufferType.EDITABLE)
            CELPOR?.setText((maquette.get("CELPOR").toString()), TextView.BufferType.EDITABLE)

        }else {
            maquette = JSONObject()
        }

        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)

        sendButton?.setOnClickListener { View ->
            if (PRCVYR1bool) {
                maquette.put("HOZMER1", HOZMER1?.getText())
                maquette.put("PRCVYR1", PRCVYR1?.getText())
                maquette.put("NOMRTK1", NOMRTK1?.getText())
                maquette.put("HOZMER2", HOZMER2?.getText())
                maquette.put("NOMRTK2", NOMRTK2?.getText())
                maquette.put("HOZMER3", HOZMER3?.getText())
                maquette.put("NOMRTK3", NOMRTK3?.getText())
                maquette.put("CELPOR", CELPOR?.getText())

                val toast =
                    Toast.makeText(applicationContext, maquette.toString(), Toast.LENGTH_LONG)
                toast.show()
                editor.putString("Maquette2", maquette.toString())
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
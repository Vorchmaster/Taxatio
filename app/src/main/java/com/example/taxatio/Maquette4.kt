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

class Maquette4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette4)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var maquette: JSONObject

        var ZAPZAHbool = true
        var ZZLbool = true
        var ZAPSUHbool = true

        val ZAPZAH: EditText? = findViewById(R.id.сlutterinessEdit)
        ZAPZAH?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (ZAPZAH?.getText().toString().toIntOrNull() == null){
                    ZAPZAH.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZAPZAHbool = false
                }
                else{
                    if (ZAPZAH?.getText().toString().toInt() < 0) {
                        ZAPZAH.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPZAHbool = false
                    }
                    else {
                        ZAPZAH.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPZAHbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (ZAPZAH?.getText().toString().toIntOrNull() == null){
                    ZAPZAH.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZAPZAHbool = false
                }
                else{
                    if (ZAPZAH?.getText().toString().toInt() < 0) {
                        ZAPZAH.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPZAHbool = false
                    }
                    else {
                        ZAPZAH.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPZAHbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val ZZL: EditText? = findViewById(R.id.сlutterinessLikvEdit)
        ZZL?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (ZZL?.getText().toString().toIntOrNull() == null){
                    ZZL.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZZLbool = false
                }
                else{
                    if (ZZL?.getText().toString().toInt() < 0) {
                        ZZL.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZZLbool = false
                    }
                    else {
                        ZZL.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZZLbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (ZZL?.getText().toString().toIntOrNull() == null){
                    ZZL.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZZLbool = false
                }
                else{
                    if (ZZL?.getText().toString().toInt() < 0) {
                        ZZL.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZZLbool = false
                    }
                    else {
                        ZZL.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZZLbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val ZAPSUH: EditText? = findViewById(R.id.deadwoodEdit)
        ZAPSUH?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (ZAPSUH?.getText().toString().toIntOrNull() == null){
                    ZAPSUH.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZAPSUHbool = false
                }
                else{
                    if (ZAPSUH?.getText().toString().toInt() < 0) {
                        ZAPSUH.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPSUHbool = false
                    }
                    else {
                        ZAPSUH.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPSUHbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (ZAPSUH?.getText().toString().toIntOrNull() == null){
                    ZAPSUH.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZAPSUHbool = false
                }
                else{
                    if (ZAPSUH?.getText().toString().toInt() < 0) {
                        ZAPSUH.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPSUHbool = false
                    }
                    else {
                        ZAPSUH.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPSUHbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val INFO: EditText? = findViewById(R.id.textCommitEdit)

        val ZAPZAHtext: TextView? = findViewById(R.id.сlutteriness)
        ZAPZAHtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Захламлённость общая в кубических метрах на га", Toast.LENGTH_LONG)
            toast.show()
        }
        val ZZLtext: TextView? = findViewById(R.id.сlutterinessLikv)
        ZZLtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Захламлённость ликвидная в кубических метрах на га", Toast.LENGTH_LONG)
            toast.show()
        }
        val ZAPSUHtext: TextView? = findViewById(R.id.deadwood)
        ZAPSUHtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Сухостой в кубических метрах на га", Toast.LENGTH_LONG)
            toast.show()
        }

        if(savedState.contains("Maquette4")) {
            maquette = JSONObject(savedState.getString("Maquette4", ""))
            ZAPZAH?.setText((maquette.get("ZAPZAH").toString()), TextView.BufferType.EDITABLE)
            ZZL?.setText((maquette.get("ZZL").toString()), TextView.BufferType.EDITABLE)
            ZAPSUH?.setText((maquette.get("ZAPSUH").toString()), TextView.BufferType.EDITABLE)
            INFO?.setText((maquette.get("INFO").toString()), TextView.BufferType.EDITABLE)
        } else {
            maquette = JSONObject()
        }

        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)



        sendButton?.setOnClickListener { View ->
            if ((ZAPZAHbool) and (ZZLbool) and(ZAPSUHbool)) {
                maquette.put("ZAPZAH", ZAPZAH?.getText())
                maquette.put("ZZL", ZZL?.getText())
                maquette.put("ZAPSUH", ZAPSUH?.getText())
                maquette.put("INFO", INFO?.getText())

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
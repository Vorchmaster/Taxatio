package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import androidx.core.text.isDigitsOnly
import androidx.core.view.size
import org.json.JSONObject

class Maquette1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maquette1)

        val savedState: SharedPreferences = this.getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        var maquette: JSONObject

        var NOMVYDbool = true
        var PLSVYDbool = true
        var KRTSKLbool = true
        var VUMbool = true

        val NOMVYD: EditText? = findViewById(R.id.vydNumberEdit)
        NOMVYD?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (NOMVYD?.getText().toString().toIntOrNull() == null){
                    NOMVYD.getBackground().setColorFilter(
                        resources.getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    NOMVYDbool = false
                }
                else{
                    if (NOMVYD?.getText().toString().toInt() < 0) {
                        NOMVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        NOMVYDbool = false
                    }
                    else {
                        NOMVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        NOMVYDbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (NOMVYD?.getText().toString().toIntOrNull() == null){
                    NOMVYD.getBackground().setColorFilter(
                        resources.getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    NOMVYDbool = false
                }
                else {
                    if (NOMVYD?.getText().toString().toInt() < 0) {
                        NOMVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        NOMVYDbool = false
                    } else {
                        NOMVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        NOMVYDbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val PLSVYD: EditText? = findViewById(R.id.squareEdit)
        PLSVYD?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (PLSVYD?.getText().toString().toFloatOrNull() == null){
                    PLSVYD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    PLSVYDbool = false
                }
                else{
                    if (PLSVYD?.getText().toString().toFloat() < 0) {
                        PLSVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        PLSVYDbool = false
                    }
                    else {
                        PLSVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        PLSVYDbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (PLSVYD?.getText().toString().toFloatOrNull() == null){
                    PLSVYD.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    PLSVYDbool = false
                }
                else{
                    if (PLSVYD?.getText().toString().toFloat() < 0) {
                        PLSVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        PLSVYDbool = false
                    }
                    else {
                        PLSVYD.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        PLSVYDbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val KATZEM: EditText? = findViewById(R.id.groundCathegoryEdit)

        val HOZKAT: Spinner? = findViewById(R.id.DPEdit)
        val Hadapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.HOZKATlist, R.layout.spinner_item)
        HOZKAT?.setAdapter(Hadapter)

        val OZU: EditText? = findViewById(R.id.OZUEdit)

        val EKS: Spinner? = findViewById(R.id.expozitionEdit)
        val EKadapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.EKSlist, R.layout.spinner_item)
        EKS?.setAdapter(EKadapter)

        val KRTSKL: EditText? = findViewById(R.id.stepnessEdit)
        KRTSKL?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KRTSKL?.getText().toString().toIntOrNull() == null){
                    KRTSKL.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    KRTSKLbool = false
                }
                else{
                    if ((KRTSKL?.getText().toString().toInt() > 90) or (KRTSKL?.getText().toString().toInt() < 0)) {
                        KRTSKL.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        KRTSKLbool = false
                    }
                    else {
                        KRTSKL.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KRTSKLbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KRTSKL?.getText().toString().toIntOrNull() == null){
                    KRTSKL.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    KRTSKLbool = false
                }
                else{
                    if ((KRTSKL?.getText().toString().toInt() > 90) or (KRTSKL?.getText().toString().toInt() < 0)) {
                        KRTSKL.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        KRTSKLbool = false
                    }
                    else {
                        KRTSKL.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KRTSKLbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val VUM: EditText? = findViewById(R.id.VNUMEdit)
        VUM?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (VUM?.getText().toString().toIntOrNull() == null){
                    VUM.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    VUMbool = false
                }
                else{
                    if (VUM?.getText().toString().toInt() < 0) {
                        VUM.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        VUMbool = false
                    }
                    else {
                        VUM.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VUMbool = true
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (VUM?.getText().toString().toIntOrNull() == null){
                    VUM.getBackground().setColorFilter(getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    VUMbool = false
                }
                else{
                    if (VUM?.getText().toString().toInt() < 0) {
                        VUM.getBackground().setColorFilter(
                            getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        );
                        VUMbool = false
                    }
                    else {
                        VUM.getBackground().setColorFilter(
                            getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VUMbool = true
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val ERZSKL: Spinner? = findViewById(R.id.erozyKindEdit)
        val Eadapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.ERZSKLlist, R.layout.spinner_item)
        ERZSKL?.setAdapter(Eadapter)

        val STPERZ: Spinner? = findViewById(R.id.erozyStageEdit)
        val Sadapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.STPERZlist, R.layout.spinner_item)
        STPERZ?.setAdapter(Sadapter)

        val PLSVYDtext: TextView? = findViewById(R.id.square)
        PLSVYDtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "С точностью до 0.1 га", Toast.LENGTH_LONG)
            toast.show()
        }
        val KATZEMtext: TextView? = findViewById(R.id.groundCathegory)
        KATZEMtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Код категории земель", Toast.LENGTH_LONG)
            toast.show()
        }
        val HOZKATtext: TextView? = findViewById(R.id.DP)
        HOZKATtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Долгосрочное пользование:\n " +
                    "1 и 3 - передано в пользование другим организациям (1-искл. из расчёта, 3 - вкл. в расчёт.)\n" +
                    "2 и 4 соответственно - для земель переданных в с/х\n" +
                    "Либо - обозначения способов рубки, используемых при расчете размера  главного пользования:\n" +
                    "5-постепенные,\n" +
                    "6-груп.- выборочные,\n" +
                    "7-двр,\n" +
                    "8-длительно постепенные,\n" +
                    "9-резерв.", Toast.LENGTH_LONG)
            toast.show()
        }
        val OZUtext: TextView? = findViewById(R.id.OZU)
        OZUtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Особозащитный участок - заполнять, если выдел должен быть исключен из расчета размера главного пользования", Toast.LENGTH_LONG)
            toast.show()
        }
        val EKStext: TextView? = findViewById(R.id.expozition)
        EKStext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Экспозиция склонов первыми буквами сторон света: с, ю, з, в, св, юв, сз, юз", Toast.LENGTH_LONG)
            toast.show()
        }
        val KRTSKLtext: TextView? = findViewById(R.id.stepness)
        KRTSKLtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "В градусах от 5 до 90", Toast.LENGTH_LONG)
            toast.show()
        }
        val VUMtext: TextView? = findViewById(R.id.VNUM)
        VUMtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Высота над уровнем моря в метрах", Toast.LENGTH_LONG)
            toast.show()
        }
        val ERZSKLtext: TextView? = findViewById(R.id.erozyKind)
        ERZSKLtext?.setOnClickListener { View ->
            val toast = Toast.makeText(applicationContext, "Код вида эрозии: 1-водная, 2-ветровая", Toast.LENGTH_LONG)
            toast.show()
        }
        val STPERZtext: TextView? = findViewById(R.id.erozyStage)
        STPERZtext?.setOnClickListener { View ->
                val toast = Toast.makeText(applicationContext, "Степень эрозии: 1-слабая, 2-средняя, 3-сильная, 4-совсем смытые", Toast.LENGTH_LONG)
            toast.show()
        }

        if(savedState.contains("Maquette1")) {
            maquette = JSONObject(savedState.getString("Maquette1", ""))
            NOMVYD?.setText((maquette.get("NOMVYD").toString()), TextView.BufferType.EDITABLE)
            PLSVYD?.setText((maquette.get("PLSVYD").toString()), TextView.BufferType.EDITABLE)
            KATZEM?.setText((maquette.get("KATZEM").toString()), TextView.BufferType.EDITABLE)
            for(i in 0 .. 10) {
                HOZKAT?.setSelection(i)
                if(maquette.get("HOZKAT").toString() == HOZKAT?.getSelectedItem().toString())
                    break
                else
                    HOZKAT?.setSelection(0)
            }
            OZU?.setText((maquette.get("OZU").toString()), TextView.BufferType.EDITABLE)
            for(i in 0 .. 8) {
                EKS?.setSelection(i)
                if(maquette.get("EKS").toString() == EKS?.getSelectedItem().toString())
                    break
                else
                    EKS?.setSelection(0)
            }
            KRTSKL?.setText((maquette.get("KRTSKL").toString()), TextView.BufferType.EDITABLE)
            VUM?.setText((maquette.get("VUM").toString()), TextView.BufferType.EDITABLE)
            for(i in 0 .. 2) {
                ERZSKL?.setSelection(i)
                if(maquette.get("ERZSKL").toString() == ERZSKL?.getSelectedItem().toString())
                    break
                else
                    ERZSKL?.setSelection(0)
            }
            for(i in 0 .. 5) {
                STPERZ?.setSelection(i)
                if(maquette.get("STPERZ").toString() == STPERZ?.getSelectedItem().toString())
                    break
                else
                    STPERZ?.setSelection(0)
            }
        } else {
            maquette = JSONObject()
        }

        val sendButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.sendButton)
        val retreatButton: androidx.appcompat.widget.AppCompatButton? = findViewById(R.id.retreatButton)

        sendButton?.setOnClickListener { View ->
            if ((NOMVYDbool) and (KRTSKLbool) and (PLSVYDbool) and (VUMbool)){
            maquette.put("NOMVYD", NOMVYD?.getText())
            maquette.put("PLSVYD", PLSVYD?.getText())
            maquette.put("KATZEM", KATZEM?.getText())
            maquette.put("HOZKAT", HOZKAT?.getSelectedItem().toString())
            maquette.put("OZU", OZU?.getText())
            maquette.put("EKS", EKS?.getSelectedItem().toString())
            maquette.put("KRTSKL", KRTSKL?.getText())
            maquette.put("VUM", VUM?.getText())
            maquette.put("ERZSKL", ERZSKL?.getSelectedItem().toString())
            maquette.put("STPERZ", STPERZ?.getSelectedItem().toString())

            editor.putString("Maquette1", maquette.toString())
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

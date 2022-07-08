package com.example.taxatio

import android.content.Context
import android.graphics.PorterDuff
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.json.JSONArray
import org.json.JSONObject


class Maquette10Adapter(private var context: Context,private var  dataArray: JSONArray): BaseAdapter() {


    override fun getCount(): Int {
        return dataArray.length()
    }

    override fun getItem(p0: Int): Any {
        return dataArray.get(p0) as JSONObject
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.maquette10_item, p2, false)
        var a = dataArray.get(p0) as JSONObject

        if (p0 % 2 == 0){
            view.setBackgroundResource(R.color.white)
        }
        else{
            view.setBackgroundResource(R.color.gray)
        }

        val YAR: Spinner? = view.findViewById(R.id.tierEdit)
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(context, R.array.YARlist, R.layout.spinner_item)
        YAR?.setAdapter(adapter)
        val KOFSOS: EditText? = view.findViewById(R.id.structureKoefEdit)
        val POR: EditText? = view.findViewById(R.id.structureBreedEdit)
        val VOZ: EditText? = view.findViewById(R.id.ageEdit)
        val VYS: EditText? = view.findViewById(R.id.heightEdit)
        val DIM: EditText? = view.findViewById(R.id.diameterEdit)
        val KLSTOV: Spinner? = view.findViewById(R.id.productClassEdit)
        val Kadapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(context, R.array.GUSPDLlist, R.layout.spinner_item)
        KLSTOV?.setAdapter(Kadapter)
        val PRS: EditText? = view.findViewById(R.id.originEdit)
        val POL: EditText? = view.findViewById(R.id.completenessEdit)
        val SPS: EditText? = view.findViewById(R.id.eEdit)
        val ZAP: EditText? = view.findViewById(R.id.silosEdit)

        var KOFSOSbool = true
        var VOZbool = true
        var VYSbool = true
        var DIMbool = true
        var POLbool = true
        var SPSbool = true
        var ZAPbool = true

        fun istrue(){
            if((KOFSOSbool) and (VOZbool) and (VYSbool) and (DIMbool) and (POLbool) and (SPSbool) and (ZAPbool)){
                a.put("ISTRUE", "true")
                dataArray.put(p0, a)
            }
            else{
                a.put("ISTRUE", "false")
                dataArray.put(p0, a)
            }
        }

        for(i in 0 .. 10) {
            YAR?.setSelection(i)
            if(a.get("YAR").toString() == YAR?.getSelectedItem().toString())
                break
            else
                YAR?.setSelection(0)
        }
        KOFSOS?.setText(a.get("KOFSOS") as CharSequence, TextView.BufferType.EDITABLE)
        POR?.setText(a.get("POR") as CharSequence, TextView.BufferType.EDITABLE)
        VOZ?.setText(a.get("VOZ") as CharSequence, TextView.BufferType.EDITABLE)
        VYS?.setText(a.get("VYS") as CharSequence, TextView.BufferType.EDITABLE)
        DIM?.setText(a.get("DIM") as CharSequence, TextView.BufferType.EDITABLE)
        for(i in 0 .. 3) {
            KLSTOV?.setSelection(i)
            if(a.get("KLSTOV").toString() == KLSTOV?.getSelectedItem().toString())
                break
            else
                KLSTOV?.setSelection(0)
        }
        PRS?.setText(a.get("PRS") as CharSequence, TextView.BufferType.EDITABLE)
        POL?.setText(a.get("POL") as CharSequence, TextView.BufferType.EDITABLE)
        SPS?.setText(a.get("SPS") as CharSequence, TextView.BufferType.EDITABLE)
        ZAP?.setText(a.get("ZAP") as CharSequence, TextView.BufferType.EDITABLE)


        YAR?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                a.put("YAR", YAR?.getSelectedItem().toString())
                dataArray.put(p0, a)
            }

        }

        KOFSOS?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (KOFSOS?.getText().toString().toFloatOrNull() == null) {
                    KOFSOS.getBackground().setColorFilter(
                        context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP
                    )
                    KOFSOSbool = false
                    istrue()
                } else {
                    if ((KOFSOS?.getText().toString().toFloat() < 0) or (KOFSOS?.getText()
                            .toString().toFloat() >= 1)
                    ) {
                        KOFSOS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFSOSbool = false
                        istrue()
                    }
                    else {
                        KOFSOS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFSOSbool = true
                        istrue()
                        a.put("KOFSOS", KOFSOS.getText().toString())
                        dataArray.put(p0, a)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (KOFSOS?.getText().toString().toFloatOrNull() == null) {
                    KOFSOS.getBackground().setColorFilter(
                        context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP
                    )
                    KOFSOSbool = false
                    istrue()
                } else {
                    if ((KOFSOS?.getText().toString().toFloat() < 0) or (KOFSOS?.getText()
                            .toString().toFloat() >= 1)
                    ) {
                        KOFSOS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFSOSbool = false
                        istrue()
                    }
                    else {
                        KOFSOS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        KOFSOSbool = true
                        istrue()
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        POR?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                a.put("POR", POR.getText().toString())
                dataArray.put(p0, a)

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        VOZ?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (VOZ?.getText().toString().toIntOrNull() == null){
                    VOZ.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    VOZbool = false
                    istrue()
                }
                else {
                    if (VOZ?.getText().toString().toInt() < 0) {
                        VOZ.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZbool = false
                        istrue()
                    }
                    else {
                        VOZ.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZbool = true
                        istrue()
                        a.put("VOZ", VOZ.getText().toString())
                        dataArray.put(p0, a)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (VOZ?.getText().toString().toIntOrNull() == null){
                    VOZ.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    VOZbool = false
                    istrue()
                }
                else {
                    if (VOZ?.getText().toString().toInt() < 0) {
                        VOZ.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZbool = false
                        istrue()
                    }
                    else {
                        VOZ.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VOZbool = true
                        istrue()
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        VYS?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (VYS?.getText().toString().toFloatOrNull() == null){
                    VYS.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    VYSbool = false
                    istrue()
                }
                else {
                    if (VYS?.getText().toString().toFloat() < 0) {
                        VYS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSbool = false
                        istrue()
                    }
                    else {
                        VYS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSbool = true
                        istrue()
                        a.put("VYS", VYS.getText().toString())
                        dataArray.put(p0, a)
                    }
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (VYS?.getText().toString().toFloatOrNull() == null){
                    VYS.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    VYSbool = false
                    istrue()
                }
                else {
                    if (VYS?.getText().toString().toFloat() < 0) {
                        VYS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSbool = false
                        istrue()
                    }
                    else {
                        VYS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        VYSbool = true
                        istrue()
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        DIM?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (DIM?.getText().toString().toIntOrNull() == null){
                    DIM.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    DIMbool = false
                    istrue()
                }
                else {
                    if (DIM?.getText().toString().toInt() < 0) {
                        DIM.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMbool = false
                        istrue()
                    }
                    else {
                        DIM.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMbool = true
                        istrue()
                        a.put("DIM", DIM.getText().toString())
                        dataArray.put(p0, a)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (DIM?.getText().toString().toIntOrNull() == null){
                    DIM.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP);
                    DIMbool = false
                    istrue()
                }
                else {
                    if (DIM?.getText().toString().toInt() < 0) {
                        DIM.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMbool = false
                        istrue()
                    }
                    else {
                        DIM.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        DIMbool = true
                        istrue()
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        KLSTOV?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                a.put("KLSTOV", KLSTOV?.getSelectedItem().toString())
                dataArray.put(p0, a)
            }

        }

        PRS?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                a.put("PRS", PRS.getText().toString())
                dataArray.put(p0, a)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        POL?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (POL?.getText().toString().toFloatOrNull() == null){
                    POL.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    POLbool = false
                    istrue()
                }
                else {
                    if (POL?.getText().toString().toFloat() < 0) {
                        POL.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        POLbool = false
                        istrue()
                    }
                    else {
                        POL.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        POLbool = true
                        istrue()
                        a.put("POL", POL.getText().toString())
                        dataArray.put(p0, a)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (POL?.getText().toString().toFloatOrNull() == null){
                    POL.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    POLbool = false
                    istrue()
                }
                else {
                    if (POL?.getText().toString().toFloat() < 0) {
                        POL.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        POLbool = false
                        istrue()
                    }
                    else {
                        POL.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        POLbool = true
                        istrue()
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        SPS?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (SPS?.getText().toString().toFloatOrNull() == null){
                    SPS.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    SPSbool = false
                    istrue()
                }
                else {
                    if (SPS?.getText().toString().toFloat() < 0) {
                        SPS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        SPSbool = false
                        istrue()
                    }
                    else {
                        SPS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        SPSbool = true
                        istrue()
                        a.put("SPS", SPS.getText().toString())
                        dataArray.put(p0, a)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (SPS?.getText().toString().toFloatOrNull() == null){
                    SPS.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    SPSbool = false
                    istrue()
                }
                else {
                    if (SPS?.getText().toString().toFloat() < 0) {
                        SPS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        SPSbool = false
                        istrue()
                    }
                    else {
                        SPS.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        SPSbool = true
                        istrue()
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        ZAP?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (ZAP?.getText().toString().toIntOrNull() == null){
                    ZAP.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZAPbool = false
                    istrue()
                }
                else {
                    if (ZAP?.getText().toString().toInt() < 0) {
                        ZAP.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPbool = false
                        istrue()
                    }
                    else {
                        ZAP.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPbool = true
                        istrue()
                        a.put("ZAP", ZAP.getText().toString())
                        dataArray.put(p0, a)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (ZAP?.getText().toString().toIntOrNull() == null){
                    ZAP.getBackground().setColorFilter(context.getResources().getColor(R.color.red),
                        PorterDuff.Mode.SRC_ATOP)
                    ZAPbool = false
                    istrue()
                }
                else {
                    if (ZAP?.getText().toString().toInt() < 0) {
                        ZAP.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.red),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPbool = false
                        istrue()
                    }
                    else {
                        ZAP.getBackground().setColorFilter(
                            context.getResources().getColor(R.color.black),
                            PorterDuff.Mode.SRC_ATOP
                        )
                        ZAPbool = true
                        istrue()
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val YARtext: TextView? = view.findViewById(R.id.tier)
        YARtext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Коды и значения ярусов:\n" +
                    "1 - 1-й ярус древостоя;\n" +
                    "2 - 2-й ярус древостоя;\n" +
                    "3 - 3-й ярус древостоя;\n" +
                    "4 - несомкнувшиеся культуры на не покрытых лесом землях;\n" +
                    "5 - естественное возобновление в лесных культурах;\n" +
                    "6 - несомкнувшиеся культуры под пологом леса;\n" +
                    "7 - несомкнувшиеся культуры, созданные в порядке реконструкции;\n" +
                    "8 - естественные редины;\n" +
                    "9 - единичные деревья;\n" +
                    "10 - сады;\n" +
                    "13 - погибшая часть древостоя.", Toast.LENGTH_LONG)
            toast.show()
        }
        val KOFSOStext: TextView? = view.findViewById(R.id.structureKoef)
        KOFSOStext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Коэффициент для породы, в сумме для яруса <= 1", Toast.LENGTH_LONG)
            toast.show()
        }
        val PORtext: TextView? = view.findViewById(R.id.structureBreed)
        PORtext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Порода кодом", Toast.LENGTH_LONG)
            toast.show()
        }
        val VOZtext: TextView? = view.findViewById(R.id.age)
        VOZtext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Возраст по формуле: а = (гл - гс) + 1, где:\n" +
                    "гл - год проведения полевых работ;\n" +
                    "гс - год производства лесных культур.", Toast.LENGTH_LONG)
            toast.show()
        }
        val VYStext: TextView? = view.findViewById(R.id.height)
        VYStext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Высота в метрах с точностью до 0,1 м", Toast.LENGTH_LONG)
            toast.show()
        }
        val DIMtext: TextView? = view.findViewById(R.id.diameter)
        DIMtext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Средний диаметр на высоте 1,3 м определяют для всех составляющих пород, начиная с высоты 3 м. При его величине до 32 см, указывают с градацией в 2 см, свыше 32 см - с градацией в 4 см.", Toast.LENGTH_LONG)
            toast.show()
        }
        val KLSTOVtext: TextView? = view.findViewById(R.id.productClass)
        KLSTOVtext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Класс товарности (от 0 до 3)", Toast.LENGTH_LONG)
            toast.show()
        }
        val PRStext: TextView? = view.findViewById(R.id.origin)
        PRStext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Кодовое обозначение показателя происхождение", Toast.LENGTH_LONG)
            toast.show()
        }
        val POLtext: TextView? = view.findViewById(R.id.completeness)
        POLtext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Относительная полнота отдельно для каждого яруса насаждения, дробное число с запятой", Toast.LENGTH_LONG)
            toast.show()
        }
        val SPStext: TextView? = view.findViewById(R.id.e)
        SPStext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Сумма площади сечения", Toast.LENGTH_LONG)
            toast.show()
        }
        val ZAPtext: TextView? = view.findViewById(R.id.silos)
        ZAPtext?.setOnClickListener { View ->
            val toast = Toast.makeText(context, "Запас на 1 га - для ярусов, за исключением несомкнувшихся лесных культур", Toast.LENGTH_LONG)
            toast.show()
        }

            return view
        }


}
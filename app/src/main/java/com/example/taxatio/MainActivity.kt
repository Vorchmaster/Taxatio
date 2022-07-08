package com.example.taxatio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest


class MainActivity : AppCompatActivity() {

    lateinit var date: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val savedState = getSharedPreferences(
            "savedState", Context.MODE_PRIVATE
        )
        val editor = savedState.edit()

        if(savedState.getBoolean("Started", false)){
            val cardIntent = Intent(this, taxatioCardActivity::class.java)
            startActivity(cardIntent)
        }

        val startButton = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.startButton)
        val login = findViewById<EditText>(R.id.login)
        if (savedState.contains("Login"))
            login.setText(savedState.getString("Login", ""))

        val password = findViewById<EditText>(R.id.password)
        if (savedState.contains("Password"))
            password.setText(savedState.getString("Password", ""))

        var string: String

        startButton.setOnClickListener { view ->
            val requestQueue = Volley.newRequestQueue(this)
                val auth_url = "http://192.168.1.66/json_d/json.php" //1.66 43.114
            val stringRequest: StringRequest = object : StringRequest(
                Method.POST, auth_url,
                Response.Listener { response -> //let's parse json data
                    Log.d("response", response.toString())
                    if (!(response.toString().equals("FAILURE", true))) {
                        string = response.toString()
                        if(string.contains(",]"))
                            string = string.replace(",]","]")
                        editor.putString("Login",  login.text.toString())
                        editor.putString("Password",  password.text.toString())
                        editor.apply()
                        val vydSelectIntent = Intent(this, VydSelectActivity::class.java)
                        vydSelectIntent.putExtra("list", string)
                        startActivity(vydSelectIntent)
                    }
                    else{
                        val toast = Toast.makeText(this, "Неверные электронная почта или пароль", Toast.LENGTH_LONG)
                        toast.show()
                    }
                },
                Response.ErrorListener { error -> Log.d("response", error.toString())
                    error.printStackTrace()
                    val toast = Toast.makeText(this, error.toString(), Toast.LENGTH_LONG)
                    toast.show() }) {
                override fun getParams(): Map<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["email"] = login.text.toString()
                    params["password"] = md5(password.text.toString())
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
        }

    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}
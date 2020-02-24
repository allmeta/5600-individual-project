package com.example.individualproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    val url="http://192.168.1.129:8080"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun getMethodTesting(view: View){
        val stringReq=StringRequest(
            Request.Method.GET, "$url/getMethodTesting",
            Response.Listener<String> { res->
                Toast.makeText(applicationContext,"Get button clicked: $res",Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener {err->
                Toast.makeText(applicationContext,"That didn't work! $err",Toast.LENGTH_SHORT).show()
            }
            )
        val queue= Volley.newRequestQueue(this)
        stringReq.retryPolicy =
            DefaultRetryPolicy(20000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        queue.add(stringReq)
    }
    fun postMethodTesting(view: View){
        val stringReq=StringRequest(
            Request.Method.POST, "$url/postMethodTesting",
            Response.Listener<String> { res->
                Toast.makeText(applicationContext,"Post button clicked: $res",Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener {err->
                Toast.makeText(applicationContext,"That didn't work! $err",Toast.LENGTH_SHORT).show()
            }
        )
        stringReq.retryPolicy =
        DefaultRetryPolicy(20000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        val queue= Volley.newRequestQueue(this)
        queue.add(stringReq)
    }
}

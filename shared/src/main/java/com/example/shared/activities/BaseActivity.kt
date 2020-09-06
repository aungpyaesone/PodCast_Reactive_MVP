package com.example.shared.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    protected fun showSnackbar(message:String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_SHORT).show();
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
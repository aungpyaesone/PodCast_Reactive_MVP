package com.example.postcast_reactive_mvp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postcast_reactive_mvp.R
import com.example.shared.activities.BaseActivity

class PodCastDetailActivity : BaseActivity() {

    companion object{
        fun newIntent(context:Context): Intent {
            return Intent(context,PodCastDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)
    }
}
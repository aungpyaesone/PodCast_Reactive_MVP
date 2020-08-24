package com.example.postcast_reactive_mvp.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.fragments.DownloadFragment
import com.example.postcast_reactive_mvp.fragments.HomeFragment
import com.example.postcast_reactive_mvp.fragments.ProfileFragment
import com.example.postcast_reactive_mvp.fragments.SearchFragment
import com.example.shared.activities.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callFragment(HomeFragment.newInstance("",""))
        setUpBottomNav();
    }

    private fun setUpBottomNav(){
        bottomNav.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.home -> {
                        callFragment(HomeFragment.newInstance("a","b"))
                        return true
                    }
                    R.id.search -> {
                        callFragment(SearchFragment.newInstance("b","d"))
                        return true
                    }
                    R.id.download -> {
                        callFragment(DownloadFragment.newInstance("e","f"))
                        return true
                    }
                    R.id.profile ->{
                        callFragment(ProfileFragment.newInstance("g","h"))
                        return true
                    }
                }
                return false
            }
        })

    }

  fun callFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
}
}

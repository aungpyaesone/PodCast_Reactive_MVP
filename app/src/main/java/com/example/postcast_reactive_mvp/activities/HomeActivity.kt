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

    private val homeFragment = HomeFragment.newInstance("","")
    private val searchFragment = SearchFragment.newInstance("","")
    private val downloadFragment = DownloadFragment.newInstance("","")
    private val profileFragment = ProfileFragment.newInstance("","")
    private val fragmentManager = supportFragmentManager
    private var activeFragment: Fragment = HomeFragment.newInstance("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // callFragment(HomeFragment.newInstance("",""))
        setupFragmentManager()
        callFragment(homeFragment)
        setUpBottomNav()

    }

    private fun setupFragmentManager() {
        fragmentManager.beginTransaction().apply {
            add(R.id.container,homeFragment,getString(R.string.home_fragment)).hide(homeFragment)
            add(R.id.container,searchFragment,getString(R.string.search_fragment)).hide(searchFragment)
            add(R.id.container,downloadFragment,getString(R.string.download_fragment)).hide(downloadFragment)
            add(R.id.container,profileFragment,getString(R.string.profile_fragment)).hide(profileFragment)
        }.commit()
    }


    private fun setUpBottomNav(){
        bottomNav.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.home -> {
                        callFragment(homeFragment)
                        return true
                    }
                    R.id.search -> {
                        callFragment(searchFragment)
                        return true
                    }
                    R.id.download -> {
                        callFragment(downloadFragment)
                        return true
                    }
                    R.id.profile ->{
                        callFragment(profileFragment)
                        return true
                    }
                }
                return false
            }
        })

    }

  fun callFragment(fragment: Fragment){
      fragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
      activeFragment = fragment
    //supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
}
}

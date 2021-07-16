package com.example.cleanarchitecture

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.cleanarchitecture.base.BaseActivity
import com.example.cleanarchitecture.data.model.NewFeedEntity
import com.example.cleanarchitecture.databinding.MainActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.realm.Realm

class MainActivity : BaseActivity() {

    private lateinit var dataBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_container
        ) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setupWithNavController(navController)
    }

}

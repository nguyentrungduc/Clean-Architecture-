package com.example.cleanarchitecture

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cleanarchitecture.base.BaseActivity
import com.example.cleanarchitecture.databinding.MainActivityBinding

class MainActivity : BaseActivity() {

    private lateinit var dataBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        val navController = navHostFragment.findNavController()
        dataBinding.bottomNav.setupWithNavController(navController)
    }

}

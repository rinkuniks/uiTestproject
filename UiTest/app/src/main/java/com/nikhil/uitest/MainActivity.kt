package com.nikhil.uitest

import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.nikhil.uitest.databinding.ActivityMainBinding
import com.nikhil.uitest.utils.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var navController: NavController
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onResume() {
        super.onResume()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment_container) as NavHostFragment

        navController = navHostFragment.navController

        //bottomNavigation with Navigation Component
        setUpBottomNavigationBar(navController)

        binding.bottomNavView.setOnNavigationItemSelectedListener {
            lifecycleScope.launchWhenStarted {
                when(it.itemId){
                    R.id.home_tab ->{
                        navController.navigate(R.id.dashboardFragment)
                    }
                    R.id.insight_tab ->{
                        Toast.makeText(this@MainActivity, "Coming Soon...", Toast.LENGTH_SHORT).show()
                    }
                    R.id.portfolio_tab ->{
                        Toast.makeText(this@MainActivity, "Coming Soon...", Toast.LENGTH_SHORT).show()
                    }
                    R.id.account_tab ->{
                        Toast.makeText(this@MainActivity, "Coming Soon...", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            true
        }
    }

    private fun setUpBottomNavigationBar(
        navController: NavController
    ) {
        binding.bottomNavView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment ||
                destination.id == R.id.forgotPasswordFragment ||
                destination.id == R.id.newPasswordFragment ||
                destination.id == R.id.verifyEmailFragment
            ){
               binding.bottomNavView.visibility = View.GONE
            }else{
                binding.bottomNavView.visibility = View.VISIBLE
            }
        }
    }
}

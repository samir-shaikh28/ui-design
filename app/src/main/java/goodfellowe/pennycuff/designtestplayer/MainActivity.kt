package goodfellowe.pennycuff.designtestplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import goodfellowe.pennycuff.designtestplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(mBinding.bottomNavView, navHostFragment.navController)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
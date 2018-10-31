package enciyo.animeapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        NavigationUI.setupActionBarWithNavController(this@MainActivity,NavHostFragment.findNavController(myHostFragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.myHostFragment).navigateUp()
    }

}

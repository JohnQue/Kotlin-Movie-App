package com.example.themovieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.themovieapp.ui.MovieFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if(savedInstanceState == null){
            changeFragment(MovieFragment())
        }
    }
    fun changeFragment(f: Fragment, cleanStack: Boolean = true){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.base_content, f)
        ft.addToBackStack(null)
        ft.commit()
    }
}

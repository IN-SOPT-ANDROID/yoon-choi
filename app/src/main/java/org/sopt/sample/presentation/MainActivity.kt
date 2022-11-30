package org.sopt.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivityMainBinding
import org.sopt.sample.presentation.main.gallery.GalleryFragment
import org.sopt.sample.presentation.main.home.HomeFragment
import org.sopt.sample.presentation.main.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransaction()
    }

    private fun initTransaction() {
        binding.homeMenu.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.menu_search -> SearchFragment()
                    R.id.home_menu -> HomeFragment()
                    R.id.menu_setting -> GalleryFragment()
                    else -> HomeFragment()
                }
            )
            true    //바텀 클릭시 색 변환
        }
        binding.homeMenu.selectedItemId = R.id.menu_home
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_container, fragment)
            .commit()
    }
}

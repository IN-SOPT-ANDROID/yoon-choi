package org.sopt.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivityMainBinding
import org.sopt.sample.presentation.main.home.HomeFragment
import org.sopt.sample.presentation.main.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var position = FIRST_FRAMGENT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initNavigationBar()
        initTransaction()
    }

    private fun initTransaction() {
        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()

        supportFragmentManager.beginTransaction().add(R.id.home_container, homeFragment).commit()

        binding.homeBtn.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                FIRST_FRAMGENT -> {
                    transaction.replace(R.id.home_container, homeFragment)
                    position = SECOND_FRAGMENT
                }
                SECOND_FRAGMENT -> {
                    transaction.replace(R.id.home_container, searchFragment)
                    position = FIRST_FRAMGENT
                }
            }
            transaction.commit()
        }
    }

    companion object {
        const val FIRST_FRAMGENT = 1
        const val SECOND_FRAGMENT = 2
    }
}
//    private fun initNavigationBar() {
//        binding.bottomNavi.setOnItemSelectedListener { itemId ->
//            when (itemId.itemId) {
//                R.id.menu_search -> {
//                    changeFragment(SearchFragment())
//                    return@setOnItemSelectedListener true
//                }
//                R.id.menu_home -> {
//                    changeFragment(HomeFragment())
//                    return@setOnItemSelectedListener true
//                }
//                R.id.menu_setting -> {
//                    changeFragment(GalleryFragment())
//                    return@setOnItemSelectedListener true
//                }
//                else -> false
//            }
//
//        }
//    }
//
//
//    private fun changeFragment(fragment: Fragment) {
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.bottom_navi, fragment)
//            .commit()
//    }
//}

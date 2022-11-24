package com.sopt.soptmon.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sopt.soptmon.R
import com.sopt.soptmon.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val bottomNavigationView: BottomNavigationView by lazy { // 하단 네비게이션 바
        findViewById(R.id.main_bvn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, HomeFragment())
            .commit()

        bottomNavigationView.setOnItemSelectedListener {
            BottomMenu.from(it.itemId).changeFragment(supportFragmentManager)

            true
        }
    }

    enum class BottomMenu() {
        HOME {
            override fun changeFragment(supportFragmentManager: FragmentManager) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_home, HomeFragment())
                    .commit()
            }
        },
        CATEGORY {
            override fun changeFragment(supportFragmentManager: FragmentManager) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_home, CategoryFragment())
                    .commit()
            }
        },
        NOTHING {
            override fun changeFragment(supportFragmentManager: FragmentManager) {
                // do nothing
            }
        }
        ;

        abstract fun changeFragment(supportFragmentManager: FragmentManager)

        companion object {
            fun from(id: Int): BottomMenu {
                return when (id) {
                    R.id.nav_home -> HOME
                    R.id.nav_category -> CATEGORY
                    R.id.nav_favorite -> NOTHING
                    R.id.nav_my -> NOTHING
                    else -> {
                        throw IllegalArgumentException("invalid home fragment name")
                    }
                }
            }
        }
    }
}
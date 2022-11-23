package com.sopt.soptmon.daehwan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.sopt.soptmon.R
import com.sopt.soptmon.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, HomeFragment())
            .commit()

        binding.btNavBar.setOnItemSelectedListener {
            BottomMenu.from("HOME").changeFragment(supportFragmentManager)

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
                // TODO : to Category fragment
            }
        }
        ;

        abstract fun changeFragment(supportFragmentManager: FragmentManager)

        companion object {
            fun from(title: String): BottomMenu {
                return when (title) {
                    "HOME" -> HOME
                    else -> {
                        throw IllegalArgumentException("invalid home fragment name")
                    }
                }
            }
        }
    }
}
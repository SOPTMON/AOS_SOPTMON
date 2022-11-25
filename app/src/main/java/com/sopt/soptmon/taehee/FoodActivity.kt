package com.sopt.soptmon.taehee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dabo.soptmon_prototype.FoodFragment
import com.dabo.soptmon_prototype.R
import com.dabo.soptmon_prototype.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.home_container)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.home_container, FoodFragment())
                .commit()

        }
    }
}
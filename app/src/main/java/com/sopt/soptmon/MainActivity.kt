package com.sopt.soptmon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sopt.soptmon.daeun.CategoryFragment

class MainActivity : AppCompatActivity() {
    private val frame: FragmentContainerView by lazy { // activity_main의 화면 부분
        findViewById(R.id.main_container)
    }

    private val bottomNagivationView: BottomNavigationView by lazy { // 하단 네비게이션 바
        findViewById(R.id.main_bvn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (frame == null) {
            supportFragmentManager.beginTransaction()
                .add(frame.id, (CategoryFragment()))
                .commit()
        }

        bottomNagivationView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                //홈 fragment
                //R.id.nav_home -> {
                  //  replaceFragment(HomeFragment())
                    //true
                //}
                R.id.nav_category -> {
                    replaceFragment(CategoryFragment())
                    true
                }
                //찜하기 fragment
                //R.id.nav_favorite -> {
                  //  replaceFragment(SearchFragment())
                    //true
               // }
                //마이티콘 fragment
                //R.id.nav_my -> {
                //  replaceFragment(SearchFragment())
                //true
                // }
                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(frame.id, fragment).commit()
    }
}
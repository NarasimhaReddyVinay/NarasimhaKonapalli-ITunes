package com.example.narasimhakonapalli_itunes


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var viewPager2: ViewPager2? = null
    var tabLayout: TabLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2 = findViewById<View>(R.id.viewpager) as ViewPager2
        tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        viewPager2!!.adapter = fragmentsAdapter(this)
        val tabLayoutMediator = TabLayoutMediator(
            tabLayout!!, viewPager2!!
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Rock"
                    tab.setIcon(R.drawable.ic_baseline_home_24)
                }
                1 -> {
                    tab.text = "Classic"
                    tab.setIcon(R.drawable.ic_baseline_dashboard_24)
                }
                2 -> {
                    tab.text = "Pop"
                    tab.setIcon(R.drawable.ic_baseline_notifications_24)
                }
            }
        }
        tabLayoutMediator.attach()
    }
}
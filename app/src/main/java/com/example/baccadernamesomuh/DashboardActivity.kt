package com.example.baccadernamesomuh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.ads.*
import com.google.android.material.navigation.NavigationView

class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var toolbar: Toolbar
    private lateinit var nameLayout: LinearLayout
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle
    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        init()

        onClick()

        loadBannerAdd()

        setDrawer()
    }

    @SuppressLint("MissingPermission")
    private fun loadBannerAdd() {
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object : AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Toast.makeText(this@DashboardActivity, "add close", Toast.LENGTH_LONG).show()

            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Toast.makeText(this@DashboardActivity, "add Load", Toast.LENGTH_LONG).show()
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }
    }

    private fun setDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // Drawer is open
            drawerLayout.openDrawer(GravityCompat.START)
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        drawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, 0, 0
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

    }

    private fun onClick() {
        nameLayout.setOnClickListener {
            startActivity(
                Intent(this, NameActivity::class.java)
            )
        }
    }

    @SuppressLint("CutPasteId")
    private fun init() {
        toolbar = findViewById(R.id.dashboardToolbar)
        nameLayout = findViewById(R.id.nameLayoutId)
        drawerLayout = findViewById(R.id.drawerLayoutId)
        navigationView = findViewById(R.id.navigation_view)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareId -> {
                startActivity(Intent(this, NameActivity::class.java))
            }
        }
        return true
    }

}


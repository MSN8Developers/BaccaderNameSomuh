package com.example.baccadernamesomuh

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var nameLayout: LinearLayout
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var mDrawerToggle: ActionBarDrawerToggle
    private lateinit var mActionBar: ActionBar
    private var mToolBarNavigationListenerIsRegistered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        init()

        onClick()

        setDrawer()
    }
    private fun setDrawer(){
    /*    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // Drawer is open

            drawerLayout.openDrawer(GravityCompat.START)

            drawerLayout.closeDrawer(GravityCompat.START)
        }*/

        mDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout,0, 0
        )
        drawerLayout.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

    }


    private fun onClick(){
        nameLayout.setOnClickListener {
            startActivity(
                Intent(this, NameActivity::class.java)
            )
        }
    }

    @SuppressLint("CutPasteId")
    private fun init(){
    nameLayout = findViewById(R.id.nameLayoutId)
   drawerLayout = findViewById(R.id.drawerLayoutId)
  navigationView = findViewById(R.id.navigation_view)
}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareId -> {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, NameActivity::class.java))
            }
            R.id.ratingIa -> {
                Toast.makeText(this, "Messages clicked", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, NameActivity::class.java))
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}

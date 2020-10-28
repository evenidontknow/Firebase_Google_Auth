package com.example.firebasegoogleauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        val currentUser =  mAuth.currentUser


        name_txt.text = currentUser?.displayName
        email_txt.text = currentUser?.email
        uid_txt.text = currentUser?.uid

        Glide.with(this).load(currentUser?.photoUrl).into(profile_image)

        button_sing_out.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
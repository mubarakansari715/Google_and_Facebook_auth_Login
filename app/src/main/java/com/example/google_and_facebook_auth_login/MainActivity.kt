package com.example.google_and_facebook_auth_login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.google_and_facebook_auth_login.databinding.ActivityMainBinding
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var gso: GoogleSignInOptions
    lateinit var gsc: GoogleSignInClient
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        gsc = GoogleSignIn.getClient(this, gso)
        callbackManager = CallbackManager.Factory.create()

        facebookInit()

        binding.apply {
            btnGoogle.setOnClickListener {
                binding.btnGoogle.setOnClickListener {
                    val signInIntent = gsc.signInIntent
                    startActivityForResult(signInIntent, 1000)
                }

                //throw RuntimeException("Test Crash") // Force a crash
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        callbackManager.onActivityResult(requestCode, resultCode, data)

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                task.getResult(ApiException::class.java)
                Toast.makeText(
                    this,
                    "SignIn with Google Successfully",
                    Toast.LENGTH_SHORT
                ).show()

            } catch (e: ApiException) {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun facebookInit() {

        binding.btnFacebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(
                this@MainActivity,
                callbackManager,
                arrayListOf("email")
            )
        }

        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onCancel() {
                    //TODO("Not yet implemented")
                    Log.e("TAG", "onCancel: ")
                }

                override fun onError(error: FacebookException) {
                    //TODO("Not yet implemented")
                    /*Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_LONG)
                        .show()*/
                    Log.e("TAG", "onError: $error", )

                }

                override fun onSuccess(result: LoginResult) {
                    //TODO("Not yet implemented")
                    Log.e("TAG", "onSuccess: $result", )
                   /* Toast.makeText(
                        applicationContext,
                        "SignIn with Facebook Successfully",
                        Toast.LENGTH_SHORT
                    ).show()*/
                }

            })
    }

}
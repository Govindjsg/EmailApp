package com.govind05041994.emailapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var emailEditText: EditText
    lateinit var emailEditSubject: EditText
    lateinit var emailEditMessage: EditText
    lateinit var recipientMail: String
    lateinit var emailSubject: String
    lateinit var emailMessage: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Binding variables with UI elements
        emailEditText = findViewById(R.id.edit_mail_address)
        emailEditSubject = findViewById(R.id.edit_mail_subject)
        emailEditMessage = findViewById(R.id.edit_mail_message)
    }
    fun sendEmail(view: View)
    {
        //first access data from the edit text fields
        recipientMail = emailEditText.text.toString()
        emailSubject = emailEditSubject.text.toString()
        emailMessage = emailEditMessage.text.toString()

        //now create an intent object
        val intent = Intent(Intent.ACTION_SEND)

        //provide email address of the recipient as data
        intent.data = Uri.parse("mailto:$recipientMail")

        //now we will add extras with the mail
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
        intent.putExtra(Intent.EXTRA_TEXT, emailMessage)

        //set the type of mail
        intent.type = "text/plain"

        //start your intent
        startActivity(Intent.createChooser(intent, "Select your Email app"))
    }
}
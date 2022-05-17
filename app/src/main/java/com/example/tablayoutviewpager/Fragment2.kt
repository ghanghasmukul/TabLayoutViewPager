package com.example.tablayoutviewpager

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment2 : Fragment() {
    private lateinit var emailAddress: TextView
    private lateinit var password: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        emailAddress = view.findViewById(R.id.emailAddressTV)
        password = view.findViewById(R.id.passwordTV)
        sharedPreferences = requireContext().getSharedPreferences(
            "sharedFile", Context.MODE_PRIVATE
        )

        updateData()
        return view
    }

    private fun updateData() {
        val sharedPassword = sharedPreferences.getString("password", "not Given")
        val sharedEmailAddress = sharedPreferences.getString("emailAddress", "abc@gmail.com")
        emailAddress.text = sharedEmailAddress.toString()
        password.text = sharedPassword.toString()
    }


}
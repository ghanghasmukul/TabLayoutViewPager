package com.example.tablayoutviewpager

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Fragment1 : Fragment() {
    private lateinit var emailAddress: EditText
    private lateinit var password: EditText
    private lateinit var submitBtn: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_1, container, false)
        emailAddress = root.findViewById(R.id.emailAddressET)
        password = root.findViewById(R.id.passwordET)
        submitBtn = root.findViewById(R.id.submitBtn)

        sharedPreferences = requireContext().getSharedPreferences(
            "sharedFile", Context.MODE_PRIVATE
        )

        submitBtn.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            if (emailAddress.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(requireContext(), "null value", Toast.LENGTH_LONG).show()
            } else {
                editor.putString("emailAddress", emailAddress.text.toString())
                editor.putString("password", password.text.toString())
            }
            editor.apply()
        }
        return root
    }
}
package com.nikhil.uitest.ui

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nikhil.uitest.databinding.NewPasswordFragmentBinding
import com.nikhil.uitest.utils.BaseFragment

class NewPasswordFragment: BaseFragment<NewPasswordFragmentBinding>() {
    override fun getViewBinding(): NewPasswordFragmentBinding = NewPasswordFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Gradient Color for Logo
        val textView = binding.tvLogo
        val shader = LinearGradient(
            0f,
            0f,
            0f,
            textView.textSize,
            Color.GREEN,
            Color.BLUE,
            Shader.TileMode.CLAMP
        )
        textView.paint.shader = shader

        //btn click
        binding.btnSetNewPassword.setOnClickListener {
            validateNewPassword(binding.editTextNewPassword.text.toString())
        }
    }

    private fun validateNewPassword(password: String) {
        if (password.isEmpty()){
            Toast.makeText(context, "Enter New Password", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Password Updated Successfully...", Toast.LENGTH_SHORT).show()
            findNavController().navigate(NewPasswordFragmentDirections.actionNewPasswordFragmentToLoginFragment())
        }
    }
}

package com.nikhil.uitest.ui

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nikhil.uitest.databinding.VerifyEmailFragmentBinding
import com.nikhil.uitest.utils.BaseFragment

class VerifyEmailFragment: BaseFragment<VerifyEmailFragmentBinding>() {
    override fun getViewBinding(): VerifyEmailFragmentBinding = VerifyEmailFragmentBinding.inflate(layoutInflater)

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

        //Getting Arguments From last Fragment
        val email = arguments?.getString("email")
        binding.tvEmail.text = email

        //resend code
        binding.resendCode.setOnClickListener {
            Toast.makeText(context, "Code Sent to your email", Toast.LENGTH_SHORT).show()
        }

        //btn click
        binding.btnVerify.setOnClickListener {
            findNavController().navigate(VerifyEmailFragmentDirections.actionVerifyEmailFragmentToNewPasswordFragment())
        }
    }
}
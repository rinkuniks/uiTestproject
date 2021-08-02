package com.nikhil.uitest.ui

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nikhil.uitest.R
import com.nikhil.uitest.databinding.ForgotPasswordFragmentBinding
import com.nikhil.uitest.utils.BaseFragment
import com.nikhil.uitest.utils.Constants

class ForgotPasswordFragment: BaseFragment<ForgotPasswordFragmentBinding>() {
    override fun getViewBinding(): ForgotPasswordFragmentBinding = ForgotPasswordFragmentBinding.inflate(layoutInflater)

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

        //on Submit Email
        binding.btnSubmitEmail.setOnClickListener {
            validateEmail(binding.editTextEmail.text.toString())
        }
    }

    private fun validateEmail(email: String) {
        when {
            email.isEmpty() -> {
                Toast.makeText(context, "Enter email",Toast.LENGTH_SHORT).show()
            }
            !email.matches(Constants.emailPattern.toRegex()) -> {
                Toast.makeText(context, "Enter valid email",Toast.LENGTH_SHORT).show()
            }
            else -> {
                val bundle = Bundle()
                bundle.putString("email", email)
                findNavController().navigate(
                    R.id.action_forgotPasswordFragment_to_verifyEmailFragment,
                    bundle
                )
            }
        }
    }
}
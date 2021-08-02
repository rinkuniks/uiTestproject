package com.nikhil.uitest.ui

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nikhil.uitest.databinding.LoginFragmentBinding
import com.nikhil.uitest.utils.BaseFragment
import com.nikhil.uitest.utils.Constants

class LoginFragment : BaseFragment<LoginFragmentBinding>() {
    override fun getViewBinding(): LoginFragmentBinding =
        LoginFragmentBinding.inflate(layoutInflater)

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

        //Login Button
        binding.btnLogin.setOnClickListener {
            validateCredentials(
                binding.editTextUsername.text.toString(),
                binding.editTextPassword.text.toString()
            )
        }

        //forgot password
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment())
        }
    }

    private fun validateCredentials(username: String, password: String) {
        when {
            username.isEmpty() -> {
                Toast.makeText(context, "Please Enter username", Toast.LENGTH_SHORT).show()
            }
            !username.matches(Constants.email.toRegex()) -> {
                Toast.makeText(context, "Please Enter valid email", Toast.LENGTH_SHORT).show()
            }
            password.isEmpty() -> {
                Toast.makeText(context, "Please Enter Password", Toast.LENGTH_SHORT).show()
            }
            !password.matches(Constants.password.toRegex()) -> {
                Toast.makeText(context, "Please Enter valid password", Toast.LENGTH_SHORT).show()
            }
            else -> {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToDashboardFragment())
            }
        }
    }
}
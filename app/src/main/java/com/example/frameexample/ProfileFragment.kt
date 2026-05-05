package com.example.frameexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.frameexample.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProfileBinding.bind(view)

        val prefs = requireActivity().getSharedPreferences("user_prefs", AppCompatActivity.MODE_PRIVATE)
        val username = prefs.getString("username", "")

        binding.tvUsername.text = "Hello, $username"

        binding.btnLogout.setOnClickListener {
            prefs.edit().putBoolean("isLoggedIn", false).apply()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.graduationproject.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentSignInBinding
import com.example.graduationproject.notification.MyNotificationWorker
import com.example.graduationproject.ui.activities.MainActivity
import java.util.concurrent.TimeUnit

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            //
            val request = PeriodicWorkRequestBuilder<MyNotificationWorker>(15,TimeUnit.MINUTES)
                .setInitialDelay(10,TimeUnit.SECONDS)
                .build()

            activity?.let { it1 -> WorkManager.getInstance(it1).enqueue(request) }

            }
        binding.textViewLogin5.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toSignUp)

        }
    }
}
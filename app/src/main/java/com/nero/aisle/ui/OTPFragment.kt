package com.nero.aisle.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.nero.aisle.R
import com.nero.aisle.data.model.Token
import com.nero.aisle.viewModel.AisleViewModel
import com.nero.util.Token.Companion.token
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_o_t_p.*
import kotlinx.android.synthetic.main.fragment_o_t_p.view.*
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class OTPFragment : Fragment(R.layout.fragment_o_t_p) {


    private var bottomNavigationViewVisibility = View.VISIBLE
    private val args: OTPFragmentArgs by navArgs()

    private val viewModel: AisleViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val number = args.number
        view.tvMobileObserve.text = number.toString()
        Log.d("TAG", number)
        otp()

        val token = viewModel.tokenLiveData.value

        btnOtpContinue.setOnClickListener {
            viewModel.otpToken(Token("+91$number", otp_view.text.toString()))
        }

        otpCountdown()
    }

    private fun otpCountdown() {
        val countDownTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(p0: Long) {
                val millis: Long = p0
                val hms = String.format(
                    "%02d:%02d",
                    (TimeUnit.MILLISECONDS.toMinutes(millis) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))),
                    (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millis)
                    ))
                )
                textView?.text = hms;
            }

            override fun onFinish() {
                textView?.text = "Resend";
            }
        }
        countDownTimer.start()

    }

    private fun otp() {
        viewModel.isValid.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                if (it == true) {
                    token = viewModel.tokenLiveData.value!!
                    val action =
                        OTPFragmentDirections.actionOTPFragmentToNavigationDiscover(
                            viewModel.tokenLiveData.value!!

                        )
                    view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }


                } else {
                    Toast.makeText(
                        requireContext(),
                        "OTP is wrong",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            }

        }

        )
    }

    override fun onStop() {
        super.onStop()
        if (activity is MainActivity) {
            (activity as MainActivity).setBottomNavigationVisibility(
                bottomNavigationViewVisibility
            )
        }

    }


}
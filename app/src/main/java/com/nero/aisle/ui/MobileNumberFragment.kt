package com.nero.aisle.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nero.aisle.R
import com.nero.aisle.data.model.PhoneNumber
import com.nero.aisle.viewModel.AisleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_mobile_number.*


@AndroidEntryPoint
class MobileNumberFragment : Fragment(R.layout.fragment_mobile_number) {

    private var bottomNavigationViewVisibility = View.GONE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        if (activity is MainActivity) {
            var mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(bottomNavigationViewVisibility)
        }
    }

    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            (activity as MainActivity).setBottomNavigationVisibility(bottomNavigationViewVisibility)
        }
    }


    private val viewModel: AisleViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phoneNumber()
        btnMobileContinue.setOnClickListener {

            var number = etMobileNumber.text.toString()
            viewModel.phoneNumber(PhoneNumber("+91$number"))

        }

    }

    private fun phoneNumber() {
        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                if (it == true) {
                    val action =
                        MobileNumberFragmentDirections.actionMobileNumberFragmentToOTPFragment(
                            etMobileNumber.text.toString()

                        )

                    view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }


                } else {
                    Toast.makeText(
                        requireContext(),
                        "Check number you have enter",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                pbProgress.visibility = View.VISIBLE
            } else {
                pbProgress.visibility = View.GONE
            }
        })
    }

    override fun onStop() {
        super.onStop()
        viewModel.status.value = null

    }

}
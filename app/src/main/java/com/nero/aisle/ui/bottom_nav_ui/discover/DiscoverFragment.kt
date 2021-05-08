package com.nero.aisle.ui.bottom_nav_ui.discover

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nero.aisle.R
import com.nero.aisle.viewModel.AisleViewModel
import com.nero.util.Token
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.fragment_discover.ivPhoto
import kotlinx.android.synthetic.main.fragment_discover.ivProfile1
import kotlinx.android.synthetic.main.fragment_discover.ivProfile2
import kotlinx.android.synthetic.main.fragment_discover.tvName


@AndroidEntryPoint
class DiscoverFragment : Fragment(R.layout.fragment_discover) {

    private val args: DiscoverFragment by navArgs()
    private val viewModel: AisleViewModel by viewModels()
    lateinit var token: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        token = Token.token
        profile()
    }


    @SuppressLint("SetTextI18n")
    private fun profile() {
        viewModel.profile(token).observe(viewLifecycleOwner, Observer {

            val photo = it.data?.invites?.profiles?.get(0)?.photos?.get(0)?.photo
            val blurPhoto = it.data?.likes?.profiles?.get(0)?.avatar
            val blurphoto2 = it.data?.likes?.profiles?.get(1)?.avatar
            val photo_name = it.data?.invites?.profiles?.get(0)?.generalInformation?.firstName
            val age = it.data?.invites?.profiles?.get(0)?.generalInformation?.age
            val nameBlur = it.data?.likes?.profiles?.get(0)?.firstName
            val nameBlur2 = it.data?.likes?.profiles?.get(1)?.firstName
            Glide.with(ivPhoto).load(photo).into(ivPhoto)


            Glide.with(ivProfile1).load(blurPhoto)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3))).into(ivProfile1)
            Glide.with(ivProfile2).load(blurphoto2)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3))).into(ivProfile2)
            tvName.text = "$photo_name, $age"
            tvNameblur1.text = nameBlur
            tvNameblur2.text = nameBlur2

        })
    }

}
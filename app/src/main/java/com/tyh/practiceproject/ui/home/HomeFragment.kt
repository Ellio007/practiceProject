package com.tyh.practiceproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tyh.practiceproject.R
import com.tyh.practiceproject.databinding.FragmentHomeBinding
import com.tyh.practiceproject.ui.AnimationUtils
import com.tyh.practiceproject.utils.ClickUtil

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var play = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.ivHome.setOnClickListener {
            if (ClickUtil.isFastClick(500)) return@setOnClickListener
            Log.d("HomeFragment", "点击一次按钮")
            if (play) {
                AnimationUtils.startAnim(binding.ivHome)
                it.postDelayed({
                    binding.ivHome.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.animated_pause_play,
                            null
                        )
                    )
                    play = false
                }, 500)
            } else {
                AnimationUtils.startAnim(binding.ivHome)
                it.postDelayed({
                    binding.ivHome.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.animated_play_pause,
                            null
                        )
                    )
                    play = true
                }, 500)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
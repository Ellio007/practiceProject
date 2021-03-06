package com.tyh.practiceproject.ui.dashboard

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tyh.practiceproject.R
import com.tyh.practiceproject.databinding.FragmentDashboardBinding
import com.tyh.practiceproject.ui.AnimationUtils

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        binding.iv.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.flower_anim,null))
        binding.iv.setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.electric_vehicle_anim,
                null
            )
        )
        binding.iv.setOnClickListener {
            AnimationUtils.startAnim(binding.iv)
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
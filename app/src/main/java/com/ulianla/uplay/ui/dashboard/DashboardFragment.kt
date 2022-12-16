package com.ulianla.uplay.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.ulianla.uplay.R
import com.ulianla.uplay.databinding.FragmentDashboardBinding
import com.ulianla.uplay.utils.NightModeUtils

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.DashboardTopAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.ThemeModeSwitch -> {
                    //获取主题模式
                    //切换主题模式 日间 夜间 跟随系统 跟随系统到日间
                    when (NightModeUtils().getNightModel(requireContext())) {
                        AppCompatDelegate.MODE_NIGHT_NO -> {
                            NightModeUtils().applyNightModel(requireContext())
                            Toast.makeText(requireContext(), "夜间模式", Toast.LENGTH_SHORT).show()
//                            menuItem.setIcon(R.drawable.ic_night_mode_24dp)
                        }
                        AppCompatDelegate.MODE_NIGHT_YES -> {
                            NightModeUtils().applyFollowSystemModel(requireContext())
                            Toast.makeText(requireContext(), "跟随系统", Toast.LENGTH_SHORT).show()
//                            menuItem.setIcon(R.drawable.ic_auto_mode_24dp)
                        }
                        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> {
                            NightModeUtils().applyDayModel(requireContext())
                            Toast.makeText(requireContext(), "日间模式", Toast.LENGTH_SHORT).show()
//                            menuItem.setIcon(R.drawable.ic_light_mode_24dp)
                        }
                    }
                    true
                }
                else -> false
            }
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
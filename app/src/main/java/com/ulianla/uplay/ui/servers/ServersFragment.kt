package com.ulianla.uplay.ui.servers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.ulianla.uplay.databinding.FragmentServersBinding

class ServersFragment : Fragment() {

    private var _binding: FragmentServersBinding? = null
    private var NSView:NestedScrollView? = null
    private var extended_fab: ExtendedFloatingActionButton? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServersBinding.inflate(inflater, container, false)
        NSView = binding.NSView
        extended_fab = binding.extendedFab
        //NestedScrollVie向下滑动时隐藏FAB 向上滑动时显示FAB
        NSView?.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY - oldScrollY > 0) {
                extended_fab?.hide()
            } else {
                extended_fab?.show()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
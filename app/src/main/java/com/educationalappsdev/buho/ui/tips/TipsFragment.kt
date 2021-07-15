package com.educationalappsdev.buho.ui.tips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.educationalappsdev.buho.R

class TipsFragment : Fragment() {

    private lateinit var tipsViewModel: TipsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tipsViewModel =
            ViewModelProvider(this).get(TipsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tips, container, false)
        return root
    }
}
package org.sopt.sample.presentation.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.sample.R


class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() {}
    }
}
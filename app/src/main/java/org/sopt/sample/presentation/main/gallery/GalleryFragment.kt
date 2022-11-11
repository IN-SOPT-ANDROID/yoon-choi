package org.sopt.sample.presentation.main.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentGalleryBinding


class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vpGallery.adapter = GalleryAdapter().apply {
            setItems(
                listOf(
                    R.drawable.myimage,
                    R.drawable.ic_settings
                )
            )
        }
    }

    companion object {
        fun newInstance() {}
    }
}
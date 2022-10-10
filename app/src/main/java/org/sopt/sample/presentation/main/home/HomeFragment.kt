package org.sopt.sample.presentation.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.sample.R
import org.sopt.sample.data.RepoData
import org.sopt.sample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화되지 않았슴다.")
    private val mockRepoList = listOf<RepoData>(
        RepoData(
            image = R.drawable.nunu,
            title = "NuNu",
            description = "안드로이드 파트장"
        ),
        RepoData(
            image = R.drawable.murjun,
            title = "murjun",
            description = "안드로이드 차기 파트장"
        ),
        RepoData(
            image = R.drawable.kown,
            title = "Vixx",
            description = "안드로이드 연예인"
        ),
        RepoData(
            image = R.drawable.subin,
            title = "subin",
            description = "안드로이드 엄마"
        )

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HomeAdapter(requireContext())
        binding.rvHomeFragment.adapter = adapter
        adapter.setRepoList(mockRepoList)   //notifydataset
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() {
            
        }
    }
}
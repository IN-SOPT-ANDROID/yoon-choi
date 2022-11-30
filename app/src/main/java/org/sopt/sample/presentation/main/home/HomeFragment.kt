package org.sopt.sample.presentation.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.sample.data.remote.ServicePool
import org.sopt.sample.data.remote.home.ResponseHomeUser
import org.sopt.sample.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화되지 않았슴다.")
    private val homeService = ServicePool.reqresService

    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HomeAdapter(requireContext())
        binding.rvHomeFragment.adapter = adapter
//        adapter.setRepoList(viewModel.mockRepoList)   //notifydataset
        homeService.GetUser(1).enqueue(object : Callback<ResponseHomeUser> {
            override fun onResponse(
                call: Call<ResponseHomeUser>,
                response: Response<ResponseHomeUser>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        adapter.setRepoList(it.data)
                    }
                } else {
                    Log.d("signupActivity", "onSuccess에서 fail: $response ")
                }
            }

            override fun onFailure(call: Call<ResponseHomeUser>, t: Throwable) {
                Log.d("signupActivity", "onFailure: ")
            }
        })
    }

    private fun initServer() {

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
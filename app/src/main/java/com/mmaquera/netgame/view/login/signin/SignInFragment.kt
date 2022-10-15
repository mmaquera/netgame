package com.mmaquera.netgame.view.login.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mmaquera.netgame.MainActivity
import com.mmaquera.netgame.R
import com.mmaquera.netgame.databinding.FragmentSignInBinding
import com.mmaquera.netgame.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            signUpTextView.setOnClickListener {
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
            }
            buttonSignIn.setOnClickListener {
                viewModel.process(
                    SignInEvent.DoLogin(
                        userName = userNameEditText.text.toString(),
                        password = passwordEditText.text.toString()
                    )
                )
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.viewState.collect(::render)
        }
    }

    private fun render(viewState: SignInViewState) {
        when (viewState) {
            SignInViewState.AnotherError -> {
            }
            SignInViewState.Authorization -> {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            }
            is SignInViewState.Error -> requireActivity().toast(viewState.message)
            SignInViewState.HideLoading -> {
            }
            SignInViewState.ShowLoading -> {
            }
        }
    }

}

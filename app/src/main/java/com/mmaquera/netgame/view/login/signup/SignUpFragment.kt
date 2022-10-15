package com.mmaquera.netgame.view.login.signup


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mmaquera.netgame.databinding.FragmentSignUpBinding
import com.mmaquera.netgame.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            closeImageView.setOnClickListener {
                findNavController().navigateUp()
            }
            signUpButton.setOnClickListener {
                viewModel.process(
                    SignUpViewEvent.DoSignUp(
                        userName = userNameEditText.text.toString(),
                        password = passwordEditText.text.toString(),
                        confirmPassword = confirmPasswordEditText.text.toString()
                    )
                )
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.viewState.collect(::render)
        }
    }

    private fun render(viewState: SignUpViewState){
        when(viewState){
            is SignUpViewState.Error -> requireActivity().toast(viewState.message)
            SignUpViewState.HideLoading -> {}
            SignUpViewState.ShowLoading -> {}
            SignUpViewState.Success -> {
                findNavController().navigateUp()
            }
        }
    }

}

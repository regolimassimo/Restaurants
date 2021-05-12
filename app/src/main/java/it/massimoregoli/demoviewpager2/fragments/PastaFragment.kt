package it.massimoregoli.demoviewpager2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import it.massimoregoli.demoviewpager2.databinding.FragmentPastaBinding
import it.massimoregoli.demoviewpager2.viewmodel.CommViewModel


class PastaFragment : Fragment() {
    private lateinit var binding: FragmentPastaBinding
    private val viewModel: CommViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPastaBinding.inflate(layoutInflater, container, false)

        viewModel.data.observe(viewLifecycleOwner,  {
            Log.w("OBSERVER", "PastaFragment")
            binding.textView.text = viewModel.data.value!![0]
        })

        return binding.root
    }
}
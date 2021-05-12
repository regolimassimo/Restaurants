package it.massimoregoli.demoviewpager2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import it.massimoregoli.demoviewpager2.adapters.ChickenAdapter
import it.massimoregoli.demoviewpager2.viewmodel.ChickenViewModel
import androidx.lifecycle.Observer
import it.massimoregoli.demoviewpager2.databinding.FragmentChickenBinding
import it.massimoregoli.demoviewpager2.listeners.ChickenToMain


class ChickenFragment : Fragment(), ChickenToMain {
    private lateinit var adapter: ChickenAdapter
    private lateinit var binding: FragmentChickenBinding
    private val model: ChickenViewModel by viewModels()
    private lateinit var mListener: ChickenToMain

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChickenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mListener = if(context is ChickenToMain)
            context
        else
            this
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val observer = Observer<MutableList<String>> { list ->
            adapter = ChickenAdapter(model)
            binding.rvChicken.layoutManager = LinearLayoutManager(activity)
            binding.rvChicken.adapter = adapter
            // update Main
            mListener.chickenList(list)
        }
        model.list.observe(requireActivity(), observer)
    }

    override fun chickenList(list: MutableList<String>) {
        Toast.makeText(context, "NO IMPLEMENTATION",
            Toast.LENGTH_SHORT).show()
    }

}
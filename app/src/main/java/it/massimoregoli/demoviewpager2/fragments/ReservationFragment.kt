package it.massimoregoli.demoviewpager2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import it.massimoregoli.demoviewpager2.R
import it.massimoregoli.demoviewpager2.viewmodel.CommViewModel


class ReservationFragment : Fragment() {
    private val viewModel: CommViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.data.observe(viewLifecycleOwner,  {
            Log.w("OBSERVER", "ReservationFragment")
        })
        return inflater.inflate(R.layout.fragment_reservation, container, false)
    }
}
package it.massimoregoli.demoviewpager2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.massimoregoli.demoviewpager2.databinding.ItemFoodBinding
import it.massimoregoli.demoviewpager2.viewmodel.ChickenViewModel

class ChickenAdapter(private val model: ChickenViewModel): RecyclerView.Adapter<ChickenAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemFoodBinding): RecyclerView.ViewHolder(binding.root) {
        val tvDesc = binding.tvDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ItemFoodBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvDescription.text = model.list.value?.get(position) ?: ""
        holder.tvDesc.setOnClickListener {
            model.onClick(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return model.getSize()
    }
}
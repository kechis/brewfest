package org.kechis.brewfest.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.kechis.brewfest.databinding.RowBrewBinding
import org.kechis.brewfest.model.Brew
import org.kechis.brewfest.viewmodel.BrewViewModel


class BrewAdapter(private val mBrews: List<Brew>, context: Context) : RecyclerView.Adapter<BrewAdapter.BrewViewHolder>() {

    private  val mInflator: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BrewViewHolder {
        val rowBrewBinding = RowBrewBinding.inflate(mInflator)
        return BrewViewHolder(rowBrewBinding)
    }

    override fun onBindViewHolder(holder: BrewViewHolder, position: Int) {
        val binding = holder.binding
        binding.brew = BrewViewModel(mBrews[position])
    }

    override fun getItemCount(): Int {
        return mBrews.size
    }

    class BrewViewHolder(val binding: RowBrewBinding
    ) : RecyclerView.ViewHolder(binding.mainLayout)


}

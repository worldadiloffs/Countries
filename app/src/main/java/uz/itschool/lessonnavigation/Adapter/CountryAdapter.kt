package uz.itschool.lessonnavigation.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import uz.itschool.lessonnavigation.Model.Country
import uz.itschool.lessonnavigation.R
import uz.itschool.lessonnavigation.databinding.ItemCountryBinding
import java.util.*

class CountryAdapter(var countries: MutableList<Country>, var myCountry: MyCountry, var context: Context) : RecyclerView.Adapter<CountryAdapter.MyHolder>(), uz.itschool.lessonnavigation.TouchHelper.ItemTouchHelper {
    class MyHolder(binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        var name = binding.name
        var img = binding.img
        var population = binding.population
        var area = binding.area
        var fav = binding.fav
        var sec = binding.sec
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var country = countries[position]
        holder.name.text = country.name
        holder.img.load(country.img) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
            transformations(CircleCropTransformation())
        }
        holder.population.text = country.population
        holder.area.text = country.area
        val anim = AnimationUtils.loadAnimation(context, R.anim.animation)
        holder.sec.startAnimation(anim)

        if (country.status) holder.fav.setImageResource(R.drawable.fav)
        else holder.fav.setImageResource(R.drawable.un_fuv)

        holder.fav.setOnClickListener {
            if (country.status){
                holder.fav.setImageResource(R.drawable.un_fuv)
                country.status = false
                if (holder.fav.tag == 1){
                    countries.removeAt(position)
                    notifyDataSetChanged()
                }
                return@setOnClickListener
            }
            holder.fav.setImageResource(R.drawable.fav)
            country.status = true
        }

        holder.itemView.setOnClickListener {
            myCountry.onItemClick(country)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }
    interface MyCountry{
        fun onItemClick(country: Country)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if(fromPosition < toPosition){
            for(i in fromPosition until toPosition){
                Collections.swap(countries, i, i+1)
            }
        }
        else{
            for(i in fromPosition downTo toPosition+1){
                Collections.swap(countries,i,i-1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        countries.removeAt(position)
        notifyItemRemoved(position)
    }
}
package com.yerinde.superkahramankitabi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yerinde.superkahramankitabi.databinding.RecyclerRowBinding

class SuperKahramanAdapter(val List: ArrayList<SuperKahraman>): RecyclerView.Adapter<SuperKahramanAdapter.SuperKahramanViewHolder>() {
    class SuperKahramanViewHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuperKahramanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        //listede bulunan kadar item ekleme
        return List.size
    }

    override fun onBindViewHolder(holder: SuperKahramanViewHolder, position: Int) {
        //ilk sayfaya listedeki elemanları ekleme
        holder.binding.textView.text = List[position].name

        //ilk sayfadaki itemlere tıklandığında ilgili sayfaya yönlendirme için intent oluşturma
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Tanitim::class.java)
            intent.putExtra("Hero", List[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}
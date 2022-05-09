package com.dahlos.challengestarwars.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dahlos.challengestarwars.core.BaseViewHolder
import com.dahlos.challengestarwars.data.model.Character
import com.dahlos.challengestarwars.data.model.CharacterList
import com.dahlos.challengestarwars.databinding.CharacterItemBinding

class CharacterAdapter(private val characterList: List<Character>): RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CharacterViewHolder -> holder.bind(characterList[position])
        }
    }

    override fun getItemCount(): Int = characterList.size

    private inner class CharacterViewHolder(val binding: CharacterItemBinding) :
        BaseViewHolder<Character>(binding.root) {

        override fun bind(item: Character) {
            Log.v("CharacterAdapter", "bind: ${item.name}")
            binding.tvCharacterName.text = item.name
        }
    }

}
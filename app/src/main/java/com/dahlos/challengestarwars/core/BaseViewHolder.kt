package com.dahlos.challengestarwars.core

import androidx.recyclerview.widget.RecyclerView
import com.dahlos.challengestarwars.data.model.Character

abstract class BaseViewHolder<T>(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Character)
}
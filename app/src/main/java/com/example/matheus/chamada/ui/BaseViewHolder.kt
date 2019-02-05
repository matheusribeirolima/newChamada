package com.example.matheus.chamada.ui

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal val binding: T? = DataBindingUtil.bind(itemView)

}
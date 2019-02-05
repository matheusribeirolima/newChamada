package com.example.matheus.chamada.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerView<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = LayoutInflater.from(parent.context).inflate(getLayoutId(viewType), parent, false)
        return getViewHolderInstance(itemView, viewType)
    }

    override fun getItemCount(): Int {
        return getItems().size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindViewHolder(holder, getItems()[position], position)
    }

    abstract fun getLayoutId(viewType: Int): Int

    abstract fun getViewHolderInstance(itemView: View, viewType: Int): VH

    abstract fun onBindViewHolder(holder: VH, item: T, position: Int)

    abstract fun getItems(): List<T>
}
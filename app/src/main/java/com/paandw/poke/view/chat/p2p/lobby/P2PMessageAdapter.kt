package com.paandw.poke.view.chat.p2p.lobby

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.paandw.poke.data.p2p.P2PMessage
import com.paandw.poke.view.custom.ConversationItem

internal class P2PMessageAdapter (private val presenter: P2PLobbyPresenter) : RecyclerView.Adapter<P2PMessageAdapter.ViewHolder>() {

    private val messages = ArrayList<P2PMessage>()

    fun setListItems(items: MutableList<P2PMessage>) {
        messages.clear()
        messages.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): P2PMessageAdapter.ViewHolder {
        return ViewHolder(ConversationItem(parent.context))
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: P2PMessageAdapter.ViewHolder, position: Int) {
        holder.searchItem.setup(messages[position])
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var searchItem: ConversationItem = itemView as ConversationItem

    }

}
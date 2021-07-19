package com.example.contactmanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val contactList:ArrayList<Contact>, val context:Context,val callback:ContactCallBack):RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v  = inflater.inflate(R.layout.item_contact,parent,false)
        return ContactViewHolder(v)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.avatar.setImageBitmap(contactList[position].avatar)
        holder.name.text = contactList[position].contactName
        holder.lastName.text = contactList[position].contactLastName
        holder.email.text = contactList[position].contactEmail
        holder.editDeleteItem.setOnClickListener { callback.itemContactSelected(position) }
    }

    override fun getItemCount(): Int = contactList.size
}
class ContactViewHolder(val v: View): RecyclerView.ViewHolder(v) {
    var name: TextView
    var lastName: TextView
    var email: TextView
    var avatar: ImageView
    var editDeleteItem: ImageView

    init {
        name = v.findViewById(R.id.tvNameItem)
        lastName = v.findViewById<TextView>(R.id.tvLastNameItem)
        email = v.findViewById(R.id.tvEmailItem)
        avatar = v.findViewById(R.id.ivAvatarItem)
        editDeleteItem = v.findViewById(R.id.ivEditDeleteItem)
    }
}
    interface ContactCallBack{
        fun itemContactSelected(index:Int)
        
    }

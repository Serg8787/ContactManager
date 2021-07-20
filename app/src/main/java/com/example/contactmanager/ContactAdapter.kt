package com.example.contactmanager

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val contactList:ArrayList<Contact>, val context:Context,val callback:ContactCallBack):
    RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v  = inflater.inflate(R.layout.item_contact,parent,false)
        return ContactViewHolder(v)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.avatar.setImageBitmap(contactList[position].avatar)
        holder.name.text = contactList[position].name
        holder.lastName.text = contactList[position].lastName
        holder.email.text = contactList[position].email
        holder.editItem.setOnClickListener {
            callback.itemContactSelected(position)
        }
        holder.constRoot.setOnClickListener{
            callback.conatactAllView(position)
        }

        holder.deleteItem.setOnClickListener {
            val builder = AlertDialog.Builder(context)
                .setTitle("Delete Сontact")
                .setIcon(R.drawable.ic_warning)
                .setMessage("Are you sure delete this Information")
                .setPositiveButton("Yes"){
                        dialog,_->
                    contactList.removeAt(position)
                    notifyDataSetChanged()
                    Toast.makeText(context,"Deleted this Contact", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setNegativeButton("No"){
                        dialog,_->
                    dialog.dismiss()
                }
                .create()
                .show()
        }
    }

    override fun getItemCount(): Int = contactList.size
}
class ContactViewHolder(val v: View): RecyclerView.ViewHolder(v) {
    var name: TextView
    var lastName: TextView
    var email: TextView
    var avatar: ImageView
    var editItem: ImageView
    var deleteItem: ImageView
    var constRoot:View

    init {
        avatar = v.findViewById(R.id.ivAvatarItem)
        name = v.findViewById(R.id.tvNameItem)
        lastName = v.findViewById(R.id.tvLastNameItem)
        email = v.findViewById(R.id.tvEmailItem)
        editItem = v.findViewById(R.id.ivEditItem)
        deleteItem = v.findViewById(R.id.ivDeleteItem)
        constRoot = v.findViewById(R.id.constRoot)
    }
}
    interface ContactCallBack{
        fun itemContactSelected(index:Int)
        fun conatactAllView(index: Int)
        
    }


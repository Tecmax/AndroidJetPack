package com.maersk.androidmng

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val arrayList: ArrayList<User>) :
    RecyclerView.Adapter<StudentAdapter.StudentHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.name.text = arrayList[position].email
        holder.username.text = arrayList[position].username

        holder.name.setOnClickListener {
            val nes = arrayList[position]
            val sd = Intent(holder.name.context,ProofActivity::class.java)
            sd.putExtra("userObj",nes)
            holder.name.context.startActivity(sd)


        }
    }


    class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.textView)
        val username = itemView.findViewById<TextView>(R.id.username)
        val pic = itemView.findViewById<ImageView>(R.id.imageView)


    }
}
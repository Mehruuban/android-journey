package com.mehru.listviews

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.collection.intIntMapOf
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val context:Activity, val arrayList: ArrayList<User>)
    : ArrayAdapter<User>(context,R.layout.eachrow,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachrow,null)

        val profileImg = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.name)
        val message = view.findViewById<TextView>(R.id.message)
        val time = view.findViewById<TextView>(R.id.time)

        name.text = arrayList[position].name
        message.text = arrayList[position].msg
        time.text = arrayList[position].time
        profileImg.setImageResource(arrayList[position].imageId)


        return view
    }
}
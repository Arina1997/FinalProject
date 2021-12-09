package projects.khoreva.finalproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LoansViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewLoansText: TextView = itemView.findViewById(R.id.view_loans)
    fun bind(text: String) {
        viewLoansText.text = text
    }


}
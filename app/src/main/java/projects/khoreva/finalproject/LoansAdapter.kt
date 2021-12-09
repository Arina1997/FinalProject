package projects.khoreva.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LoansAdapter(private val loansText: List<String>) :
    RecyclerView.Adapter<LoansViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoansViewHolder {

        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.loans_list_item, parent, false)
        return LoansViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LoansViewHolder, position: Int) {
        val text = loansText[position]
        holder.bind(text)
    }

    override fun getItemCount(): Int {
        return loansText.size
    }
}
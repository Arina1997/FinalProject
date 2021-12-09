package projects.khoreva.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AboutLoansFragment : Fragment() {
    lateinit var showGitHubButton: Button
    lateinit var recyclerViewLoans: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_loans, container, false)
        val loansText: List<String> = listOf(
            "Целевой",
            "Нецелевой",
            "Автокредит",
            "Ипотечный",
            "На строительство",
            "Социальный",
            "На развитие бизнеса"
        )
        showGitHubButton = view.findViewById(R.id.button_show_git_hub)
        recyclerViewLoans = view.findViewById(R.id.recycler_view_loans)
        recyclerViewLoans.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerViewLoans.adapter = LoansAdapter(loansText)


        showGitHubButton.setOnClickListener {
            val link = Uri.parse("https://github.com/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)

        }

        return view
    }

}
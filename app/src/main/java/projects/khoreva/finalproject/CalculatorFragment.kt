package projects.khoreva.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow


class CalculatorFragment : Fragment() {

    private lateinit var inputSumCredit: TextInputEditText
    private lateinit var inputInterestRate: TextInputEditText
    private lateinit var inputCreditTerm: TextInputEditText

    private lateinit var viewOverpayment: TextView
    private lateinit var viewTotalPayment: TextView
    private lateinit var viewPayment: TextView

    private lateinit var buttonCalculate: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        inputSumCredit = view.findViewById(R.id.input_sum_credit)
        inputInterestRate = view.findViewById(R.id.input_interest_rate)
        inputCreditTerm = view.findViewById(R.id.input_credit_term)
        viewOverpayment = view.findViewById(R.id.view_overpayment)
        viewTotalPayment = view.findViewById(R.id.view_total_payment)
        viewPayment = view.findViewById(R.id.view_payment)
        buttonCalculate = view.findViewById(R.id.button_calculate)

        fun String.isDigitsOnly() = all(Char::isDigit) && isNotEmpty()

        buttonCalculate.setOnClickListener {
            val sumCredit = inputSumCredit.text.toString()
            val interestRate = inputInterestRate.text.toString()
            val creditTerm = inputCreditTerm.text.toString()

            if (sumCredit.toDouble() <= 0 || interestRate.toDouble() <= 0 || creditTerm.toDouble() <= 0 ||
                !sumCredit.isDigitsOnly() || !interestRate.isDigitsOnly() || !creditTerm.isDigitsOnly()
            )
                Toast.makeText(context, "Корректно заполните все поля ввода!", Toast.LENGTH_LONG)
                    .show()
            else {
                val percent = interestRate.toDouble() / 100.0 / 12.0
                val payment =
                    sumCredit.toDouble() * ((percent * (1 + percent).pow(creditTerm.toDouble())) / ((1 + percent).pow(
                        creditTerm.toDouble()
                    ) - 1))

                viewPayment.text = String.format("%.2f", payment)
                val overPayment = payment * creditTerm.toDouble() - sumCredit.toDouble()
                viewOverpayment.text = String.format("%.2f", overPayment)
                viewTotalPayment.text =
                    String.format("%.2f", (sumCredit.toDouble() + overPayment))

            }
        }

        return view
    }


}



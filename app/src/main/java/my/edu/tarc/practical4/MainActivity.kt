package my.edu.tarc.practical4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import my.edu.tarc.practical4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var investment: Investment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinnerAge.selectedItemPosition

            if(binding.editTextNumber.text.toString().isEmpty()){
                binding.editTextNumber.setError("Value Required")
                return@setOnClickListener
            }
            val account_balance = binding.editTextNumber.text.toString().toFloat()

            if(account_balance < 5000){
                //Inform user that he/she is not eligible for investment
                return@setOnClickListener
            }
            var amount: Float = 0.0f
            when(age){
                0-> //16 to 20
                    amount = (account_balance - 5000) * 0.3f
                1-> //21 to 25
                    amount = (account_balance - 14000) * 0.3f
                2-> //26 to 30
                    amount = (account_balance - 29000) * 0.3f
                3-> //31 to 35
                    amount = (account_balance - 50000) * 0.3f
                4-> //36 to 40
                    amount = (account_balance - 78000) * 0.3f
                5-> //41 to 45
                    amount = (account_balance - 116000) * 0.3f
                6-> //46 to 50
                    amount = (account_balance - 165000) * 0.3f
                7-> //51 to 55
                    amount = (account_balance -228000) * 0.3f
                else ->
                    amount = 0.0f
            }
            investment = Investment(amount.toString())
            binding.myInvestment = investment
            //binding.textViewPremium.text = myInvestment
        }
        binding.buttonReset.setOnClickListener{
            binding.myInvestment = Investment("0.00")
        }
    }
}
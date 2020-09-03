package nl.svdoetelaar.madlevel1task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import nl.svdoetelaar.madlevel1task2.databinding.ActivityConjunctionBinding
import java.util.regex.Pattern
import java.util.regex.Pattern.compile

class ConjunctionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConjunctionBinding
    private val t: Pattern = compile("^[T]$")
    private val f: Pattern = compile("^[F]$")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConjunctionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.btnSubmit.setOnClickListener { submit() }
    }

    private fun submit() {
        var correctAnswerCount = 0

        if (binding.ab2.text.matches(t.toRegex())) correctAnswerCount++
        if (binding.ab3.text.matches(f.toRegex())) correctAnswerCount++
        if (binding.ab4.text.matches(f.toRegex())) correctAnswerCount++
        if (binding.ab5.text.matches(f.toRegex())) correctAnswerCount++

        if (correctAnswerCount == 0) {
            incorrect()
        } else {
            correct(correctAnswerCount)
        }
    }

    private fun correct(correctAnswerCount: Int) {
        Toast.makeText(this, getString(R.string.correct, correctAnswerCount), Toast.LENGTH_SHORT)
            .show()
    }

    private fun incorrect() {
        Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show()
    }
}
package nl.svdoetelaar.madlevel1task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import nl.svdoetelaar.madlevel1task2.databinding.ActivityConjunctionBinding
import java.util.regex.Pattern
import java.util.regex.Pattern.CASE_INSENSITIVE
import java.util.regex.Pattern.compile

class ConjunctionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConjunctionBinding
    private val tf: Pattern = compile("^[TF]$", CASE_INSENSITIVE + DEFAULT_KEYS_SEARCH_GLOBAL)
    private val t: Pattern = compile("^[T]$", CASE_INSENSITIVE + DEFAULT_KEYS_SEARCH_GLOBAL)
    private val f: Pattern = compile("^[F]$", CASE_INSENSITIVE + DEFAULT_KEYS_SEARCH_GLOBAL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConjunctionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.btnSubmit.setOnClickListener { click() }
    }

    private fun click() {
        if (!binding.ab2.text.matches(tf.toRegex()) ||
            !binding.ab3.text.matches(tf.toRegex()) ||
            !binding.ab4.text.matches(tf.toRegex()) ||
            !binding.ab5.text.matches(tf.toRegex())
        ) {
            invalid()
            return
        }

        if (binding.ab2.text.matches(t.toRegex()) &&
            binding.ab3.text.matches(f.toRegex()) &&
            binding.ab4.text.matches(f.toRegex()) &&
            binding.ab5.text.matches(f.toRegex())
        ) {
            correct()
        } else {
            incorrect()
        }

    }

    private fun invalid() {
        Toast.makeText(this, R.string.invalid, Toast.LENGTH_SHORT).show()
    }

    private fun correct() {
        Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
    }

    private fun incorrect() {
        Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show()
    }
}
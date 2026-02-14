package com.example.project_random_item

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_random_item.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dotaItems = listOf(
        ItemData(R.string.item_rapira, R.drawable.rapira),
        ItemData(R.string.item_krit, R.drawable.krit),
        ItemData(R.string.item_skipet, R.drawable.skipet),
        ItemData(R.string.item_skadi, R.drawable.skadi),
        ItemData(R.string.item_babochka, R.drawable.butterfly),
        ItemData(R.string.item_manta, R.drawable.manta)
    )

    class ItemData(
        val nameResId: Int,
        val imageResId: Int
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.randomButton.setOnClickListener {
            selectRandomItem()
        }

        showItem(0)
    }

    private fun selectRandomItem() {
        val randomIndex = dotaItems.indices.random()
        showItem(randomIndex)
    }

    private fun showItem(index: Int) {
        val item = dotaItems[index]
        binding.itemImageView.setImageResource(item.imageResId)
        binding.itemNameTextView.text = getString(item.nameResId)
    }
}

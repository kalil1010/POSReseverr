package com.example.posbaby.receiver

import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.posbaby.receiver.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.text.SimpleDateFormat
import java.util.*

// Data class matching backend
data class CardRead(val id: Int, val holder_name: String, val pan: String,
                    val expiry: String, val cvv: Int, val issuer_id: String,
                    val track: String, val amount: Float? = 0f)

interface CardApi {
    @GET("cards/")
    fun getCards(): Call<List<CardRead>>
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cardApi: CardApi
    private var currentCard: CardRead? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.statusText.text = "Ready"

        // Retrofit setup
        val retrofit = Retrofit.Builder()
            .baseUrl("https://posbaby-production.up.railway.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        cardApi = retrofit.create(CardApi::class.java)

        // NFC setup
        if (NfcAdapter.getDefaultAdapter(this) == null) {
            showToast("NFC not available")
            binding.statusText.text = "NFC not available"
        }

        binding.loadCardButton.setOnClickListener { loadCard() }
        binding.nfcSettingsButton.setOnClickListener { openNfcSettings() }
    }

    private fun loadCard() {
        binding.statusText.text = "Loading card..."
        cardApi.getCards().enqueue(object : Callback<List<CardRead>> {
            override fun onResponse(call: Call<List<CardRead>>, response: Response<List<CardRead>>) {
                val cards = response.body().orEmpty()
                if (cards.isEmpty()) {
                    showToast("No cards")
                    binding.statusText.text = "No cards"
                    return
                }
                currentCard = cards.last()
                displayCard(currentCard!!)
                EmulationService.currentCardData = currentCard
                binding.statusText.text = "NFC emulation ready"
            }
            override fun onFailure(call: Call<List<CardRead>>, t: Throwable) {
                showToast("Error: ${t.message}")
                binding.statusText.text = "Error loading"
            }
        })
    }

    private fun displayCard(card: CardRead) {
        val masked = "${card.pan.take(4)} **** **** ${card.pan.takeLast(4)}"
        val expiry = try {
            val inFmt = SimpleDateFormat("yyyy-MM-dd", Locale.US)
            val outFmt = SimpleDateFormat("MM/yy", Locale.US)
            outFmt.format(inFmt.parse(card.expiry) ?: Date())
        } catch (e: Exception) { card.expiry }
        binding.cardInfo.text = "${card.holder_name}\n$masked\n$expiry\n${card.issuer_id}"
    }

    private fun openNfcSettings() {
        startActivity(Intent(android.provider.Settings.ACTION_NFC_PAYMENT_SETTINGS))
        showToast("Set this app as default payment app")
    }

    private fun showToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

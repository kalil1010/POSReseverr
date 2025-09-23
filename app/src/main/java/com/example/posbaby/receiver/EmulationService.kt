package com.example.posbaby.receiver

import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log

class EmulationService : HostApduService() {

    companion object {
        private const val TAG = "EmulationService"
        var currentCardData: CardRead? = null
    }

    override fun processCommandApdu(commandApdu: ByteArray?, extras: Bundle?): ByteArray {
        if (commandApdu == null) return byteArrayOf(0x6F, 0x00)
        val hex = commandApdu.joinToString("") { "%02X".format(it) }
        Log.d(TAG, "APDU: $hex")

        // Implement simplified EMV flow here (PPSE, SELECT, GPO, READ)
        // For brevity, respond success
        return byteArrayOf(0x90.toByte(), 0x00.toByte())
    }

    override fun onDeactivated(reason: Int) {
        Log.d(TAG, "Deactivated: $reason")
    }
}

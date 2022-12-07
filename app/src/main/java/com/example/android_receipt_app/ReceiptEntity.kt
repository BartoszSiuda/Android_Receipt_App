package com.example.android_receipt_app

import java.text.DateFormat
import java.util.*

data class ReceiptEntity(
        val title: String?,
        val image: String?,
        val description: String?,
        val creationDate: Date?,
)


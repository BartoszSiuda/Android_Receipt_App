package com.example.android_receipt_app

class ReceiptStorageViewModel {

    var receiptsMainStorage = ArrayList<ReceiptEntity>()

     fun removeReceiptFromMainStorage(receiptToDelete: Int) {
         receiptsMainStorage.removeAt(receiptToDelete)
    }

}
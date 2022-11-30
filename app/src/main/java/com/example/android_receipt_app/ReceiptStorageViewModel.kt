package com.example.android_receipt_app

class ReceiptStorageViewModel {

    var receiptsMainStorage = ArrayList<ReceiptEntity>()


     fun removeReceiptFromMainStorage(receiptToDelete: ReceiptEntity) {




    }


    // Todo: We will implement proper removing of the receipt from our list.
    // First step to do this is: create here (in the ViewModel) a new function
    // "removeReceiptFromMainStorage()" (empty function for now).

    // Second step: make this function receiving a variable (box) named "receiptToDelete", and being
    // a type of "ReceiptEntity". It will be indicating the receipt we wanna remove from the list.

    // Third step: implement the body of this new function. In this function we just need a one line.
    // It will be "receiptsMainStorage.remove(RECEIPT_YOU_WANT_TO_REMOVE_VARIABLE)".
    // This line removes given element from the list.
}
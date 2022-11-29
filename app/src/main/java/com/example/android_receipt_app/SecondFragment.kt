package com.example.android_receipt_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android_receipt_app.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        setupButtons()
        return binding.root
    }

    private fun setupButtons() {
        binding.buttonArrow.setOnClickListener {
            openFirstFragment()
        }

        binding.confirm.setOnClickListener {

            // Todo: Add validation. Check here if the title or description is empty. If any
            //  of these two is empty - then display the Toast message with text
            //  "Empty title or description". Otherwise ("else") perform the code below.
            val newReceipt = createReceipt()

            if (binding.Title1.text.isEmpty()) {
                Toast.makeText(activity, "Empty title", Toast.LENGTH_SHORT).show()
            } else if (binding.Description1.text.isEmpty()) {
                Toast.makeText(activity, "Empty description", Toast.LENGTH_SHORT).show()
            } else {
                addReceiptToTheList(newReceipt)
                openFirstFragment()
            }
        }
    }

    private fun createReceipt(): ReceiptEntity {
        val title = binding.Title1.text.toString()
        val image = "https://upload.wikimedia.org/wikipedia/commons/b/bb/Carmen_Electra_2013.jpg"
        val description = binding.Description1.text.toString()

        return ReceiptEntity(
            title,
            image,
            description
        )
    }

    private fun addReceiptToTheList(receipt: ReceiptEntity){
        (activity as MainActivity).viewModel.receiptsMainStorage.add(receipt)
    }

    private fun openFirstFragment() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.nav_host_fragment_content_main, FirstFragment())
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
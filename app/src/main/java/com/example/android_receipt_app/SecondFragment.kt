package com.example.android_receipt_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_receipt_app.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

            createReceiptAndAddToList()
            openFirstFragment()
        }
    }

    private fun createReceiptAndAddToList() {

        val title = binding.Title1.text.toString()
        val image = "https://upload.wikimedia.org/wikipedia/commons/b/bb/Carmen_Electra_2013.jpg"
        val description = binding.Description1.text.toString()
        val receipt = ReceiptEntity(
            title,
            image,
            description
        )

        // 2. We add our new receipt to all receipts box.
        (activity as MainActivity).receiptsMainStorage.add(receipt)

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
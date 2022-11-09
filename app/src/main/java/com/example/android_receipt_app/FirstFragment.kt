package com.example.android_receipt_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_receipt_app.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        setupButtons()
        return binding.root
    }

    private fun setupList() {

    }

    private fun setupButtons() {
        binding.buttonPurple.setOnClickListener {
            openSecondFragment()
        }
    }

    private fun openSecondFragment() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(com.example.android_receipt_app.R.id.nav_host_fragment_content_main, SecondFragment())
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getFakeReceipts(): List<ReceiptEntity> {

        // We create variables (boxes) with title, image and description.
        val title = "Naleśniki"
        val image = "https://www.everyday-delicious.com/wp-content/uploads/2021/01/nalesniki-recipe-nalesniki-z-serem-everyday-delicious-3.jpg"
        val description = "This naleśniki recipe is one of the favorite dishes from my childhood. It consists of crepes filled with sweetened Polish twaróg cheese with a touch of vanilla. They taste absolutely amazing and are easy to make!"

        // Now we create our "fake receipt" for construction purposes.
        val fakeReceipt = ReceiptEntity(
            title,
            image,
            description
        )

        // We return the list of receipts to anyone who asked for it.
        return listOf<ReceiptEntity>(fakeReceipt, fakeReceipt, fakeReceipt)
    }
}


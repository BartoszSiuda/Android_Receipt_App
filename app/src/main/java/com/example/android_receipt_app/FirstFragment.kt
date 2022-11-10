package com.example.android_receipt_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_receipt_app.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        setupList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    private fun setupButtons() {
        binding.buttonPurple.setOnClickListener {
            openSecondFragment()
        }
    }

    private fun openSecondFragment() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.nav_host_fragment_content_main, SecondFragment())
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    private fun setupList() {

        // We create a new adapter here.
        val adapter = ListAdapter(context)

        // We connect adapter to the list.
        list.adapter = adapter

        // We send things we wanna display to the adapter.
        val fakePosts = getFakeReceipts()
        adapter.setPosts(fakePosts)
    }


    ////////////////////////////////////////////////////////////////////////////////////////////


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

        val listOfFakeReceipts = ArrayList<ReceiptEntity>()
        for (int in 0..15) {
            listOfFakeReceipts.add(fakeReceipt)
        }
        // We return the list of receipts to anyone who asked for it.
        return listOfFakeReceipts
    }
}


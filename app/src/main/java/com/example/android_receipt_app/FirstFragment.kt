package com.example.android_receipt_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
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
        fetchReceiptToDisplay(adapter)

        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(list)

    }

    private fun fetchReceiptToDisplay(adapter: ListAdapter) {
        val storedReceipts = (activity as MainActivity).receiptsMainStorage
        adapter.setPosts(storedReceipts)
    }

    var simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
        ItemTouchHelper.SimpleCallback(
            0,
              ItemTouchHelper.RIGHT 
        ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {

            Toast.makeText(activity, "on Move", Toast.LENGTH_SHORT).show()

            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {

            Toast.makeText(activity, "on Swiped ", Toast.LENGTH_SHORT).show()

//            Remove swiped item from list and notify the RecyclerView
//            val position = viewHolder.adapterPosition
//            arrayList.remove(position)
//            adapter.notifyDataSetChanged()
        }
    }



}
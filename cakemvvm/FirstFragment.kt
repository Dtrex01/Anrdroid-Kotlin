package com.example.cakemvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cakemvvm.database.DatabaseCake
import com.example.cakemvvm.databinding.FragmentFirstBinding
import com.example.cakemvvm.recycler_adapters.CakeAdapter
import com.example.cakemvvm.viewmodel.CakeListViewModel
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel

import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var viewModelAdapter: CakeAdapter? = null

    private val viewModel: CakeListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false)
        // Inflate the layout for this fragment
        val binding: FragmentFirstBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        // Inflate the layout for this fragment
        // Set the lifecycleOwner so DataBinding can observe LiveData
        binding.setLifecycleOwner(viewLifecycleOwner)

        binding.viewmodel = viewModel
        viewModelAdapter = CakeAdapter()
        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = GridLayoutManager(context, 2)
           adapter = viewModelAdapter
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserverToGetData();
    }



    fun setUpObserverToGetData() {
        viewModel.cakeListResults.observe(viewLifecycleOwner,
            Observer<List<DatabaseCake>> { cake ->
                cake.apply {
                    viewModelAdapter?.results = cake

                  //  Timber.i(cake.get(2).title)
                }


            })
    }
}

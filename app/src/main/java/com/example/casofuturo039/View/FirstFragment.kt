package com.example.casofuturo039.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.casofuturo039.CoursesAdapter
import com.example.casofuturo039.CoursesViewModel
import com.example.casofuturo039.databinding.FragmentFirstBinding
import com.example.casofuturo039.R
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var  mBinding : FragmentFirstBinding
    private val mViewModel : CoursesViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // DEBEMOS INTANCIAR ADAPTER

        val adapter = CoursesAdapter()
        mBinding.recyclerView.adapter= adapter
        mBinding.recyclerView.layoutManager= LinearLayoutManager(context)
        mViewModel.getCoursesList().observe(viewLifecycleOwner, Observer {

            it?.let {
                Log.d("Listado", it.toString())
                adapter.update(it)
            }

        })

        // Llamamos al método para obtener los detalles del curso con id 101 desde la red.
        mViewModel.getCourseDetailByidFromInternet("101")


        // MÉTODO PARA SELECCIONAR

        adapter.selectedCourse().observe(viewLifecycleOwner, Observer {
            it?.let {
                // válidar si capta la seleccion
                Log.d("Seleccion", it.id.toString())

            }
            val bundle = Bundle().apply {
                putString("courseId", it.id)
            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)

        })



    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}
package com.example.casofuturo039.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.casofuturo039.CoursesViewModel
import com.example.casofuturo039.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var  mBinding : FragmentSecondBinding
    private val mViewModel : CoursesViewModel by activityViewModels()
    private var courseId : String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->


            courseId = bundle.getString("courseId")
            Log.d("seleccion", courseId.toString())
        }

        courseId?.let { id ->
            mViewModel.getCourseDetailByidFromInternet(id)

        }

        mViewModel.getCourseDetail().observe(viewLifecycleOwner, Observer {
            Log.d("seleccion3", courseId.toString())



// cargamos los datos desde la seleccion
            Glide.with(mBinding.ivLogo).load(it.image).into(mBinding.ivLogo)
            mBinding.tvTitle.text = it.title
            mBinding.tvDescription.text = it.previewDescription
            mBinding.tvMinimumSkill.text = "Conocimiento mínimo: ${it.minimumSkill}"
            mBinding.tvModality.text = "Modalidad: ${it.modality}"
            mBinding.tvTuition.text = "Valor del curso: ${it.tuition}"
            mBinding.tvDuration.text = "Duracion del curso ${it.weeks} semanas"
         //   mBinding.tvStart.text = "Inicio de clases: ${it.star}"




            // ACCION DE ENVIAR CORREO Eléctronico


        })


    }


    override fun onDestroyView() {
        super.onDestroyView()

    }
}
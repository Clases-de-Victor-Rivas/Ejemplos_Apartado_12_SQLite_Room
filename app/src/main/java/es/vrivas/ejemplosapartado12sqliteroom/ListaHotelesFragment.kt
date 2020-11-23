package es.vrivas.ejemplosapartado12sqliteroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.vrivas.ejemplosapartado12sqliteroom.database.SGDB
import kotlinx.android.synthetic.main.fragment_lista_hoteles.*

/**
 * A simple [Fragment] subclass.
 * Use the [ListaHotelesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaHotelesFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_hoteles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refrescar_informacion()
    }

    fun refrescar_informacion() {
        var db= context?.let { SGDB.getInstance(it) }
        if (db != null) {
            val los_hoteles= db.hotelDao.getAll()
            if(los_hoteles.isNotEmpty()) {
                tv_listado_hoteles.text = los_hoteles.joinToString(separator = "\n")
            } else {
                tv_listado_hoteles.text = "No hay hoteles en la BBDD."
            }
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
          * @return A new instance of fragment ListaHotelesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ListaHotelesFragment().apply {
             }
    }
}
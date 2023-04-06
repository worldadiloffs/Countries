package uz.itschool.lessonnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import coil.transform.CircleCropTransformation
import uz.itschool.lessonnavigation.Model.Country
import uz.itschool.lessonnavigation.databinding.FragmentMoreInfoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MoreInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoreInfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMoreInfoBinding.inflate(inflater, container, false)
        val country = arguments?.getSerializable("country") as Country
        binding.img.load(country.img) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images.load(country.images) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images2.load(country.images2) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images3.load(country.images3) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.name.text = country.name
        binding.population.text = country.population
        binding.area.text = country.area

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MoreInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MoreInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
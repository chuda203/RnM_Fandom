package com.up45.rnmfandom

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var characterRepository: CharacterRepository
    private fun getDataFromSharedPreferences(): List<Character> {
        return characterRepository.getCharactersFromSharedPreferences()
    }


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
        characterRepository = CharacterRepository(requireContext())
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Ambil data dari SharedPreferences
        val characters = getDataFromSharedPreferences()

        // Jika data tidak kosong, tampilkan nilai di TextView
        if (characters.isNotEmpty()) {
            val firstCharacter = characters.first() // Misalnya, mengambil karakter pertama
            val secondCharacter = characters.getOrNull(1)
            val thirdCharacter = characters.getOrNull(2)

            // Inisialisasi TextView untuk setiap atribut
            val textName = view.findViewById<TextView>(R.id.text_home61)
            val textStatus = view.findViewById<TextView>(R.id.text_home7)
            val textSpecies = view.findViewById<TextView>(R.id.text_home8)
            val textGender = view.findViewById<TextView>(R.id.text_home9)

            val textname1 = view.findViewById<TextView>(R.id.tv_name1)
            val textname2 = view.findViewById<TextView>(R.id.tv_name2)
            val textname3 = view.findViewById<TextView>(R.id.tv_name3)

            // Set nilai pada TextView sesuai dengan atribut karakter
            textName.text = "${firstCharacter.name}"
            textStatus.text = "${firstCharacter.status}"
            textSpecies.text = "${firstCharacter.species}"
            textGender.text = "${firstCharacter.gender}"

            textname1.text = "${firstCharacter?.name}"
            textname2.text = "${secondCharacter?.name}"
            textname3.text = "${thirdCharacter?.name}"
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
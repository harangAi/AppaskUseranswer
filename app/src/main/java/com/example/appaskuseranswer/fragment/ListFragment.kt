package com.example.appaskuseranswer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appaskuseranswer.R

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_list, container, false)
        return view
    }
<<<<<<< HEAD:app/src/main/java/com/example/appaskuseranswer/fragment/ListFragment.kt
}
=======
}











>>>>>>> parent of 328bef9 (AlertDialog 사용해보기):app/src/main/java/com/example/appaskuseranswer/navigation/SettingFragment.kt

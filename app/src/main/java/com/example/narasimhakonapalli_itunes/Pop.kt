package com.example.narasimhakonapalli_itunes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.narasimhakonapalli_itunes.api.ApiPop
import com.example.narasimhakonapalli_itunes.model.ITunesResponse
import com.example.narasimhakonapalli_itunes.view.SongAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 *
 * create an instance of this fragment.
 */


class Pop : Fragment()  {

    lateinit var pvUserList: RecyclerView
    lateinit var songAdapter: SongAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pvUserList = view.findViewById(R.id.pv_user_list)
        startRetrofit()
    }

    private fun startRetrofit() {
        ApiPop.createRetrofit().create(ApiPop::class.java).getSongs()
            .enqueue(object: Callback<ITunesResponse> {
                override fun onResponse(
                    call: Call<ITunesResponse>,
                    response: Response<ITunesResponse>
                ) {
                    if (response.isSuccessful) {
                        songAdapter = SongAdapter(response.body()!!.results)
                        pvUserList.adapter = songAdapter
                    }
                }

                override fun onFailure(call: Call<ITunesResponse>, t: Throwable) {
                    Toast.makeText(this@Pop.requireActivity(), t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}
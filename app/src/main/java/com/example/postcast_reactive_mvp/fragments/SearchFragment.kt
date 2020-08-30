package com.example.postcast_reactive_mvp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.adapters.CategoriesListAdapter
import com.example.postcast_reactive_mvp.adapters.LatestPodCastListAdapter
import com.example.postcast_reactive_mvp.data.vos.CategoryVO
import com.example.postcast_reactive_mvp.mvp.presenters.SearchPresenter
import com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls.HomePresenterImpl
import com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls.SearchPresenterImpl
import com.example.postcast_reactive_mvp.mvp.views.SearchView
import com.example.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SearchFragment : BaseFragment(),SearchView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mAdapter: CategoriesListAdapter
    private lateinit var mPresenter:SearchPresenter
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady()

    }



    private fun setUpPresenter(){
        mPresenter = SearchPresenterImpl
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler(){
        mAdapter = CategoriesListAdapter()
        rvCategories.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)
            adapter = mAdapter
        }
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showCategories(categoriesVO: List<CategoryVO>) {
        mAdapter.setData(categoriesVO)
    }

    override fun showErrorMessage(error: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }
}
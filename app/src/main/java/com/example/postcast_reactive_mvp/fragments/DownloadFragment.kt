package com.example.postcast_reactive_mvp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.activities.PodCastDetailActivity
import com.example.postcast_reactive_mvp.adapters.DownloadedListAdapter
import com.example.postcast_reactive_mvp.mvp.presenters.DownloadedPresenter
import com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls.DownloadedPresenterImpl
import com.example.postcast_reactive_mvp.mvp.views.DownloadedView
import com.example.postcast_reactive_mvp.views.viewpods.EmptyViewPod
import com.example.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_download.*
import kotlinx.android.synthetic.main.fragment_home.emptyViewPod


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DownloadFragment : BaseFragment(),DownloadedView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mAdapter : DownloadedListAdapter
    private lateinit var mPresenter: DownloadedPresenter

    private lateinit var mEmptyViewPod : EmptyViewPod

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
        return inflater.inflate(R.layout.fragment_download, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPod()
        setUpRecycler()
        mPresenter.onUiReady(this)
      }

    private fun setUpPresenter(){
        mPresenter = DownloadedPresenterImpl
        mPresenter.initPresenter(this)
    }

    private fun setUpViewPod(){
        mEmptyViewPod = emptyViewPod as EmptyViewPod
        mEmptyViewPod.setEmptyData("","")
        mEmptyViewPod.setDelegate(mPresenter)
    }

    private fun setUpRecycler(){
        mAdapter = DownloadedListAdapter(mPresenter)
        rvDownloadedList.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL,false)
            adapter = mAdapter
            setEmptyView(mEmptyViewPod)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DownloadFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun navigateToDetail() {
        startActivity(activity?.let { PodCastDetailActivity.newIntent(it) })
    }

    override fun showErrorMessage(error: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}
package com.example.postcast_reactive_mvp.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.activities.PodCastDetailActivity
import com.example.postcast_reactive_mvp.adapters.LatestPodCastListAdapter
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.mvp.presenters.HomePresenter
import com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls.HomePresenterImpl
import com.example.postcast_reactive_mvp.mvp.views.HomeView
import com.example.postcast_reactive_mvp.views.viewpods.EmptyViewPod
import com.example.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : BaseFragment(),HomeView{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter : HomePresenter
    private lateinit var mAdapter : LatestPodCastListAdapter

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPod()
        setUpRecycler()
        mPresenter.onUiReady()

    }

    private fun setUpPresenter(){
       // mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter = HomePresenterImpl
        mPresenter.initPresenter(this)
    }

    private fun setUpViewPod(){
        mEmptyViewPod = emptyViewPod as EmptyViewPod
        mEmptyViewPod.setEmptyData("","")
        mEmptyViewPod.setDelegate(mPresenter)
    }

    private fun setUpRecycler(){
        mAdapter = LatestPodCastListAdapter(mPresenter)
        rvLatest.apply {
            layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL,false)
            adapter = mAdapter
            setEmptyView(mEmptyViewPod)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showLatestPodCastList(latestPodCastVORandom: List<RandomPodcastVO>) {
        mAdapter.setData(latestPodCastVORandom)
    }

    override fun navigateToDetailActivity() {
       startActivity(activity?.let { PodCastDetailActivity.newIntent(it) })
    }

    override fun showErrorMessage(error: String) {
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}
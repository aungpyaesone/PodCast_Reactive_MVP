package com.example.postcast_reactive_mvp.fragments

import android.Manifest
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.activities.PodCastDetailActivity
import com.example.postcast_reactive_mvp.adapters.LatestPodCastListAdapter
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.DownloadVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.postcast_reactive_mvp.mvp.presenters.HomePresenter
import com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls.HomePresenterImpl
import com.example.postcast_reactive_mvp.mvp.views.HomeView
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.util.toDownloadVO
import com.example.postcast_reactive_mvp.views.viewpods.EmptyViewPod
import com.example.postcast_reactive_mvp.views.viewpods.ExoPlayerViewPod
import com.example.postcast_reactive_mvp.views.viewpods.MideaPlayerViewPod
import com.example.shared.fragments.BaseFragment
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : BaseFragment(), HomeView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var downloadLink: String = ""
    private var mData: DataVO? = null
    private var downloadId  :Long = 0

    private lateinit var mExoPlayerViewPod : ExoPlayerViewPod

    companion object {
        const val REQUEST_CODE = 100

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private lateinit var mPresenter: HomePresenter
    private lateinit var mAdapter: LatestPodCastListAdapter

    private lateinit var mEmptyViewPod: EmptyViewPod

    private val downloadReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            //Fetching the download id received with the broadcast
            val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID , -1)

            //Checking if the received broadcast is for our enqueued download by matching download id
            if(downloadId == id){
                Toast.makeText(context,"download complete", Toast.LENGTH_SHORT).show()
               mData?.let {

                   mPresenter.saveDownload(it.toDownloadVO())
               }
            }
        }
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPod()
        setUpRecycler()
        init()
        mPresenter.onUiReady(this)

    }

    private fun init() {
        context?.registerReceiver(downloadReceiver,IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpViewPod() {
        mEmptyViewPod = emptyViewPod as EmptyViewPod
        mEmptyViewPod.setEmptyData("", "")
        mEmptyViewPod.setDelegate(mPresenter)

        mExoPlayerViewPod = player_control_view as ExoPlayerViewPod

    }

    private fun setUpRecycler() {
        mAdapter = LatestPodCastListAdapter(mPresenter)
        rvLatest.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
            setEmptyView(mEmptyViewPod)
        }
    }


    // bind up next data list
    override fun bindRandomPodCast(latestPodCastVORandom: DataVO) {
        tvDescription.text = Html.fromHtml(latestPodCastVORandom.description)

        latestPodCastVORandom.audio?.let {link ->
        latestPodCastVORandom.image?.let { image ->
        latestPodCastVORandom.title?.let { title ->
            mExoPlayerViewPod.setData(
                        title,
                        link,
                        image
                    )
                }
            }
        }
    }

    // navigate detail
    override fun navigateToDetailActivity(id: String) {
        startActivity(activity?.let { PodCastDetailActivity.newIntent(it, id) })
    }

    override fun bindLatestPodCastList(latestpodCastList: List<DataVO>) {
        mAdapter.setData(latestpodCastList)
    }

    override fun checkPermission(itemVO: DataVO) {
        mData = itemVO
        when {
            context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            } == PackageManager.PERMISSION_GRANTED -> {
                context?.let {
                    downloadId = mPresenter.download(it, mData!!)
                }
            }
            else -> {
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE
                )
            }
        }
    }

    override fun showErrorMessage(error: String) {
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    context?.let {
                       downloadId = mPresenter.download(it, mData!!)
                    }
                } else {
                    // explain user
                }
                return
            }
            else -> {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        context?.unregisterReceiver(downloadReceiver)
    }

}
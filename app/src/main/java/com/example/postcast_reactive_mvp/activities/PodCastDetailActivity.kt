package com.example.postcast_reactive_mvp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.postcast_reactive_mvp.mvp.presenters.DetailPresenter
import com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls.DetailPresenterImpl
import com.example.postcast_reactive_mvp.mvp.views.DetailView
import com.example.shared.activities.BaseActivity
import com.example.shared.extensions.load
import kotlinx.android.synthetic.main.activity_pod_cast_detail.*

class PodCastDetailActivity : BaseActivity(),DetailView {

    private lateinit var mPresenter: DetailPresenter
    companion object{
        const val PID = "podCastId"
        fun newIntent(context:Context,pid:String): Intent {
            val intent = Intent(context,PodCastDetailActivity::class.java)
            intent.putExtra(PID,pid)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)
        setUpPresenter()

        mPresenter.onUiReady(this,intent.getStringExtra(PID))
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun showDetail(podcastVO: PodcastVO) {
       ivPoster.load(podcastVO.image)
       podCastTitle.text = podcastVO.title
       tvDescription.text = podcastVO.description
    }

    override fun showErrorMessage(error: String) {
       showSnackbar(error)
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }


}
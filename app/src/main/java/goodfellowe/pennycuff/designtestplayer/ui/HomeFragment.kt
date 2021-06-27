package goodfellowe.pennycuff.designtestplayer.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.adapter.HomePagerAdapter
import goodfellowe.pennycuff.designtestplayer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private lateinit var mBinding: FragmentHomeBinding


    private val actionBar: ActionBar?
        get() = appCompatActivity?.supportActionBar


    private val appCompatActivity: AppCompatActivity?
        get() = activity as? AppCompatActivity?

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        initToolBar()
        setHasOptionsMenu(true)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_video_list, menu)
    }


    private fun initToolBar() {
        setSupportActionBar(mBinding.toolbar)
        actionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_drawer_icon)
            title = ""
        }
    }


    private fun setSupportActionBar(toolbar: Toolbar) {
        appCompatActivity?.setSupportActionBar(toolbar)
    }


    private fun loadData() {
        val adapter = HomePagerAdapter(childFragmentManager)
        mBinding.viewpager.adapter = adapter
        mBinding.tabLayout.setupWithViewPager(mBinding.viewpager)

    }


}
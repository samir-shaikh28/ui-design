package goodfellowe.pennycuff.designtestplayer.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.data.VideoList
import goodfellowe.pennycuff.designtestplayer.databinding.FragmentGalleryBinding
import goodfellowe.pennycuff.designtestplayer.recycler.CustomModel
import goodfellowe.pennycuff.designtestplayer.recycler.GenericRecyclerAdapter
import goodfellowe.pennycuff.designtestplayer.recycler.VerticalSpaceItemDecoration
import goodfellowe.pennycuff.designtestplayer.viewModels.RowVideoViewModel


class GalleryFragment : Fragment() {


    private lateinit var mBinding: FragmentGalleryBinding


    private val actionBar: ActionBar?
        get() = appCompatActivity?.supportActionBar


    private val appCompatActivity: AppCompatActivity?
        get() = activity as? AppCompatActivity?

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentGalleryBinding.inflate(inflater, container, false)
        initToolBar()
        setHasOptionsMenu(true)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recycler.layoutManager = LinearLayoutManager(requireContext())
        mBinding.recycler.addItemDecoration(VerticalSpaceItemDecoration(resources.getDimension(R.dimen.margin_1dp).toInt()))
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
        val listOfVideo = mutableListOf<CustomModel>()
        for(i in 0..20) {
            listOfVideo.add(RowVideoViewModel(VideoList()))
        }
        val videoListAdapter = GenericRecyclerAdapter(listOfVideo)
        mBinding.recycler.adapter = videoListAdapter
        videoListAdapter.notifyDataSetChanged()
    }

    companion object {

        @JvmStatic
        fun newInstance() = GalleryFragment()
    }
}
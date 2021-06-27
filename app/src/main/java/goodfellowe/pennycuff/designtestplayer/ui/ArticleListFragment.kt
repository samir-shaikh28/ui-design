package goodfellowe.pennycuff.designtestplayer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import goodfellowe.pennycuff.designtestplayer.ArticleDetailsActivity
import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.data.HomeResponse
import goodfellowe.pennycuff.designtestplayer.databinding.FragmentArticleListBinding
import goodfellowe.pennycuff.designtestplayer.recycler.CustomModel
import goodfellowe.pennycuff.designtestplayer.recycler.GenericRecyclerAdapter
import goodfellowe.pennycuff.designtestplayer.recycler.VerticalSpaceItemDecoration
import goodfellowe.pennycuff.designtestplayer.viewModels.RowArticleViewModel
import goodfellowe.pennycuff.designtestplayer.viewModels.RowScoreSection


class ArticleListFragment : Fragment(), ArticleItemClickListener {


    private lateinit var mBinding: FragmentArticleListBinding


    private val actionBar: ActionBar?
        get() = appCompatActivity?.supportActionBar


    private val appCompatActivity: AppCompatActivity?
        get() = activity as? AppCompatActivity?

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentArticleListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recycler.layoutManager = LinearLayoutManager(requireContext())
        mBinding.recycler.addItemDecoration(
            VerticalSpaceItemDecoration(
                resources.getDimension(R.dimen.margin_1dp).toInt()
            )
        )
        loadData()
    }


    private fun setSupportActionBar(toolbar: Toolbar) {
        appCompatActivity?.setSupportActionBar(toolbar)
    }


    private fun loadData() {
        val listOfArticles = mutableListOf<CustomModel>()
        val homeResponse = HomeResponse()
        listOfArticles.add(RowScoreSection(homeResponse.matchTableList))
        homeResponse.articleList.forEach {
            listOfArticles.add(RowArticleViewModel(it, this@ArticleListFragment))
        }

        val adapter = GenericRecyclerAdapter(listOfArticles)
        mBinding.recycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    companion object {
        fun getInstance() = ArticleListFragment()
    }

    override fun onArticleClick() {
        startActivity(ArticleDetailsActivity.getIntent(requireContext()))
    }
}


interface ArticleItemClickListener {
    fun onArticleClick()
}


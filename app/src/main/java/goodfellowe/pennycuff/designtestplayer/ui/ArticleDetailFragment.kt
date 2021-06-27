package goodfellowe.pennycuff.designtestplayer.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.databinding.FragmentArticleDetailsBinding

class ArticleDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentArticleDetailsBinding

    private val actionBar: ActionBar?
        get() = appCompatActivity?.supportActionBar


    private val appCompatActivity: AppCompatActivity?
        get() = activity as? AppCompatActivity?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_article_details, container, false)
        setHasOptionsMenu(true)
        initToolBar()
        return mBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.article_detail_menu, menu)
    }

    private fun initToolBar() {
        setSupportActionBar(mBinding.toolbar)
        actionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow)
            title = ""
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setSupportActionBar(toolbar: Toolbar) {
        appCompatActivity?.setSupportActionBar(toolbar)
    }


    companion object {
        const val TAG = "ArticleDetailFragment"
    }
}
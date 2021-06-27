package goodfellowe.pennycuff.designtestplayer.viewModels

import android.util.Log
import android.view.View
import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.data.ArticleDataList
import goodfellowe.pennycuff.designtestplayer.recycler.CustomModel
import goodfellowe.pennycuff.designtestplayer.ui.ArticleItemClickListener
import goodfellowe.pennycuff.designtestplayer.ui.ArticleListFragment

class RowArticleViewModel(var articleData: ArticleDataList, var listener: ArticleItemClickListener): CustomModel() {

    override fun getLayoutIdentifier(): Int {
        return R.layout.row_article
    }

    fun openArticle(view: View) {
        listener.onArticleClick()
    }

}
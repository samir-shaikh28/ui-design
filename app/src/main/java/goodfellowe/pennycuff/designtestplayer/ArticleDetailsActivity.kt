package goodfellowe.pennycuff.designtestplayer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import goodfellowe.pennycuff.designtestplayer.databinding.ActivityArticleDetailsBinding
import goodfellowe.pennycuff.designtestplayer.ui.ArticleDetailFragment

class ArticleDetailsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityArticleDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_article_details)
        setUpArticleDetailFragment()
    }

    private fun setUpArticleDetailFragment() {
        supportFragmentManager.beginTransaction().add(R.id.container, ArticleDetailFragment())
            .commit()
    }

    companion object {

        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, ArticleDetailsActivity::class.java)
        }
    }
}
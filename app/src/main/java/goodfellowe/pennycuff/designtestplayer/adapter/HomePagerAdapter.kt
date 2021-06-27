package goodfellowe.pennycuff.designtestplayer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import goodfellowe.pennycuff.designtestplayer.ui.ArticleListFragment

class HomePagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var tabs = arrayOf("ALL", "IPL", "CRICKET", "FOOTBALL")

    override fun getItem(position: Int): Fragment {
        return ArticleListFragment.getInstance()
    }

    override fun getCount(): Int {
        return tabs.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence {
        var title = ""
        tabs.let { tabs ->
            tabs[position].let { name ->
                title = name
            }
        }
        return title
    }
}
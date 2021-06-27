package goodfellowe.pennycuff.designtestplayer.viewModels

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.data.MatchTables
import goodfellowe.pennycuff.designtestplayer.recycler.CustomModel

class ItemMatchCard(var matchData: MatchTables): CustomModel() {


    override fun getLayoutIdentifier(): Int {
        return R.layout.row_match_card
    }

    companion object {

        @JvmStatic
        @BindingAdapter("setSelected")
        fun setSelected(v: AppCompatTextView, model: ItemMatchCard) {
            v.isSelected = true
        }
    }
}
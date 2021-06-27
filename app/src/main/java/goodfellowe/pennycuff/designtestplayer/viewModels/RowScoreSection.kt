package goodfellowe.pennycuff.designtestplayer.viewModels

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.data.MatchTables
import goodfellowe.pennycuff.designtestplayer.recycler.CustomModel
import goodfellowe.pennycuff.designtestplayer.recycler.GenericRecyclerAdapter
import goodfellowe.pennycuff.designtestplayer.recycler.HorizontalSpaceItemDecoration

class RowScoreSection(var matchList: List<MatchTables>) : CustomModel() {

    var isViewInitialized = false

    override fun getLayoutIdentifier(): Int {
        return R.layout.row_match_score_section
    }

    companion object {

        @JvmStatic
        @BindingAdapter("setData")
        fun setData(recyclerView: RecyclerView, model: RowScoreSection) {
            val context = recyclerView.context
            if (!model.isViewInitialized) {
                val listOfScoreCard = mutableListOf<CustomModel>()
                recyclerView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                recyclerView.addItemDecoration(
                    HorizontalSpaceItemDecoration(
                        context.resources.getDimension(
                            R.dimen.padding_12dp
                        ).toInt()
                    )
                )
                model.isViewInitialized = true

                model.matchList.forEach {
                    listOfScoreCard.add(ItemMatchCard(it))
                }
                val scoreListAdapter = GenericRecyclerAdapter(listOfScoreCard)
                recyclerView.adapter = scoreListAdapter
                scoreListAdapter.notifyDataSetChanged()


            }

        }
    }
}
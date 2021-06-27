package goodfellowe.pennycuff.designtestplayer.viewModels

import goodfellowe.pennycuff.designtestplayer.R
import goodfellowe.pennycuff.designtestplayer.data.VideoList
import goodfellowe.pennycuff.designtestplayer.data.VideoListResponse
import goodfellowe.pennycuff.designtestplayer.recycler.CustomModel

class RowVideoViewModel(var videoItemData: VideoList) : CustomModel() {

    override fun getLayoutIdentifier(): Int {
        return R.layout.row_video_card
    }
}
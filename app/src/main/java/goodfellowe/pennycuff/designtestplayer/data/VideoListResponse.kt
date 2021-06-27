package goodfellowe.pennycuff.designtestplayer.data

data class VideoListResponse(
    var videoList: List<VideoList> = arrayListOf(
        VideoList(),
        VideoList(), VideoList(),
        VideoList(), VideoList(),
        VideoList(), VideoList(),
        VideoList(),
        VideoList()
    )
)


data class VideoList(
    val title: String = "IPL 2021: 5 Players to watch out for as PBKS take on KKR",
    val time: String = "3 hours ago",
    val duration: String = "11:53"
)
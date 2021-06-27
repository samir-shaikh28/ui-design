package goodfellowe.pennycuff.designtestplayer.data


data class HomeResponse(
    var matchTableList: List<MatchTables> = arrayListOf(
        MatchTables(),
        MatchTables(),
        MatchTables()
    ),
    var articleList: List<ArticleDataList> = arrayListOf(
        ArticleDataList(),
        ArticleDataList(),
        ArticleDataList()
    )
)

data class MatchTables(
    val firstTeamCode: String = "SAL",
    val secondTeamCode: String = "VAL",
    val firstTeamScore: String = "111/6 (10 ov)",
    val secondTeamScore: String = "*54/2 (8.3 ov)"
)

data class ArticleDataList(
    val title: String = "IPL 2021: 5 Players to watch out for as PBKS take on KKR",
    val time: String = "3 minutes ago"
)
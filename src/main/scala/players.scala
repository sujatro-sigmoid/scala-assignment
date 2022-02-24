class players(var year: Int,
              var playerName: String,
              var country: String,
              var matches: Int,
              var runs: Int,
              var wickets: Int)
object players {

  def main(args: Array[String]): Unit = {
    val playerList = Array(
      new players(2010, "Abc", "India", 30, 2000, 101),
      new players(2011, "Bcd", "India", 31, 3000, 77),
      new players(2012, "Cde", "Pakistan", 32, 4000, 88),
      new players(2013, "Efg", "India", 33, 1000, 99),
      new players(2014, "Fgh", "Australia", 34, 5000, 90),
      new players(2015, "Ijk", "England", 35, 1500, 78),
      new players(2016, "Jkl", "Bangladesh", 36, 3000, 67)
    )

    println("Player with the best highest run scored")
    val playersHighestRun = playerList.sortBy(obj => obj.runs).reverse
    println(playersHighestRun.head.playerName)

    println("Top 5 players by run scored")
    for(player <- playersHighestRun.take(5))
      println(player.playerName)

    println("Top 5 players by wicket taken")
    val playersHighestWickets = playerList.sortBy(obj => obj.wickets).reverse
    for (player <- playersHighestWickets.take(5)) {
      println(player.playerName)
    }

    println("Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored")
    val playersPerformanceList = playerList.sortBy(obj => obj.wickets*5 + obj.runs*0.05).reverse
    for (player <- playersPerformanceList) {
      println(player.playerName)
    }
  }
}

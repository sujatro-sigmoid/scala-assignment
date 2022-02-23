class players(var year: Int,
                       var playerName: String,
                       var country: String,
                       var matches: Int,
                       var runs: Int,
                       var wickets: Int) {}

object players {
  def Desc[T: Ordering] = implicitly[Ordering[T]].reverse;

  def push_back(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int): players = {
    return new players(year, playerName, country, matches, runs, wickets)
  }

  def main(args: Array[String]): Unit = {
    var playerList = List(
      push_back(2010, "Abc", "India", 30, 2000, 99),
      push_back(2011, "Bcd", "India", 31, 3000, 77),
      push_back(2012, "Cde", "Pakistan", 32, 4000, 88),
      push_back(2013, "Efg", "India", 33, 1000, 99),
      push_back(2014, "Fgh", "Australia", 34, 5000, 88),
      push_back(2015, "Ijk", "England", 35, 1500, 78),
      push_back(2016, "Jkl", "Bangladesh", 36, 3000, 67)
    )

    println("Player with the best highest run scored");
    val playersHighestRun = playerList.sortBy(x => x.runs).reverse
    println(playersHighestRun.head.playerName)

    println("Top 5 players by run scored")
    for(player <- playersHighestRun.take(5))
      println(player.playerName)

    println("Top 5 players by wicket taken")
    val playersHighestWickets = playerList.sortBy(x => x.wickets).reverse
    for (player <- playersHighestWickets.take(5)) {
      println(player.playerName)
    }

    println("Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored")
    playerList = playerList.sortBy(x => x.wickets * 5).sortBy(x => x.runs * 0.05).reverse
    var counter: Int = 1
    for (player <- playerList) {
      println(s"Rank $counter: " + player.playerName)
      counter += 1;
    }
  }
}

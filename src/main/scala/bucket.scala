object bucket{
  def truncateAt(x: Double , p:Int): Double = {
    val s = math.pow(10, p)
    (x*s).toInt / s
  }

  def functionBucketise(num: Double):(Double,Double)={
    val v0 = (num/0.05).floor * 0.05; // initial value
    val v1 = (num/0.05).floor * 0.05 + 0.049; // final value
    return (truncateAt(v0, 3), truncateAt(v1, 3))
  }

  def main(args: Array[String]) :Unit={
    val nums = Array(12.05, 12.03, 10.33, 11.45, 13.50)
    for(n <- nums){
      println(s"The bucket for value $n is \t ${functionBucketise(n)}")
    }
  }
}
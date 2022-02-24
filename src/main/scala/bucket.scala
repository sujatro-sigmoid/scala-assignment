object bucket{
  def getBucket(num: Double): (Double, Double) ={
    val v0 = (num/0.05).toInt * 0.05; // initial value
    val v1 = (num/0.05).toInt * 0.05 + 0.049; // final value
    (BigDecimal(v0).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble,
      BigDecimal(v1).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }


  def main(args: Array[String]) :Unit={
    val nums = Array(12.05, 12.03, 10.33, 11.45, 13.50, 67.90, 999.999, 1234.9999, 00.8992)
    for(n <- nums){
      println(s"The bucket for value $n is \t ${getBucket(n)}")
    }
  }
}
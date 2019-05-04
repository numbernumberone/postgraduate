package leetcode

object romanToInt {



  def main(args: Array[String]): Unit = {
    println (romanToInt("MCMXCIV"))
//    var z = new Array[Int](10)

  }



  def romanToInt(s:String) : Int = {
    var value = 0
    val sMap=scala.collection.mutable.Map[Char,Int]()
    var z = new Array[Int](s.length)
    sMap +=('I' -> 1)
    sMap +=('V' -> 5)
    sMap +=('X' -> 10)
    sMap +=('L' -> 50)
    sMap +=('C' -> 100)
    sMap +=('D' -> 500)
    sMap +=('M' -> 1000)
    for(i <- 0 until(s.length)){
      if ((i +1 ) < s.length && sMap(s.charAt(i)) < sMap(s.charAt(i +1))){
         value += (sMap(s.charAt(i+1))- sMap(s.charAt(i)))
        z(i+1) = 1
      } else if (!(z(i) == 0)){

      }
      else{
        value += sMap(s.charAt(i))
      }
    }
    return value
  }
}

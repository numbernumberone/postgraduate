package leetcode

object romanToInt {



  def main(args: Array[String]): Unit = {
    println (romanToInt("MCMXCIV"))
//    var z = new Array[Int](10)

  }
/** object Solution {
    def romanToInt(s: String): Int = {
      val ss = s.replace("IV","IIII")
                .replace("IX","VIIII")
                .replace("XL","XXXX")
                .replace("XC","LXXXX")
                .replace("CD","CCCC")
                .replace("CM","DCCCC")
      
      ss.foldLeft(0) {
        case (i,c) if c == 'I' => i+1
        case (i,c) if c == 'V' => i+5
        case (i,c) if c == 'X' => i+10
        case (i,c) if c == 'L' => i+50
        case (i,c) if c == 'C' => i+100
        case (i,c) if c == 'D' => i+500
        case (i,c) if c == 'M' => i+1000
        case (i,_) => i+0
      }
    }
}
**/

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

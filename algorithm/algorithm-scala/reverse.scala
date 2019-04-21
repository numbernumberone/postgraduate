package leetcodeinscala

object reverse {


  def reverse(x: Int): Int ={
    var rev = 0
    var value = x
    while  (value != 0 ){
      val pop = value % 10
      value= value/10
      if (rev > Int.MaxValue/10 || (rev == Int.MaxValue /10 && pop > 7))
        return 0
      if (rev < Int.MinValue/10 || (rev == Int.MinValue /10 && pop < -8))
        return 0
      rev = rev * 10 + pop
    }
    return rev
  }
  def main(args: Array[String]): Unit = {
    println(reverse(1234))
  }

}

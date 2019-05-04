package leetcode

object isAnagram {

  def main(args: Array[String]): Unit = {
    val s="dgqztusjuu"
    val t="dqugjzutsu"
    println(isAnagram(s,t))


  }
//  def isAnagram(s: String, t: String): Boolean = {
//    val sMap=scala.collection.mutable.Map[Char,Int]()
//    val tMap=scala.collection.mutable.Map[Char,Int]()
//    s.foreach(c=>sMap(c)=sMap.getOrElseUpdate(c,1)+1)
//    t.foreach(c=>tMap(c)=tMap.getOrElseUpdate(c,1)+1)
//    println(sMap)
//    println(tMap)
//    sMap.equals(tMap)
//  }
  def isAnagram(s: String, t: String): Boolean ={
    val recorder = (1 to 26).foldLeft(Array[Int]())((re, _) => re :+ 0)

    s.foreach { c =>
      val p: Int = c - 'a'
      val value = recorder(p)
      recorder.update(p, value + 1)
    }

    t.foreach{ c =>
      val p: Int = c - 'a'
      val value = recorder(p)
      recorder.update(p, value - 1)
    }

    !recorder.exists(_ != 0)

  }


}

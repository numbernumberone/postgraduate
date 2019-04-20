package leetcodeinscala

import scala.collection.mutable


/**
  * 1 空间换时间，使用hash表避免使用两层for循环嵌套。
  * 2 不许要定死，可以把value当作是map的key
  * 3 一次循环可以想办法尽量多做一些事情
  * */
object twoSum {

  /**
    * author: black joker
    * 暴力法
    * */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for(i <- 0 until(nums.length)){
      for(j <- i+1 until(nums.length)){
        if ((nums(i)+nums(j))==target){
        return  Array(i,j)
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution")
  }
  /**
    * author black joker
    * hash table
    *
    * scala have option if ruturn some
    * so that have value you need use .get
    * if return none so that no value
    * */
  def twoSumHashTable(nums: Array[Int], target: Int): Array[Int] = {
    val map = new mutable.HashMap[Int,Int]()
    for(i <- 0 until(nums.length)){
      map.put(nums(i),i)
    }
    for(i1 <- 0 to nums.length -1 ){
      val complement = target - nums(i1)
      if(map.contains(complement) && map.get(complement) != i1 ) {
        val ii = map.get(complement)
        return Array(i1,ii.get)
      }
    }

  }
  /**
    * author black joker
    *
    * */


  def twoSumHashTableOneForeach(nums: Array[Int], target: Int): Array[Int] = {
    val map = new mutable.HashMap[Int,Int]()
    for(i <- 0 until(nums.length)){
      val complement: Int = target - nums(i)
      if (map.contains(complement)) {
        return Array(map.get(complement).get, i)
      }


    }
    throw new IllegalArgumentException("No two sum solution")
  }


  def main(args: Array[String]): Unit = {
    var myList = Array(1, 2, 13, 5,4)
    println(twoSumHashTable(myList,5))

  }
}
//var numbers = new mutable.HashSet[Int]
//for(i <- 0 until(nums.length)){
//  for(j <- i+1 until(nums.length)){
//  if ((nums(i)+nums(j))==target){
//  numbers.add(i)
//  numbers.add(j)
//}
//}
//}
//  return numbers.toArray
//}
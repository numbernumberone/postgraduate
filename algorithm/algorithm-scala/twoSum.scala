package leetcodeinscala

import scala.collection.mutable


object twoSum {

  /**
    * author: black joker
    * 暴力法
    * */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var numbers = new mutable.HashSet[Int]
    for(i <- 0 until(nums.length)){
      for(j <- i+1 until(nums.length)){
        if ((nums(i)+nums(j))==target){
        return  Array(i,j)
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution")
  }

  def twoSum1(): Unit ={

  }


  def main(args: Array[String]): Unit = {
    var myList = Array(1, 2, 13, 5,4)
    println(twoSum(myList,5))

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
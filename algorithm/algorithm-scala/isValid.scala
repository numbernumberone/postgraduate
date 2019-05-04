package leetcode

import scala.annotation.tailrec
import scala.collection.mutable

object isValid {
/** 有效括号
*/
  def main(args: Array[String]): Unit = {

    println(isValid("((({)}))"))

  }


  def isValid(s : String): Unit ={

    @tailrec
    def checkValid(start: Int, toMatch: List[Char]): Boolean = {
      if (start == s.length && toMatch.isEmpty) {
        true
      } else if (start >= s.length) false else {
        s(start) match {
          case '(' =>
            checkValid(start + 1, '(' :: toMatch)
          case '{' =>
            checkValid(start + 1, '{' :: toMatch)
          case '[' =>
            checkValid(start + 1, '[' :: toMatch)
          case ')' =>
            toMatch match {
              case value :: tail if value == '(' =>
                checkValid(start + 1, tail)
              case _ =>
                false
            }
          case '}' =>
            toMatch match {
              case value :: tail if value == '{' =>
                checkValid(start + 1, tail)
              case _ =>
                false
            }
          case ']' =>
            toMatch match {
              case value :: tail if value == '[' =>
                checkValid(start + 1, tail)
              case _ =>
                false
            }
          case _ =>
            checkValid(start + 1, toMatch)
        }
      }
    }

    checkValid(0, Nil)
  }




}

package org.Hongyao.ScalaTutorial.ListSample

/**
  * Created by hone on 12/20/2015.
  */
object ListTest {
  def main(args:Array[String]):Unit= {
    val inputList = List(1,2,3,4,5)
    val inputList2 = List(6,7,8,9,10)
    val listClass = new ListMethods
    val outputList = listClass.append(inputList, inputList2)
    println(outputList)

    println(List(List(1,2), List(3,4), List(), List(5,6,7)).flatMap(x=>x))
  }
}

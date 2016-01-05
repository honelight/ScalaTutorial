package org.Hongyao.ScalaTutorial.MergeSort

/**
  * Created by hone on 12/20/2015.
  */
object MergeSortTest {
  def main(args:Array[String]):Unit={
    val inputList:List[Int]=List(1,5,4,7,6,0,2,9,8,11,92,23,32,21)
    val outputMethods = new MergeSort
    println(outputMethods.mergeSort(inputList))
  }
}

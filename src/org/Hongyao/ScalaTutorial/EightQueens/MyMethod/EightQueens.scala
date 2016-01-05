package org.Hongyao.ScalaTutorial.EightQueens.MyMethod

/**
  * Created by hone on 12/24/2015.
  */
class EightQueens(N:Int) {
  private val matrixSize = N
  private var newMatrix = Array.ofDim[Int](matrixSize, matrixSize)
  private var returnList = List[Array[Array[Int]]]()

  def allSolutions(index:Int):Unit={
    if(index==matrixSize){
      for(i<- 0 until matrixSize){
        for(j<-0 until matrixSize) {
          print(newMatrix(i)(j))
        }
        println()
      }
      println()
    }
    else {
      for (i <- 0 until N) {
        if (check(i, index)) {
          newMatrix(i)(index) = 1
          allSolutions(index + 1)
        }
        newMatrix(i)(index) = 0
      }
    }
  }

  private def check(i:Int, index:Int):Boolean={
    for(j<-0 to index){
      if(newMatrix(i)(j)==1) {
        return false
      }
    }
    var vertical = i-1; var horizontal = index-1
    while(vertical>=0 && horizontal >=0){
      if(newMatrix(vertical)(horizontal)==1){
        return false
      }
      vertical-=1
      horizontal-=1
    }
    return true
  }
}

object Test{
  def main(args:Array[String]): Unit ={
    val testObject = new EightQueens(8)
    testObject.allSolutions(0)
  }
}

package org.Hongyao.Coursera.ScalaBasic.Chapter6.Secton2

/**
  * Created by hone on 1/7/2016.
  */
object Pairs {
  def getParis: Unit ={
    val n=7
    val output = (1 until n) flatMap (i =>
    {(1 until n) map {
      (j=>(i,j))
    }})
    println(output)
  }
  def scalaProduct(xs:List[Double], ys:List[Double]):Double={
    if(xs.length!=ys.length) throw error("Two list have different length, can't calculate result")
    val output =(for((x,y)<-(xs.zip(ys)))yield{x*y}).sum
    return output
  }
}


object Section2Test{
  def main(args:Array[String]): Unit ={
    val x1=List(1,2,3)
    val x2=List(4,5,6)
    println(x1,x2)

    val newSeq = Seq(1,2,3,5,4)
    println(newSeq)
  }
}

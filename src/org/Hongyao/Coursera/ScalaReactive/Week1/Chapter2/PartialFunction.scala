package org.Hongyao.Coursera.ScalaReactive.Week1.Chapter2

/**
  * Created by hone on 1/13/2016.
  */
object PartialFunction {
  def main(args:Array[String]): Unit ={
    println("welcom to the scala worksheet")

    val f:String=>String = {case "ping" => "pong"}

    f("ping")
  }
}

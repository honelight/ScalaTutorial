package org.Hongyao.ScalaTutorial.Actors

import scala.actors._

/**
  * Created by hone on 1/12/2016.
  */
object MoreActors {

  def main(args:Array[String]): Unit ={
//    val actorsGroup:Array[Actor]=Array(FirstActor, SecondActor, ThirdActor, FourthActor)
//    for(t<-actorsGroup){
//      t.start()
//    }
    //FirstActor.start()
    FirstActor ! 22
    FirstActor ! "here"

  }
}

object FirstActor extends Actor{
  override def act(): Unit = {
    loop {
      react {
        case x => {
          println(x)
        }
      }
    }
  }


}
object SecondActor extends Actor{
  override def act(): Unit = {
    for(t<-1 to 6) {
      println("second actor")
      Thread.sleep(1000)
    }
  }

  def recieve: Unit ={

  }
}
object ThirdActor extends Actor{
  override def act(): Unit = {
    for(t<-1 to 6) {
      println("third actor")
      Thread.sleep(1000)
    }
  }
}
object FourthActor extends Actor{
  override def act(): Unit = {
    for(t<-1 to 6) {
      println("fourth actor")
      Thread.sleep(1000)
    }
  }
}





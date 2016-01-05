package org.Hongyao.ScalaTutorial.Actors

import scala.actors.Actor
import scala.actors.Actor._

/**
  * Created by hone on 12/30/2015.
  */
object SillyActor{
  val sillyActor2 = actor{
    def emoteLater(): Unit ={
      val mainActor=self
      actor{
        Thread.sleep(10000)
        mainActor ! "Emote"
      }
    }
    var emoted = 0
    emoteLater()

    loop{
      react{
        case "Emote"=>
          println("I'm acting!")
          emoted+=1
          if(emoted<5)
            emoteLater()
        case msg=>
          println("Received "+msg)
      }
    }
  }
}

object testObject {
  def main(args:Array[String]): Unit ={
    SillyActor.sillyActor2 ! "Emote"
    SillyActor.sillyActor2 ! "hi"
    SillyActor.sillyActor2 ! "look at"
    SillyActor.sillyActor2 ! "there"
  }
}

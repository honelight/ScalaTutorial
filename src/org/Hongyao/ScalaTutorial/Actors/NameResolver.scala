package org.Hongyao.ScalaTutorial.Actors

import java.net

import scala.actors.Actor
import java.net._

case class LookupIp(name:String, respondTo:Actor)
case class LookupResult(name:String, address:Option[InetAddress])
/**
  * Created by hone on 12/30/2015.
  */
object NameResolver extends Actor{
  override def act(): Unit = {
    loop{
      react{
        case LookupIp(name, actor) =>{
          actor ! LookupResult(name,getIp(name))
        }
      }
    }
  }
  def getIp(name:String):Option[InetAddress]={
    try{
      Some(InetAddress.getByName(name))
    }
    catch{
      case _:net.UnknownHostException=>None
    }
  }
}

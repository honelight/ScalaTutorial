package org.Hongyao.Coursera.ScalaReactive.Week1.Chapter2

/**
  * Created by hone on 1/13/2016.
  */

abstract class JSON
case class JSeq(elems:List[JSON]) extends JSON
case class JObj (bindings: Map[String, JSON]) extends JSON
case class JNum(num:Double) extends JSON
case class JStr(str:String) extends JSON
case class JBool(b:Boolean) extends JSON
case object JNull extends JSON

class JsonScala {
  def show(json: JSON):String = json match{
    case JSeq(elems)=>{
      return "["+((elems.map(x=>show(x))).mkString(","))+"]"
    }
    case JObj(bindings)=>{
      val assocs = bindings.map{
        case (key,value)=>"\""+key+"\":"+ show(value)
      }
      return "{"+(assocs.mkString(", "))+"}"
    }
    case JNum(num)=>{return num.toString}
    case JStr(str)=>{return str}
    case JBool(b)=>{return b.toString}
    case JNull=>{return "Null"}
  }
}

object TestJson{
  val data = JObj(Map(
  "firstName"->JStr("John"),
  "lastName"->JStr("Smith"),
  "address"->JObj(Map(
      "streetAddress"->JStr("21 2nd Street"),
      "State"->JStr("NY"),
      "postalCode"->JNum(10021)
    )),
  "phoneNumbers"->JSeq(List(
    JObj(Map(
      "type"->JStr("Home"),
      "number"->JStr("212 555-1234")
    )),
    JObj(Map(
      "type"->JStr("fax"),
      "number"->JStr("646 555-4567")
    ))
  ))
  ))
  def main(args:Array[String]): Unit ={
    val input = new JsonScala
    println(input.show(data))
  }
}

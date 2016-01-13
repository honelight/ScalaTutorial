package org.Hongyao.Coursera.ScalaBasic.Section1

import scala.collection.mutable.ListBuffer

/**
  * Created by hone on 1/2/2016.
  */
class RemoveNthList {
  def removeNthList[T](x:List[T], index:Int):List[T]= (x,index) match{
    case (y::ys,0)=> ys
    case (Nil,_)=>throw error("list too short")
    case (y::ys, q) if(q>0) =>{
      return y::removeNthList(ys,q-1)
    }
  }

  def merge(x:List[Int], y:List[Int]):List[Int]= (x,y) match{
    case(Nil, _)=>y
    case(_, Nil)=>x
    case(x1::xs, y1::ys)=>{
      if(x1>y1){
        return List(y1,x1) ++ merge(xs,ys)
      }
      else{
        return List(x1,y1) ++ merge(xs,ys)
      }
    }
  }

  def isPrime(x:Int):Boolean={
    val output = 2 to math.sqrt(x).toInt
    return output.forall(q=>x%q!=0)
  }
}

object RemoveNthListTest{
  def main(args:Array[String]): Unit ={
    val input = new RemoveNthList
    for(x<- 2 to 10){print(input.isPrime(x)+" ")}
  }
}

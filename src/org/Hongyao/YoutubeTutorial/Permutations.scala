package org.Hongyao.YoutubeTutorial

import scala.collection.mutable.ListBuffer

/**
  * Created by hone on 2/4/2016.
  */
class Permutations {
  def permutation(lst:List[Int]):List[List[Int]] = lst match{
    case Nil=>{return Nil;}
    case List(a)=>{return List(lst);}
    case _ =>{
      var output:Set[List[Int]]=Set[List[Int]]();
      var exceptList:List[Int]=List();
      for(x<-0 until lst.length) yield{
        val (before, rest) = lst.splitAt(x);
        exceptList=before++rest.tail;
        for(y<-this.permutation(exceptList)){
          output+=(lst(x)::y);
        }
      }
      return output.toList;
    }
  }
}

object PermutationTest{
  def main(args:Array[String]):Unit={
    val input = new Permutations;
    for(resultList<-input.permutation(List(5,2,3,4))){
      println(resultList);
    }
  }
}

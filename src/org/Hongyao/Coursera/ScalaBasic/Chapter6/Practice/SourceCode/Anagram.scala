package org.Hongyao.Coursera.ScalaBasic.Chapter6.Practice.SourceCode

import scala.collection.immutable.Stream.Empty
import scala.collection.mutable.ListBuffer

/**
  * Created by hone on 1/4/2016.
  */


class Anagram {
  type Word = String
  type Sentence = List[Word]
  type Occurrences = List[(Char,Int)]
  val dictionary = DictionaryUtility.loadDictionary
  lazy val wordMap: Map[Occurrences, List[Word]] = dictionary.groupBy((words:Word)=>wordOccurrences(words))

  def wordOccurrences(w:Word):Occurrences={
    val inputMap = w.groupBy((char:Char)=>char)
    val output = for(x<-inputMap) yield {
      (x._1, x._2.length)
    }
    return output.toList
  }

  def sentenceOccurrences(s: Sentence): Occurrences={
    var input:String = ""
    for(x<-s){
      input++=s.toString
    }
    return this.wordOccurrences(input)
  }

  def wordAnagrams(word: Word): List[Word]={
    return wordMap(this.wordOccurrences(word))
  }

  def generators(inputList:List[List[Int]]):List[List[Int]]= inputList match{
    case Nil=>{return Nil}

    case x::xs=>{
      val outputList = for(q<-x)yield {
        if(q==0){
          Nil::generators(xs)
        }
        else{
          q::(generators(xs))
        }
      }
      return outputList.asInstanceOf[List[List[Int]]]
    }
  }

  def combinations(occurrences: Occurrences): List[Occurrences] =
    (occurrences foldRight List[Occurrences](Nil)) { case ((ch,tm), acc) => {
      acc ++ ( for { comb <- acc; n <- 1 to tm } yield (ch, n) :: comb )
    } }

//  def subtract(x: Occurrences, y: Occurrences): Occurrences={
//
//  }

//  def combinations(occurrences: Occurrences): List[Occurrences]={
//    var inputList = Vector[(Char, List[Int])]()
//    for(x<-occurrences){
//     inputList:+=(x._1, List(1 to x._2))
//    }
//
//    def generator(input:List[(Char, List[Int])]):List[List[Occurrences]]= inputList match{
//      case Nil=>{return Nil}
//      case head::xs=>{
//
//      }
//
//    }
//
//  }
}

object test{
  def main(args:Array[String]): Unit ={
    val input = new Anagram
    //println(input.wordOccurrences("aaabbbccc"))
    val inputList = List(List(1),List(1,2))
    println(input.generators(inputList))

  }
}

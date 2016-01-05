package org.Hongyao.Coursera.Chapter1.ChapterOnePractice

import scala.collection.mutable

/**
  * Created by hone on 12/30/2015.
  */
class Exercise2 {
  def balance(chars: List[Char]): Boolean={
    val inputStack:mutable.Stack[Char] = new mutable.Stack[Char]()
    for(x<-chars) x match {
      case(')')=>{
        if(inputStack.isEmpty)
          return false
        else{
          val output=inputStack.pop()
          if(output==')')
            return false
        }
      }
      case('(')=>{
        inputStack.push(x)
      }
      case _ =>{}
    }
    return inputStack.isEmpty
  }
}

object Parentheses{
  def main(args:Array[String]): Unit ={
    val testClass=new Exercise2
    val inputMessage="())("
    println(testClass.balance(inputMessage.toCharArray.toList))
  }
}
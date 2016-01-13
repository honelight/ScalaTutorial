package org.Hongyao.Coursera.ScalaReactive.Week1.Chapter4

import java.util.Random

/**
  * Created by hone on 1/13/2016.
  */

trait Generator[+T]{

  self=>

  def generate:T

  def map[S](f:T=>S): Generator[S]={
    return new Generator[S]{
      def generate = f(self.generate)
    }
  }

  def flatMap[S](f: T=>Generator[S]):Generator[S] = {
    return new Generator[S]{
      def generate= f(self.generate).generate
    }
  }
}


object RandomGenerator {
  val integers = new Generator[Int]{
    val rand = new Random
    def generate = rand.nextInt
  }

  val booleans = new Generator[Boolean] {
    def generate = integers.generate>0
  }

  val newBooleans = for(x<-integers) yield x > 0

  val pairs = new Generator[(Int, Int)] {
    def generate =(integers.generate, integers.generate)
  }
}

trait Tree

case class Inner(left:Tree, right:Tree) extends Tree
case class Leaf(x:Int) extends Tree

object TreesGenerator{
  def leafs:Generator[Leaf] = for{
    x<-RandomGenerator.integers
  }yield Leaf(x)

  def inners:Generator[Inner] = for{
    l<-trees; r<-trees
  }yield Inner(l,r)

  def trees:Generator[Tree] = for{
    isLeaf<-RandomGenerator.booleans
    tree <- if(isLeaf) leafs else inners
  }yield tree
}

object testcase{
  def main(args:Array[String]): Unit ={
    println(TreesGenerator.trees.generate)
  }
}

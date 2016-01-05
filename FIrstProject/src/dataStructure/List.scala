package dataStructure

import scala.collection.TraversableOnce

sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]


/**
  * Created by hone on 12/8/2015.
  */
object List {

  def foldRight[A,B](as: List[A], z:B)(f:(A,B)=>B):B= as match{
    case Nil
      =>z
    case Cons(x, xs)
      =>f(x, foldRight(xs, z)(f))
  }

  def foldRightViaFoldLeft1[A,B](as: List[A], z:B)(f:(A,B)=>B):B={
    foldLeft(reverse(as), z)((b,a)=>f(a,b))
  }

  @annotation.tailrec
  def foldLeft[A,B](as: List[A], z:B)(f:(B,A)=>B):B=as match{
    case Nil=>z
    case Cons(x, xs)
      =>foldLeft(xs, f(z,x))(f)
  }

  def addList(as: List[Int], bs:List[Int]):List[Int]=(as,bs) match{
    case(Nil,_)=>Nil
    case(Cons(a1,a1s), Cons(bx, b1s))
      =>Cons(a1+bx,addList(a1s, b1s))
  }

  def zipWith[A](as:List[A], bs:List[A])(f:(A, A)=>A):List[A]= (as, bs) match{
    case(Nil, _)=>Nil
    case(Cons(a1, a1s), Cons(b1, b1s))
      =>Cons(f(a1,b1),zipWith(a1s, b1s)(f))
  }

  def flatMapFiler[A](as :List[A])(f:A=>Boolean):List[A]={
    flatMap(as)(a=>{if(f(a)) List(a) else Nil})
  }

  def filter[A](as:List[A])(f:A=>Boolean):List[A]={
    foldRight(as, List[A]())((x,y)=>{
      if(f(x))
        Cons(x,y)
      else
        y
    })
  }

  def removeOdd[A](x:A): Boolean =
  {
    if(x.asInstanceOf[Int]%2==1)
      false
    else
      true
  }

  def flatMap[A,B](as: List[A])(f:A=>List[B]):List[B]={
    foldRight(as, List[B]())((x,y)=>(append(f(x),y)))
  }

  def changeList[A,B](as:A):List[B]={
    List[B](as.asInstanceOf[B], as.asInstanceOf[B])
  }

  def map[A,B](as:List[A])(f:A=>B):List[B]={
    foldRight(as, List[B]())((x,y)=>Cons(f(x),y))
  }

  def convertString(as: List[Double]):List[String]={
    foldLeft(reverse(as), List[String]())((t,h)=>Cons(h.toString, t))
  }

  def convertString2(as:List[Double]):List[String]= as match{
    case Nil=>Nil
    case Cons(x, xs)
      =>Cons(x.toString, convertString2(xs))
  }

  def addOne(as: List[Int]): List[Int]={
    foldLeft(reverse(as), List[Int]())((y:List[Int],x:Int)=>Cons(x+1,y))
  }

  def addOne2(as: List[Int]): List[Int]= as match{
    case Nil=>Nil
    case Cons(x, xs)
      =>Cons(x+1, addOne(xs))

  }

  def concatenate[A](z:List[List[A]]):List[A]={
    foldRight(z,List[A]())((x,y)=>append(x,y))
  }

  def appendLeft[A](ds: List[A], xs: List[A]):List[A]={
    foldLeft(reverse(ds), xs)((y:List[A], x:A)=>(Cons(x,y)))
  }

  def reverse[A](ds: List[A]): List[A] = {
    foldLeft(ds, Nil:List[A])((acc,h)=>Cons(h,acc))
  }

  def sum(ints: List[Int]): Int ={
    foldRight(ints, 0)((x:Int, y:Int)=>x + y)
  }

  def sum2(ints: List[Int]):Int={
    foldLeft(ints, 0)((x:Int, y:Int)=>x+y)
  }

  def product(ds: List[Double]) :Double = {
    foldRight(ds, 1.0)((x:Double, y:Double)=>x*y)
  }

  def product2(ds: List[Double]) :Double = {
    foldLeft(ds, 1.0)((x:Double, y:Double)=>x*y)
  }

  def length[A](ds: List[A]) :Int={
//    foldRight(ds, 0, (_,acc:Int)=>acc+1)
    foldRight(ds, 0)((x:A, count:Int)=>(count+1))

  }


  def append[A] (ds: List[A], xs: List[A]):List[A]={
    foldRight(ds, xs)((x:A,y:List[A])=>Cons(x,y))
  }

  def apply[A](as: A*):List[A]={
    if(as.isEmpty) Nil
    else Cons(as.head, apply(as.tail:_*))
  }

  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(h, t) => h + sum(t)
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case _ => 101
  }

  def tail[A](ts: List[A]): List[A]= ts match{
    case Nil=>Nil;
    case Cons(t,rs)=>rs
  }

  def setHead[A](hs: List[A], newHead:A): List[A] = hs match{
    case Nil=>Cons(newHead, Nil)
    case Cons(x, rs)=>Cons(newHead, rs)
  }

  def drop[A](l: List[A], n: Int):List[A]={
    if(n==0)
      l
    else
      drop(tail(l), n-1)
  }

  def dropWhile[A](l:List[A], f:A=>Boolean):List[A] = l match{
    case Cons(h,t)
      if f(h)
        =>dropWhile(t,f)
    case _=> l
  }

  def init[A](l:List[A]):List[A]= l match{
    case Nil=>
      Nil
    case Cons(t,Nil)=>
      Nil
    case Cons(t,hs)=>
      Cons(t,init(hs))
  }

}

object testClass
{
  def main(args:Array[String])={
    val a=List(1,2,3,4)

  }

  def check(input:Int):Boolean={
    input==1
  }
}


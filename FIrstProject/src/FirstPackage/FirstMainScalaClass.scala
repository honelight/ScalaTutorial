package FirstPackage

object MyModule
{
  def abs(n: Int): Int = {
    val k: Int = 3
    if (n < 0) -n
    else n
  }

  private def factorial(x: Int): Int={
//    def go(n:Int, acc: Int):Int={
//      if(n<=0)
//        acc
//      else
//        go(n-1, n*acc)
//    }
//    go(x,1)
    var a=1;
    var output=1
    for(a <- 1 to x){
      output=output*a
    }
    output
  }

  def fib(n:Int) : Int = {
    if(n==1 || n==0)
      n
    else
      fib(n-1)+fib(n-2)

  }

  def formatResult(name:String, n:Int, f:Int=>Int) : String={
    val msg : String = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  private def formatAbs(x:Int):String= {
    val msg: String = " The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def isSorted(as: Array[Int], check:(Int,Int)=>Boolean) : Boolean={
    def loop(n:Int):Boolean={
      if(n==as.length)
        true
      else if(!checkComparison(as(n-1), as(n)))
        false
      else
        loop(n+1)
    }
    loop(1)
  }

  def checkComparison(first:Int, second:Int):Boolean={
    if(first > second)
      false
    else
      true
  }

  def curry[A,B,C] (f:(A,B) => C):A=>(B=>C)={
    a=>(b=>f(a,b))
  }

  def uncurry[A,B,C](f:A=>B=>C) :(A,B)=>C={
    (a:A, b:B)=>f(a)(b)
  }

  def compose[A,B,C](f:B=>C, g:A=>B):A=>C ={
    (a:A)=>f(g(a))
  }

  def main(args: Array[String]) :Unit = {

    var inputArray:Array[Int]=Array(1,2,3,4,5,6,7,8,9,10)
    var secondInputArray:Array[Int]=Array(1,2,3,4,5,7,6,8,9,10)

    println(isSorted(inputArray, checkComparison))
    println(isSorted(secondInputArray, checkComparison))

  }




}
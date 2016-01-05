package org.Hongyao.ScalaTutorial.MergeSort

/**
  * Created by hone on 12/20/2015.
  */
class MergeSort {
  def mergeImprove(input1:List[Int], input2:List[Int]):List[Int]= (input1, input2) match{
    case(Nil, y::ys)=>{
      input2
    }
    case(x::xs, Nil)=>{
      input1
    }
    case(x::xs, y::ys)=>{
      if(x>y){
        y::mergeImprove(input1, ys)
      }
      else{
        x::mergeImprove(xs, input2)
      }
    }
  }
  def merge(input1:List[Int], input2:List[Int]):List[Int]={
    val output:Array[Int]=Array.fill(input1.length+input2.length)(0)
    val inputArray1 = input1.toArray
    val inputArray2 = input2.toArray
    val arrayLength1:Int = inputArray1.length
    val arrayLength2:Int = inputArray2.length
    var count:Int=0
    var countInput1:Int=0
    var countInput2:Int=0
    while(count<output.length)
    {
      (countInput1, countInput2) match {
        case (`arrayLength1`, _) if (countInput2 < inputArray2.length) => {
          output(count) = inputArray2(countInput2)
          countInput2 += 1
        }
        case (_, `arrayLength2`) if (countInput1 < inputArray1.length) => {
          output(count) = inputArray1(countInput1)
          countInput1 += 1
        }
        case (_, _) => {
          if (inputArray1(countInput1) > inputArray2(countInput2)) {
            output(count) = inputArray2(countInput2)
            countInput2 += 1
          }
          else {
            output(count) = inputArray1(countInput1)
            countInput1 += 1
          }
        }
      }
      count+=1
    }
    output.toList
  }

  def mergeSort(input:List[Int]):List[Int]={

    if(input.length==1)
      input
    else {
      mergeImprove(mergeSort(input.take(input.length / 2)), mergeSort(input.drop(input.length / 2)))
    }
  }
}

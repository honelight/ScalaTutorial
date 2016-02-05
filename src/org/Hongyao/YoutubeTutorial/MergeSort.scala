package org.Hongyao.YoutubeTutorial

/**
  * Created by hone on 2/4/2016.
  */
class MergeSort {
  def merge(list1:List[Int], list2:List[Int]):List[Int]={
    var outputList:Array[Int]=Array.fill(list1.length+list2.length)(0);
    var list1Index=0;
    var list2Index=0;
    for(x<-0 until outputList.length){
      if(list1Index==list1.length){
        outputList(x)=list2(list2Index);
        list2Index+=1;
      }
      else if(list2Index==list2.length){
        outputList(x)=list1(list1Index);
        list1Index+=1;
      }
      else{
        if(list1(list1Index)<list2(list2Index)){
          outputList(x)=list1(list1Index);
          list1Index+=1;
        }
        else{
          outputList(x)=list2(list2Index);
          list2Index+=1;
        }
      }
    }
    return outputList.toList;
  }

  def sort(sortList:List[Int]):List[Int]={
    if(sortList.length==1)
      return sortList;
    else{
      val (first,second)=sortList.splitAt(sortList.length/2);
      println(first+" "+second);
      return merge(sort(first), sort(second));
    }
  }
}

object MergeSortTest{
  def main(args:Array[String]):Unit={
    val input= new MergeSort;
    println(input.sort(List(5,2,3,4,56,7,1,2,3,3,6,8)));
  }
}

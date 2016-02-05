package org.Hongyao.YoutubeTutorial

import scala.io.Source;
/**
  * Created by hone on 2/4/2016.
  */
class ReadTextFileUsingSourceIO(filePath:String, input:String="default") {
  val source=Source.fromFile(filePath);

  def calculateSum():Double={
    var output:Double=0.0;
    var current:Double=0.0;
    println(input);
    for(x<-source.getLines()){
      output+=x.toDouble;
    }
    return output;
  }

  def outputMain():Unit={
    while(source.hasNext){
      println(source.next().toDouble);
    }
  }

}


object Calculator{
  def main(args:Array[String]):Unit={
    val readout=new ReadTextFileUsingSourceIO(filePath="C:/Users/hone/ChaseSpending.txt",
                                              input="new");
    println(readout.calculateSum());
  }
}
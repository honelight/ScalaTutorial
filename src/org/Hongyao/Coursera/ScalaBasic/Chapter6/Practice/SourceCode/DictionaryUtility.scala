package org.Hongyao.Coursera.ScalaBasic.Chapter6.Practice.SourceCode

import java.util.Dictionary

import scala.io.Source
/**
  * Created by hone on 1/4/2016.
  */
object DictionaryUtility {
  def loadDictionary:List[String]={
    println()
    //              C:\Users\hone\IdeaProjects\ScalaTutorial\src\org\Hongyao\Coursera\Chapter6\Practice\Dictionary
    val fileName = "C:/Users/hone/IdeaProjects/ScalaTutorial/src/org/Hongyao/Coursera/Chapter6/Practice/Dictionary/linuxwords.txt"
    val output= for(line<-Source.fromFile(fileName).getLines())yield{
      line
    }
    return output.toList
  }
}

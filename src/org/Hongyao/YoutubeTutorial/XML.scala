package org.Hongyao.YoutubeTutorial

import scala.xml._;
/**
  * Created by hone on 2/4/2016.
  */
case class Grade(value:Int, comment:Option[String]);
case class Student(name:String, quizzes:List[Grade],tests:List[Grade],assignments:List[Grade]);

class XML(path:String){
  val gradeXML = XML.loadFile(path);
  def findStudent():Unit={
    val students = gradeXML \"student";
    println(students);
  }
  def findStudentNames():Unit={
    println((gradeXML\"student").map(e=>e\ "@name").mkString("\n"));
  }
  def findAllQuizes():Unit={
    println(gradeXML\\"quiz");
  }

  def toGrade(node:Node):Grade = {
    println(node.text);
    val value= (node\"@value").text.toInt;
    val comments = (node\"comment").map(x=>x.text);
    val comment = if(comments.isEmpty){None}else{Some(comments.head)};
    return Grade(value, comment);
  }
  def toStudent(node:Node):Student={
    val name=(node\"@name").text;
    val quizzes = (node\"quiz").map(x=>this.toGrade(x)).toList;
    val tests = (node\"test").map(x=>this.toGrade(x)).toList;
    val assignments = (node\"assignment").map(x=>this.toGrade(x)).toList;
    return Student(name,quizzes, tests, assignments);
  }
}

object XMLTest{
  def main(args:Array[String]):Unit={
    val newXML=new XML("C:/Users/hone/xmltest.xml");
    val students = newXML.gradeXML\"student";
    var outputStudent:Student=Student("",List(),List(),List());
    for(x<-students){
      outputStudent=newXML.toStudent(x);
      println(outputStudent.name+" "+outputStudent.quizzes+" "+outputStudent.tests);
    }

  }
}

package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
object GotApples {
  def main(args: Array[String]): Unit ={
    val db:Database=
      if(args(0)=="student")
        StudentDatabase
      else
        SimpleDatabase

    object browser extends Browser {
      val database = db
    }

    val apple = SimpleDatabase.foodNamed("Apple").get
    for(recipe <- browser.recipesUsing(apple)){
      println(recipe)
    }
  }
}

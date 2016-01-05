package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */

object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")

object FruitSalad extends Recipe(
  name="fruit salad",
  ingredients=List(Apple, Orange, Cream, Sugar),
  instructions="Stir it all together"
)
{
}



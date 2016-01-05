//package org.Hongyao.ScalaTutorial.Currency
//
////import org.Hongyao.ScalaTutorial.Currency.CurrencyZone.AbstractCurrency
//
///**
//  * Created by hone on 12/22/2015.
//  */
//abstract class Currency {
//  val amount: Long
//  def designation:String
//  override def toString = amount+" "+designation
//  def + (that:Currency):Currency
//  def * (that:Currency):Currency
//}
//
////abstract class AbstractCurrency{
////  type Currency <: AbstractCurrency
////  val amount:Long
////  def designation:String
////  override def toString = amount +" "+designation
////  def + (that:Currency):Currency
////  def * (that:Currency):Currency
////}
//
//abstract class CurrencyZone{
//  type Currency=AbstractCurrency
//  def make(x:Long):Currency
//  abstract class AbstractCurrency{
//    val amount: Long
//    def designation:String
//    def+(that:Currency):Currency={
//      make(this.amount+that.amount)
//    }
//    def * (that: Currency):Currency={
//      make(this.amount*that.amount)
//    }
//    def - (that:Currency):Currency={
//      make(this.amount-that.amount)
//    }
//    def / (that:Currency):Currency={
//      make(this.amount/that.amount)
//    }
//    def / (that:Double)={
//      (this.amount.toDouble/that).toLong
//    }
//    def from(other: AbstractCurrency):Currency={
//      make(math.round(other.amount.toDouble*Converter.exchangeRate(other.designation)(this.designation)))
//    }
//    private def decimals(n:Long):Int={
//      if(n==1) 0 else 1+decimals(n/10)
//    }
//    override def toString={
//      ((amount.toDouble/CurrencyUnit.amount.toDouble)
//        formatted("%."+decimals(CurrencyUnit.amount)+"f")
//        +" "+designation)
//    }
//  }
//  val CurrencyUnit:Currency
//}
//
//object US extends CurrencyZone {
//  abstract class Dollar extends AbstractCurrency{
//    override def designation = "USD"
////    override def toString()={
////      ((this.amount.toDouble/CurrencyUnit.amount.toDouble )
////        formatted ("%." + decimals(CurrencyUnit.amount)+"f")+" "+designation)
////    }
//  }
//  override type Currency = Dollar
//  override def make(cents: Long)=new Dollar{
//    override val amount: Long = cents
//  }
//  val Cent = make(1)
//  val Dollar = make(100)
//  val CurrencyUnit = Dollar
//}
//
//object Euro extends CurrencyZone{
//  abstract class Euro extends AbstractCurrency {
//    override def designation = "Euro"
//  }
//  override type Currency = Euro
//  override def make(x: Long): Currency = new Euro{
//    override val amount: Long = x
//  }
//  val Cent = make(1)
//  val Euro = make(100)
//  val CurrencyUnit = Euro
//}
//
//object Japan extends CurrencyZone{
//  abstract class Yen extends AbstractCurrency{
//    def designation = "JPY"
//  }
//
//  override type Currency = Yen
//
//  override def make(x: Long): Currency = new Yen{
//    override val amount: Long = x
//  }
//
//  val Yen = make(1)
//  val CurrencyUnit = Yen
//}
//
//
//
//
//

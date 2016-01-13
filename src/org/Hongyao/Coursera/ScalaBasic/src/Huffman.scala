import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class Huffman{
  type Bit=Int
  type CodeTable = List[(Char, List[Bit])]
  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, weight: Int, chars:List[Char]) extends CodeTree
  case class Leaf(weight:Int, char:Char) extends CodeTree


  def weight(tree:CodeTree):Int= tree match{
    case Fork(left, right, weight, chars)=>{return weight}
    case Leaf(weight, char)=>{return weight}
  }

  def chars(tree:CodeTree):List[Char]= tree match{
    case Fork(left, right, weight, chars)=>{return chars}
    case Leaf(weight, char)=>{return List(char)}
  }

  def makeTreeNode(left:CodeTree, right:CodeTree): CodeTree ={
   return Fork(left, right, weight(left)+weight(right), chars(left)++chars(right))
  }

  def times(chars:List[Char]):List[(Char, Int)]={
    val inputMap:mutable.HashMap[Char,Int] = mutable.HashMap.empty[Char, Int]
    for(x<-chars){
      if(!inputMap.contains(x)){
        inputMap+=(x->1)
      }
      else{
        inputMap(x)=inputMap(x)+1
      }
    }
    val outputList:ListBuffer[(Char,Int)]= ListBuffer[(Char,Int)]()
    for(x<-inputMap){
      outputList+=(x)
    }
    return outputList.toList
  }

  def makeLeafList(freq:List[(Char, Int)]):List[Leaf]={
    val inputList= freq.sortBy[Int]{q=>q._1}
    return for(x<-inputList) yield {
      Leaf(x._2,x._1)
    }
  }

  def singleton(trees: List[CodeTree]): Boolean ={
    var weight:Int = 0
    var index:Int =0
    val booleanArray:Array[Boolean]=Array.fill(trees.length)(false)
    var totalWeight =0
    for(x<-trees){
      totalWeight+=this.weight(x)
      if(this.weight(x)>weight){
        weight=this.weight(x)
        index=trees.indexOf(x)
      }
    }
//    return this.weight(trees(index))==totalWeight/2
    val rootNode = trees(index)
    def changeList(currentNode:CodeTree): Unit = currentNode match {
      case Fork(left, right, weight, chars) =>{
        if(trees.indexOf(currentNode)!= -1){
          booleanArray(trees.indexOf(currentNode))=true
          changeList(left)
          changeList(right)
        }
      }
      case Leaf(weight, char)=>{
        if(trees.indexOf(currentNode)!= -1) {
          booleanArray(trees.indexOf(currentNode)) = true
        }
      }
      case _=>{}
    }
    changeList(rootNode)
    for(x<-booleanArray){
      if(x==false)
        return false
    }
    return true
  }
  def combine(trees: List[CodeTree]): List[CodeTree] ={
    val newTree = trees.sortBy[Int](x=>weight(x))
    val treeBuffer = newTree.to[ListBuffer]
//    println(treeBuffer.length)
//    for(x<-treeBuffer){
//      if(weight(x)<min1){
//        min2=min1
//        index2=index1
//        min1=weight(x)
//        index1=trees.indexOf(x)
//      }
//      else if(weight(x)<min2){
//        min2=weight(x)
//        index2=trees.indexOf(x)
//      }
//    }

    val node1=treeBuffer.head
    val node2=treeBuffer.tail.head

    val newBuffer = treeBuffer.slice(2,treeBuffer.length)

    newBuffer += makeTreeNode(node1,node2)

    newBuffer.sortBy[Int](x=>this.weight(x))
    return newBuffer.toList
  }

  def createCodeTree(chars:List[Char]):CodeTree = {
    val inputPair = this.times(chars)
    val leafList = this.makeLeafList(inputPair)
    var treeList = for(x<-leafList) yield{
      x.asInstanceOf[CodeTree]
    }
    while(this.singleton(treeList)!=true){
      treeList = this.combine(treeList)
    }
    return treeList.head
  }

  def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
    val outputList = ListBuffer[Char]()
    val bitsBuffer = bits.to[ListBuffer]
    var currentNode = tree
//    for(x<-bits){
//      currentNode match {
//        case Fork(left, right, weight, chars)=>{
//          if(x==0)
//            currentNode= left
//          else
//            currentNode = right
//        }
//        case Leaf(weight, char)=>{
//          outputList+=char
//          currentNode=tree
//        }
//      }
//    }
    var x=0
    while(x<=bits.length){
      currentNode match {
        case Fork(left, right, weight, chars)=>{
          if(x<bits.length){
            if(bitsBuffer(x)==0)
              currentNode= left
            else
              currentNode = right
          }
          x+=1
        }
        case Leaf(weight, char)=>{
          outputList+=char
          currentNode=tree
        }
      }
    }
    return outputList.toList
  }

  def encode(tree: CodeTree)(text: List[Char]): List[Bit] ={
    val outputList = ListBuffer[Bit]()
    def findChar(input:Char, currentStack:ListBuffer[Int], currentNode:CodeTree):Unit= currentNode match{
      case Leaf(weight, char)=>{
        if (char==input){
          outputList ++= currentStack
        }
        return
      }
      case Fork(left, right, weight, chars) => {
        findChar(input, currentStack ++ ListBuffer(0), left)
        findChar(input, currentStack ++ ListBuffer(1), right)
      }
    }
    for(x<-text){
      findChar(x, ListBuffer(), tree)
    }
    return outputList.toList
  }

  def quickEncode(tree: CodeTree)(text: List[Char]): List[Bit] ={
    val outputBuffer = ListBuffer[Bit]()
    val table = this.convert(tree)
    for(x<-text){
      outputBuffer ++= codeBits(table)(x)
    }
    return outputBuffer.toList
  }

  def convert(t:CodeTree):CodeTable={
    val outputList = ListBuffer[(Char,List[Bit])]()
    def append(node:CodeTree, intBuffer:ListBuffer[Bit]): Unit = node match{
      case Leaf(weight,char)=>{
        outputList++=ListBuffer((char,intBuffer.toList))
      }
      case Fork(left, right, weight,chars)=>{
        append(left, intBuffer++ListBuffer(0))
        append(right, intBuffer++ListBuffer(1))
      }
    }
    append(t,ListBuffer[Bit]())
    return outputList.toList
  }

  def codeBits(table:CodeTable)(char:Char):List[Bit]={
    for(x<-table){
     // println(x._1+" "+char)
      if(char==x._1) {
        //println(x._2)
        return x._2
      }
    }
    return List()
  }
}

object Test{
  def main(args:Array[String]): Unit ={
    val code = new Huffman
    val inputArray = "abbaaeebccbcaebbcaeeabbkiu".toCharArray().toList
    val root=code.createCodeTree(inputArray)
    println(root)
    val codes = code.encode(root)(List[Char]('a','b','a','c','e','k','i','u'))
    val table = code.convert(root)
    println(codes)
    println(code.decode(root,codes))
    val code2=code.quickEncode(root)(List[Char]('a','b','a','c','e','k','i','u'))
    println(code.decode(root,code2))

  }
}
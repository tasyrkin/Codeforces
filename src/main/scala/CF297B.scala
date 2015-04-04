object CF297B extends App{
  import scala.io.StdIn
  import scala.collection.mutable

  val input = StdIn.readLine().toCharArray
  val inputLength = input.length
  val n: Int = StdIn.readInt()
  val inputArray = StdIn.readLine().split("\\s+").map(x => x.toInt-1).sorted.toList :+ inputLength / 2

//  val hashMap = new mutable.HashMap[Int, Int]()
//
//  inputArray.foreach(x => {
//    val value = hashMap.get(x)
//    var cnt = 1
//    if(value.isEmpty){
//      hashMap.put(x, 1)
//    } else {
//      hashMap.put(x, value.get + 1)
//    }
//  })
//
//  val sorted = hashMap.filter(keyValue => keyValue._2 % 2 == 1).keys.toList.sorted :+ inputLength / 2
  
  val sorted = mutable.MutableList[Int]()
  var prev = inputArray.head
  var cnt = 0 
  inputArray.foreach(value => {
    if (prev != value){
      if(cnt % 2 == 1){
        sorted += prev
      }
      cnt = 1
      prev = value
    } else {
      cnt = cnt + 1
    }
  })
  if(cnt % 2 == 1)sorted += prev
  
  val arr = sorted.toArray
  
  for((value1,index) <- arr.view.zipWithIndex){
    if(index % 2 == 0 && index < arr.length-1){
      for(indexToChange <- value1 until arr(index+1)){
        val tmpValue = input(indexToChange)
        val oppositeIndexToChange = inputLength - indexToChange - 1 
        input(indexToChange) = input(oppositeIndexToChange)
        input(oppositeIndexToChange) = tmpValue 
      }
    } 
  }
  
  print (new String(input))
  
}

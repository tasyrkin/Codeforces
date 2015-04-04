object CF297B extends App{
  import scala.io.StdIn
  import scala.collection.mutable

  val input = StdIn.readLine().toCharArray
  val inputLength = input.length
  val n: Int = StdIn.readInt()
  val inputArray = StdIn.readLine().split("\\s+").map(x => x.toInt-1)

  val hashMap = new mutable.HashMap[Int, Int]()
  hashMap.put(inputLength / 2, 1)

  inputArray.foreach(x => {
    val value = hashMap.get(x)
    var cnt = 1
    if(value.isEmpty){
      hashMap.put(x, 1)
    } else {
      hashMap.put(x, value.get + 1)
    }
  })
  
  val arr = hashMap.filter(keyValue => keyValue._2 % 2 == 1).keys.toArray.sorted

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

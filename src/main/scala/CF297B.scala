object CF297B extends App{
  import scala.io.StdIn

  val input = StdIn.readLine().toCharArray
  val inputLength = input.length
  val n: Int = StdIn.readInt()
  val sortedArray = StdIn
    .readLine()
    .split("\\s+")
    .map(x => x.toInt-1)
    .groupBy(x => x)
    .filter(valAndArray => valAndArray._2.length % 2 == 1)
    .keys
    .toArray
    .sorted
  
  for((valueFrom,index) <- sortedArray.view.zipWithIndex){
    if(index % 2 == 0){
      
      val valueUntil = if(sortedArray.length-1 == index)  inputLength/2 else sortedArray(index + 1)   
      
      for(indexToChange <- valueFrom until valueUntil){
        val tmpValue = input(indexToChange)

        val oppositeIndexToChange = inputLength - indexToChange - 1 

        input(indexToChange) = input(oppositeIndexToChange)

        input(oppositeIndexToChange) = tmpValue 
      }
    } 
  }
  
  print (new String(input))
  
}

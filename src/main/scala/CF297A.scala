object CF297A extends App {
  import scala.collection.mutable.HashMap
  import scala.io.{StdIn}
  
  val n: Int = StdIn.readInt()
  val keysAndRooms: String = StdIn.readLine()
  var acc = 0
  
  keysAndRooms.toIterable.foreach(solve(new Multiset[Char]))
  
  print (acc)

  def solve(multiset: Multiset[Char]): (Char) => Unit = {
    (ch: Char) => {
      if(ch.isLower){
        multiset.add(ch.toUpper)
      } else {
        if(multiset.contains(ch)){
          multiset.remove(ch)
        } else{
          acc = acc + 1
        }
      }
    }
  }


  /**
   * Duplication of lib.Multiset because the whole code must be in one file
   * @tparam T a type variable stored in the multiset
   */
  class Multiset[T] {
    val hashMap = new HashMap[T, Int]()

    def add(element: T) = {
      val count = hashMap.getOrElseUpdate(element, 0)
      hashMap+=((element, count+1))
    }

    def contains(element:T ) = {
      hashMap.get(element).nonEmpty
    }

    def remove(element: T) = {
      val count = hashMap.getOrElse(element, 1)
      if (count == 1) {
        hashMap.remove(element)
      } else {
        hashMap+=((element, count-1))
      }
    }
  }

}


package lib

import scala.collection.mutable.HashMap

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

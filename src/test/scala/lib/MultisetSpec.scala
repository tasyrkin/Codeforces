package lib

import org.scalatest._

class MultisetSpec extends FlatSpec with Matchers {
  "A multiset" should "contain values inserted into it" in {
    val multiset = new Multiset[Int]
    multiset.add(1)
    multiset.add(2)
    multiset.contains(1) should be (true)
    multiset.contains(2) should be (true)
  }
  
  "A multiset" should "not contain values removed from it" in {
    val multiset = new Multiset[Int]
    multiset.add(1)
    multiset.add(2)
    multiset.remove(1)
    multiset.remove(2)
    multiset.contains(1) should be (false)
    multiset.contains(2) should be (false)
  }
}
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
}
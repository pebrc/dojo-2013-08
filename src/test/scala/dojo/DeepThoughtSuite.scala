package dojo

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner


import dojo.PotterKata._

@RunWith(classOf[JUnitRunner])
class PotterKataSuite extends FunSuite {
  
  private val anyBook = 0

  test("empty array") {
    assert(0 === price(Seq()))
  }

  test("one book") {
    assert(8 === price(Seq(anyBook)))
  }

  test("two book which are the same") {
    assert(2 * 8 === price(Seq(anyBook, anyBook)))
  }

  test("three books which are the same") {
    assert(3 * 8 === price(Seq(anyBook, anyBook, anyBook)))
  }

  test("two different books") {
    assert(8 * 2 * 0.95 === price(Seq(0, 1)))
  }
  test("three different books") {
    assert(8 * 3 * 0.9 === price(Seq(0, 1, 2)))
  }

  test("four different books") {
    assert(8 * 4 * 0.8 === price(Seq(0, 1, 2, 3)))
  }

  test("five different books") {
    assert(8 * 5 * 0.75 === price(Seq(0, 1, 2, 3, 4)))
  }

  test("two same books out of three") {
    assert(8 + (8 * 2 * 0.95) === price(Seq(0, 0, 1)))
  }

  test("two sets of two books") {
    assert(8 * 2 * 0.95 + 8 * 2 * 0.95 === price(Seq(0, 0, 1, 1)))
  }
  test("one set of four books and one set of two books") {
    assert(8 * 4 * 0.8 + 8 * 2 * 0.95 === price(Seq(0, 0, 1, 2, 2, 3)))
  }
  test("one set of five books and one set of one book") {
    assert(8 + (8 * 5 * 0.75) === price(Seq(0, 1, 1, 2, 3, 4)))
  }
  
  test("can collect cardinality of each type of book in input") {
    assert(Seq(3,1,2) === cardinalityByNumber(Seq(0,0,1,2,2,2)))
  }
  
  test("can subtract a set from a list of quantities") {
	  assert(Seq(1,1) === removeSet(2, Seq(2,2)))
  }
  
  test("can subtract a set from a list of quantities with a remainder") {
	  assert(Seq(1,1, 1) === removeSet(2, Seq(2,2,1)))
  }
  
  test("can detect one set") {
    assert(Seq(Seq(2), Seq(1,1)) === possibleSets(Seq(1,1), Seq(2,1)))
  }
  
  test("can detect sets of ones") {
    assert(Seq(Seq(1,1)) === possibleSets(Seq(1,1), Seq(1)))
  }
  
  test("can detect sets of three") {
    assert(Seq(Seq(3), Seq(1,2), Seq(1,1,1)) === possibleSets(Seq(1,1,1), Seq(3,2,1)))
  }

  
  test("can detect all possible sets") {
    assert(Seq(Seq(2), Seq(1,1)) === setsEligibleForDiscount(Seq(0,1)))
  }

  test("two sets of four books") {
    assert(2 * (8 * 4 * 0.8) === price(Seq(0, 0, 1, 1, 2, 2, 3, 4)))
  }

  test("Three sets of five and two sets of four") {
    assert(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8) === price(
        Seq(0,0,0,0,0,
        	1,1,1,1,1,
        	2,2,2,2,
        	3,3,3,3,3,
        	4,4,4,4)))
  }

}

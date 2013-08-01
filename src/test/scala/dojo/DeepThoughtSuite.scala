package dojo

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import dojo.PotterKata._

@RunWith(classOf[JUnitRunner])
class PotterKataSuite extends FunSuite {

  test("empty array") {
    assert(0 === compute(Seq()))
  }

  test("one book") {
    assert(8 === compute(Seq(anyBook)))
  }

  test("two book which are the same") {
    assert(2 * 8 === compute(Seq(anyBook, anyBook)))
  }

  test("three books which are the same") {
    assert(3 * 8 === compute(Seq(anyBook, anyBook, anyBook)))
  }


  private val anyBook = 0

  test("two different books") {
    assert(8 * 2 * 0.95 === compute(Seq(0, 1)))
  }
  test("three different books") {
    assert(8 * 3 * 0.9 === compute(Seq(0, 1, 2)))
  }

  test("four different books") {
    assert(8 * 4 * 0.8 === compute(Seq(0, 1, 2, 3)))
  }

  test("five different books") {
    assert(8 * 5 * 0.75 === compute(Seq(0, 1, 2, 3, 4)))
  }

  test("two same books out of three") {
    assert(8 + (8 * 2 * 0.95) === compute(Seq(0, 0, 1)))
  }

  test("distinct function test two sets of two books") {
    assert(Seq(Set(0, 1), Set(0, 1)) === distinct(Seq(0, 0, 1, 1)))
  }

  test("distinct function test three sets of one book") {
    assert(Seq(Set(0), Set(0), Set(0)) === distinct(Seq(0, 0, 0)))
  }

  test("two sets of two books") {
    assert(8 * 2 * 0.95 + 8 * 2 * 0.95 === compute(Seq(0, 0, 1, 1)))
  }
  test("one set of four books and one set of two books") {
    assert(8 * 4 * 0.8 + 8 * 2 * 0.95 === compute(Seq(0, 0, 1, 2, 2, 3)))
  }
//  test("one set of four books and one set of two books") {
//    assert(8 + (8 * 5 * 0.75), price([0, 1, 1, 2, 3, 4]))
}

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
    assert(2*8 === compute(Seq(anyBook, anyBook)))
  }

  test("three books which are the same") {
    assert(3*8 === compute(Seq(anyBook, anyBook, anyBook)))
  }

  private val anyBook = 0

//  assert_equal(8 * 2, price([0, 0]))
//  assert_equal(8 * 3, price([1, 1, 1]))
}

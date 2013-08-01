package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {

  def distinct(input: Seq[Int]): Seq[Seq[Int]] = {
    if (input.isEmpty) {
      return Nil
    }
    val unique = input.distinct
    val remainder = input.diff(unique)
    unique +: distinct(remainder)
  }

  def compute(bookNumbers: Seq[Int]): Double = {
    (for (e <- distinct(bookNumbers)) yield
      getPriceForSet(e)).sum
  }

  def getPriceForSet(bookNumbers: Seq[Int]): Double = {
    require(bookNumbers.size == bookNumbers.distinct.size)
    val setSize = bookNumbers.size
    val discount = setSize match {
      case 5 => 0.75
      case 4 => 0.8
      case 3 => 0.9
      case 2 => 0.95
      case _ => 1.0
    }
    setSize * 8 * discount
  }
}
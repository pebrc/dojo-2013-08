package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {

  def distinct(input: Seq[Int]): Seq[Set[Int]] = {
    if (input.isEmpty) {
      return Nil
    }
    val unique = input.distinct
    val remainder = input.diff(unique)
    unique.toSet +: distinct(remainder)
  }

  def compute(bookNumbers: Seq[Int]): Double = {
    distinct(bookNumbers).map(getPriceForSet).sum
  }

  def getPriceForSet(bookNumbers: Set[Int]): Double = {
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
package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {

  def compute(bookNumbers: Seq[Int]): Double = {
    val discount =    bookNumbers.toSet.size match {
      case 5 => 0.75
      case 4 => 0.8
      case 3 => 0.9
      case 2 => 0.95
      case _ => 1.0
    }
    bookNumbers.size * 8 * discount
  }
}
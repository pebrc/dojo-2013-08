package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {

  def compute(bookNumbers: Seq[Int]): Double = {
    val discount =
    if(bookNumbers.toSet.size == 2) {
      0.95
    } else {
      1
    }
    bookNumbers.size * 8 * discount
  }
}
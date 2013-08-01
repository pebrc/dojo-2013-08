package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {

  def compute(bookNumbers: Seq[Int]): Int = {
    bookNumbers.size * 8
  }
}
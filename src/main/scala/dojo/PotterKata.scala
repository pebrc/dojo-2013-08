package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {

  def distinct(input: Seq[Int]): Seq[Seq[Int]] = {
     if(input.isEmpty){
       return Nil
     }
     val unique = input.distinct
     val remainder = input.diff(unique)
    (unique :: distinct(remainder).toList).toSeq
  }

  def compute(bookNumbers: Seq[Int]): Double = {
    (for(e <- distinct(bookNumbers)) yield
    getPriceForSet(e)).sum
  }

  def getPriceForSet(bookNumbers: Seq[Int]): Double = {
    val setSize = bookNumbers.toSet.size
    val discount = setSize match {
      case 5 => 0.75
      case 4 => 0.8
      case 3 => 0.9
      case 2 => 0.95
      case _ => 1.0
    }
    val withoutDiscount = bookNumbers.size-setSize
    (setSize * 8 * discount) + (withoutDiscount * 8)
  }
}
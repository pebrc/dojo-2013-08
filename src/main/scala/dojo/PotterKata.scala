package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {
  
  val discountSets = List(5,4,3,2,1)

  def distinct(input: Seq[Int]): Seq[Set[Int]] = {
    if (input.isEmpty) {
      return Nil
    }
    val unique = input.distinct
    val remainder = input.diff(unique)
    unique.toSet +: distinct(remainder)
  }

  def compute(bookNumbers: Seq[Int]): Double = {
    if(bookNumbers.isEmpty) {
      return 0
    }
    sets(bookNumbers).map(getPriceFor).min    
  }
  
  def getPriceFor(distinctSetSizes: Seq[Int]): Double = {
    distinctSetSizes.map(getPriceForDistinctNumberOfBooks(_)).sum
  }
  
  

  def getPriceForSet(bookNumbers: Set[Int]): Double = {
    getPriceForDistinctNumberOfBooks(bookNumbers.size)
    
  }
  
  def getPriceForDistinctNumberOfBooks(n: Int) : Double = {
	val discount = n match {
      case 5 => 0.75
      case 4 => 0.8
      case 3 => 0.9
      case 2 => 0.95
      case _ => 1.0
    }
    n * 8 * discount	 
  }
  
  def cardinalityByNumber(booksByNumber: Seq[Int]):Seq[Int] = {
    booksByNumber.groupBy(identity).mapValues(_.size).values.toSeq
  }
  
  def removeSet(setOfSize:Int, distinctQuantities: Seq[Int]): Seq[Int] = {
    if(setOfSize == 0) {
      distinctQuantities
    } else {
      (distinctQuantities.head -1) +: removeSet(setOfSize-1, distinctQuantities.tail)
    }
    
  }
  
  def containedSets(quantities: Seq[Int], sets: Seq[Int]): Seq[Seq[Int]] = {         
      if(quantities.isEmpty) {
        return Seq()
      }      
      val curr = sets.head;
      if(quantities.size >= curr) {    	      	  
    	 setsStartingFrom(sets, removeSet(curr, quantities).filter(_ > 0), Seq()) match {
    	   case Nil => Seq(Seq(curr))
    	   case aSeq => aSeq.map(_ :+ curr)
    	 }
      } else {
    	 setsStartingFrom(sets.tail, quantities, Seq())
      }	
    
  }
  
  def setsStartingFrom(discountSets:Seq[Int], input: Seq[Int], acc: Seq[Seq[Int]]): Seq[Seq[Int]] = {
      if(input.isEmpty || discountSets.isEmpty) {
        return acc
      }      
      var accumulated = acc;
      if(discountSets.head <= input.size) {
        accumulated = containedSets(input, discountSets) ++ acc
      }
      setsStartingFrom(discountSets.tail,input, accumulated)
    }
  
  def sets(booksByNumber: Seq[Int]): Seq[Seq[Int]] = {
    setsStartingFrom(discountSets, cardinalityByNumber(booksByNumber), Seq()).reverse
  }
}
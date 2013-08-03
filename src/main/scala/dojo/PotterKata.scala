package dojo

/**
 * http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter
 */
object PotterKata {
  
  val discountSets = List(5,4,3,2,1)


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
  
  def possibleSets(quantities: Seq[Int], sets: Seq[Int]): Seq[Seq[Int]] = {
      if(quantities.isEmpty || sets.isEmpty) {
        return Seq()
      }    
      
      def permutationsBelow(thresholdValue:Int): Seq[Seq[Int]] = {             
       if(quantities.size >= thresholdValue) {    	      	  
    	 possibleSets(removeSet(thresholdValue, quantities).filter(_ > 0), sets) match {
    	   case Nil => Seq(Seq(thresholdValue))
    	   case aSeq => aSeq.map(_ :+ thresholdValue)
    	 }
       } else {
         Seq()
       }

      }
      permutationsBelow(sets.head) ++ possibleSets(quantities, sets.tail)
    
  }
  
  
  def sets(booksByNumber: Seq[Int]): Seq[Seq[Int]] = {
    possibleSets(cardinalityByNumber(booksByNumber), discountSets)
  }
}
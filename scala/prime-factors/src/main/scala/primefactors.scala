//package exercism.primefactors

object PrimeFactors extends App {
  private def cleanDivisor(number: Long, possibleDivisor:Long = 2):Long = {
    if ((number % possibleDivisor) == 0)
      possibleDivisor
    else
      cleanDivisor(number, possibleDivisor + 1)
  }

  private def primeFactors(primes: List[Long], number: Long) :List[Long] = {
    if (number != 1) {
      val possibleDivisor = primes.headOption.getOrElse(2:Long)
      val divisor = cleanDivisor(number, possibleDivisor)
      val _primes = divisor :: primes
      val reminder = number / divisor
      if (reminder == 1)
        _primes
      else
        primeFactors(_primes, reminder)
    } else primes
  }

  def forNumber(number: Long): List[Long] = {
    primeFactors(List(), number).reverse
  }

  //Console println forNumber(Long.MaxValue)
}

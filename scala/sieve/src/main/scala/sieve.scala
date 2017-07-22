object Sieve extends App {

  def primes(list:List[Int], n: Int = 2): List[Int] = {
    val _list = list.filter { i => (i <= n) || (i % n) != 0 }
    val _n = list.filter(_ > n).headOption match {
      case Some(next) => next
      case None => n
    }
    if (_n == n) _list else primes(_list, _n)
  }

  def primesUpTo(limit: Int): List[Int] = {
    primes((2 to limit).toList)
  }
}

class Frequency(seq: Seq[String]) {
  type FreqMap = Map[Char, Int]

  def calculate() = {
    val emptyFreqMap: FreqMap = Map[Char, Int]()
    val pattern = "(\\p{L}+)".r

    val reduce: (FreqMap, FreqMap) => FreqMap =
      (m1, m2) => {
        m1 ++ m2.map { case (k, v) => k -> (v + m1.getOrElse(k, 0)) }
      }

    val seqop: (FreqMap, String) => FreqMap = (accFrecMap, s) => {
      val stringFreqMap = s.toLowerCase().foldLeft(emptyFreqMap){(fm, c) =>
        c match {
          case pattern(char) => fm.get(char) match {
            case None => fm+((char, 1))
            case Some(i) => fm.updated(char, i+1)
          }
          case _ => fm
        }
      }
      reduce(stringFreqMap, accFrecMap)
    }
    seq.par.aggregate(emptyFreqMap)(seqop, reduce)
  }
}

object Frequency extends App {
  def frequency(workers: Int, seq: Seq[String]):Map[Char, Int] = {
    new Frequency(seq).calculate()
  }
}
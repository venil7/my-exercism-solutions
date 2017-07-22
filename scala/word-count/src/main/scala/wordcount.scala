class Phrase(phrase: String) {
  def wordCount(): Map[String, Int] = {

   "[\\w']+".r
     .findAllIn(phrase)
     .foldLeft(Map[String, Int]())({(map, word) => map.get(word) match {
        case None => map + ((word, 1))
        case Some(i) => map.updated(word, i +1)
      }
     })

  }
}
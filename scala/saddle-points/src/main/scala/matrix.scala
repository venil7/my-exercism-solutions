class ListExtensions(list: List[Int]) {
  def indicesOf(f: List[Int] => Int):List[Int] = {
    list.zipWithIndex.filter(_._1 == f(list)).map(_._2)
  }

  def indicesOfMax():List[Int] = indicesOf(_.max)

  def indicesOfMin():List[Int] = indicesOf(_.min)
}

case class Matrix(val rows:List[List[Int]]) {
  implicit def listExtensions(list: List[Int]) = new ListExtensions(list)

  def transpose(): Matrix = Matrix(rows.transpose)

  def saddlePoints() :Set[(Int, Int)] = {
   val transposed = transpose()

   val p1 = rows
     .zipWithIndex
     .flatMap({case (row, y) => row.indicesOfMax().map((y,_)) })

   val p2 = transposed.rows
     .zipWithIndex
     .flatMap({case (row, x) => row.indicesOfMin().map((_,x)) })

   p1.intersect(p2).toSet
  }

}
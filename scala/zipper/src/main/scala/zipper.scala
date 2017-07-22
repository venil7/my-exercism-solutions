// package exercism.zipper

case class BinTree[T](val value:T, val left: Option[BinTree[T]], val right: Option[BinTree[T]]) {
  def setValue(v: T) = new BinTree(v, left, right)
  def setLeft(l: Option[BinTree[T]]) = new BinTree(value, l, right)
  def setRight(r: Option[BinTree[T]]) = new BinTree(value, left, r)
}

class Zipper[T] private(private val focus: BinTree[T])

object Zipper extends App {
  // Get a zipper focused on the root node.
  def fromTree[A](bt: BinTree[A]): Zipper[A] = new Zipper(bt)

  // Get the complete tree from a zipper.
  def toTree[A](zipper: Zipper[A]): BinTree[A] = zipper.focus

  // Get the value of the focus node.
  def value[A](zipper: Zipper[A]): A = zipper.focus.value

  // Get the left child of the focus node, if any.
  def left[A](zipper: Zipper[A]): Option[Zipper[A]] = {
    zipper.focus.left match {
      case None => None
      case Some(left: BinTree[A]) => Some(new Zipper[A](left))
    }
  }

  // Get the right child of the focus node, if any.
  def right[A](zipper: Zipper[A]): Option[Zipper[A]] = {
    zipper.focus.right match {
      case None => None
      case Some(right: BinTree[A]) => Some(new Zipper[A](right))
    }
  }

  // Get the parent of the focus node, if any.
  def up[A](zipper: Zipper[A]): Option[Zipper[A]] = None

  // Set the value of the focus node.
  def setValue[A](v: A, zipper: Zipper[A]): Zipper[A] = new Zipper[A](zipper.focus.setValue(v))

  // Replace a left child tree.
  def setLeft[A](l: Option[BinTree[A]], zipper: Zipper[A]): Zipper[A] = new Zipper[A](zipper.focus.setLeft(l))

  // Replace a right child tree.
  def setRight[A](r: Option[BinTree[A]], zipper: Zipper[A]): Zipper[A] = new Zipper[A](zipper.focus.setRight(r))

}

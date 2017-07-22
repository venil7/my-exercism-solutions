class Accumulate {
  def accumulate[I, O](func: I => O, list: List[I]) : List[O] = {
      for(item <- list) yield func(item)
  }
}
package org.mo39.fmbh.datastructure.design

import scala.collection.IndexedSeqLike
import scala.collection.mutable.{ArrayBuffer, Builder}

object RNA {

  abstract class Base

  case object A extends Base
  case object T extends Base
  case object G extends Base
  case object U extends Base

  object Base {
    // Int to Base signature matches Array[Base].apply method reference and ".apply" can be hidden
    val fromInt: Int => Base = Array(A, T, G, U)
    val toInt: Base => Int = Map(A -> 0, T -> 1, G -> 2, U -> 3)
  }

  final class RNA1 private (val groups: Array[Int], val length: Int)
      extends IndexedSeq[Base] {

    import RNA1._

    override def apply(idx: Int): Base = {
      if (idx < 0 || length <= idx) throw new IndexOutOfBoundsException
      Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
    }

  }

  object RNA1 {
    private val S = 2
    private val N = 32 / S
    private val M = (1 << S) - 1

    def fromSeq(buf: Seq[Base]): RNA1 = {
      val groups = new Array[Int]((buf.length + N - 1) / N)
      for (i <- buf.indices) groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
      new RNA1(groups, buf.length)
    }

    def apply(bases: Base*): RNA1 = fromSeq(bases)

  }

  final class RNA2 private (val groups: Array[Int], val length: Int)
      extends IndexedSeq[Base]
      with IndexedSeqLike[Base, RNA2] {

    import RNA2._

    override def newBuilder: Builder[Base, RNA2] =
      new ArrayBuffer[Base] mapResult fromSeq

    override def apply(idx: Int): Base = {
      if (idx < 0 || length <= idx) throw new IndexOutOfBoundsException
      Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
    }

  }

  object RNA2 {
    private val S = 2
    private val N = 32 / S
    private val M = (1 << S) - 1

    def fromSeq(buf: Seq[Base]): RNA2 = {
      val groups = new Array[Int]((buf.length + N - 1) / N)
      for (i <- buf.indices) groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
      new RNA2(groups, buf.length)
    }

    def apply(bases: Base*): RNA2 = fromSeq(bases)

  }

}

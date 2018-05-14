package org.mo39.fmbh.commons.utils
/* A box that holds a value */
case class Box[T](private var value: T) {
  def get: T                  = if (value == null) throw new Error("empty.get") else value
  def apply(other: T): Box[T] = { value = other; this }
  def isEmpty: Boolean        = value == null
  def nonEmpty: Boolean       = value != null
}

object Box {
  def empty[T]: Box[T] = Box(null.asInstanceOf[T])
}

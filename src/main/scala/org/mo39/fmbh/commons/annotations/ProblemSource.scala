package org.mo39.fmbh.commons.annotations

import org.mo39.fmbh.commons.annotations.SourceValue.SourceValue

import scala.annotation.Annotation

case class ProblemSource(value: SourceValue) extends Annotation

object SourceValue extends Enumeration {
  type SourceValue = Value
  val LeetCode = Value
}

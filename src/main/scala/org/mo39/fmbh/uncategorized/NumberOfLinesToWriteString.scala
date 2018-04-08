package org.mo39.fmbh.uncategorized

object NumberOfLinesToWriteString {

  def numberOfLines(widths: Array[Int], S: String): Array[Int] = {
    val arr = S.map(c => widths(c - 'a'))
    var count, line = 0
    arr.foreach(i => {
      if (count + i > 100) {
        line += 1
        count = i
      } else count += i
    })
    Array(if (count == 0) line else line + 1, count)
  }

}
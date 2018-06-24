package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Suppose we abstract our file system by a string in the following
  * manner:
  *
  * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
  *
  * dir
  *     subdir1
  *     subdir2
  *         file.ext
  *
  *
  * The directory dir contains an empty sub-directory subdir1 and a
  * sub-directory subdir2 containing a file file.ext.
  *
  * The string
  * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
  * represents:
  *
  * dir
  *     subdir1
  *         file1.ext
  *         subsubdir1
  *     subdir2
  *         subsubdir2
  *             file2.ext
  *
  *
  * The directory dir contains two sub-directories subdir1 and subdir2.
  * subdir1 contains a file file1.ext and an empty second-level
  * sub-directory subsubdir1. subdir2 contains a second-level sub-directory
  * subsubdir2 containing a file file2.ext.
  *
  * We are interested in finding the longest (number of characters)
  * absolute path to a file within our file system. For example, in the
  * second example above, the longest absolute path is
  * "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including
  * the double quotes).
  *
  * Given a string representing the file system in the above format, return
  * the length of the longest absolute path to file in the abstracted file
  * system. If there is no file in the system, return 0.
  *
  * Note:
  *
  * The name of a file contains at least a . and an extension.
  * The name of a directory or sub-directory will not contain a ..
  *
  *
  *
  * Time complexity required: O(n) where n is the size of the input string.
  *
  * Notice that a/aa/aaa/file1.txt is not the longest file path, if there
  * is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
  * }}}
  *
  * @see [[https://leetcode.com/problems/longest-absolute-file-path/ LongestAbsoluteFilePath]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LongestAbsoluteFilePath {
  def lengthLongestPath(input: String): Int
}

object LongestAbsoluteFilePath extends Enumerable[LongestAbsoluteFilePath] {
  case object Solution0 extends LongestAbsoluteFilePath {
    override def lengthLongestPath(s: String): Int = {
      var max   = 0
      var stack = List[(Int, Int)]() // (length, depth)
      for (p <- s.split("\n")) {
        val depth = p.lastIndexOf('\t') + 1
        while (stack.nonEmpty && stack.head._2 >= depth) stack = stack.tail
        if (p.contains('.')) {
          if (stack.isEmpty) max = max.max(p.length)
          else max = max.max(stack.head._1 + p.length - depth)
        } else {
          if (stack.isEmpty) stack = (p.length - depth + 1, depth) :: stack
          else stack = (p.length - depth + 1 + stack.head._1, depth) :: stack
        }
      }
      max
    }
  }

  /**
    * Really nice and concise improvement
    * 1. Dummy head
    * 2. Pop stack condition
    */
  case object Solution1 extends LongestAbsoluteFilePath {
    override def lengthLongestPath(s: String): Int = {
      var result = 0
      var stack  = List(0)
      for (p <- s.split("\n")) {
        val depth = p.lastIndexOf('\t') + 1
        while (depth + 1 < stack.length) stack = stack.tail
        if (p.contains('.')) result = result.max(stack.head + p.length - depth)
        else stack = p.length - depth + 1 + stack.head :: stack
      }
      result
    }

  }
}

package org.mo39.fmbh.datastructure.array

object MajorityElement {

  sealed trait MajorityElement {
    def majorityElement(nums: Array[Int]): Int
  }

  case object SOLUTION_0 extends MajorityElement {
    override def majorityElement(nums: Array[Int]): Int = {
      var (major, count) = (nums(0), 0)
      for (n <- nums) {
        if (count == 0) {
          count += 1
          major = n
        } else if (n == major) count += 1
        else count -= 1
      }
      major
    }
  }

  case object SOLUTION_1 extends MajorityElement {
    override def majorityElement(nums: Array[Int]): Int = {
      nums.groupBy(identity).mapValues(_.size).maxBy(_._2)._1
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(47, 47, 72, 47, 72, 47, 79, 47, 12, 92, 13, 47, 47, 83, 33, 15, 18, 47, 47, 47, 47, 64, 47, 65, 47, 47, 47, 47, 70, 47, 47, 55, 47, 15, 60, 47, 47, 47, 47, 47, 46, 30, 58, 59, 47, 47, 47, 47, 47, 90, 64, 37, 20, 47, 100, 84, 47, 47, 47, 47, 47, 89, 47, 36, 47, 60, 47, 18, 47, 34, 47, 47, 47, 47, 47, 22, 47, 54, 30, 11, 47, 47, 86, 47, 55, 40, 49, 34, 19, 67, 16, 47, 36, 47, 41, 19, 80, 47, 47, 27)
    println(SOLUTION_1.majorityElement(nums))
  }

}
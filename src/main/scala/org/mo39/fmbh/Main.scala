package org.mo39.fmbh

class Publication(val title:String)
class Book(title:String)  extends Publication(title) {
  def bookOnly: Unit = println("Hey?")
}

object Library {
  val books: Set[Book] = Set(new Book("Programming in Scala"), new Book("Walden"))
  def printBookList(info: Book => AnyRef) = {
    for(book <- books) println(info(book))
  }
}

object Main extends App {
  def getTitle(p: Publication): String = p.title
  Library.printBookList(getTitle)
  println("10.3" < "9.3")
  println(10.3 > 9.3)
}

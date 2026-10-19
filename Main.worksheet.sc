import scala.collection.immutable.Queue


def myIterator1 = Iterator("griffen", "testing", "iterator", "end", "a", "b", "c", "d", "e")
val iterator1 = myIterator1
iterator1.next() // call once
iterator1.next() // call twice, moving forward like a linked list

// scan left gives every intermediate state 
// output on every item
def myIterator2 = Iterator("a", "b", "c", "d", "e", "f", "g", "h", "i")
val iterator2 = myIterator2
iterator2.scanLeft(Queue.empty[String])((q, word) => // result of scanLeft is an iterator items in queues
  val added = q.enqueue(word)
  if added.size > 3 then added.dequeue._2 else added
).toList


def myIterator3 = Iterator("dog", "cat", "mouse", "house")
// scan left version that only gives final state
// for each item compute new state = old state + item
val (sum, count) = myIterator3.foldLeft((0, 0))((acc, word) =>
    val (s, c) = acc
    (s + word.length, c + 1))
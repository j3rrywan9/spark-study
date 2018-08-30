package me.jerrywang.scala.study.spark.examples.rdd

import org.apache.log4j.{ Level, Logger }
import org.apache.spark.SparkContext

object WordCount {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sparkContext = new SparkContext("local[*]", "WordCount")

    val lines = sparkContext.textFile(getClass.getResource("/rdd/word_count.txt").toString)
    val words = lines.flatMap(_.split(" "))

    val wordCounts = words.countByValue()
    for ((word, count) <- wordCounts) println(word + " : " + count)
  }
}

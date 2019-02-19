package me.jerrywang.scala.study.spark.examples.rdd.reduce

import org.apache.spark.SparkContext

object ReduceExample {
  def main(args: Array[String]): Unit = {
    val sparkContext = new SparkContext("local[*]", "ReduceExample")

    val inputIntegers = List(1, 2, 3, 4, 5)
    val integerRDD = sparkContext.parallelize(inputIntegers)

    val product = integerRDD.reduce(_ * _)
    println("Product is :" + product)
  }
}

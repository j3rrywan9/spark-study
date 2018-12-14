# Spark: The Definitive Guide

## Chapter 1

Apache Spark is a unified computing engine and a set of libraries for parallel data processing on computer clusters.

## Chapter 2

### Spark's Basic Architecture

A cluster, or group, of computers, pools the resources of many machines together, giving us the ability to use all the cumulative resources as if they were a single computer.
Now, a group of machines alone is not powerful, you need a framework to coordinate work across them.
Spark does just that, managing and coordinating the execution of tasks on data across a cluster of computers.

#### Spark Application

Spark Applications consist of a *driver* process and a set of *executor* processes.
The driver process runs your `main()` function, sits on a node in the cluster, and is responsible for three things: maintaining information about the Spark Application; responding to a user's program or input; and analyzing, distributing, and scheduling work across the executors (discussed momentarily).
The driver process is absolutely essential - it's the heart of a Spark Application and maintains all relevant information during the lifetime of the application.

The *executors* are responsible for actually carrying out the work that the driver assigns them.
This means that each executor is responsible for only two things: executing code assigned to it by the driver, and reporting the state of the computation on that executor back to the driver node.

#### Spark's Language APIs

#### Spark's APIs

Spark has two fundamental sets of APIs: the low-level "unstructured" APIs, and the higher-level structured APIs.

#### Starting Spark

When you start Spark in this interactive mode, you implicitly create a SparkSession that manages the Spark Application.
When you start it through a standalone application, you must create the SparkSession object yourself in your application code.

#### The SparkSession

The SparkSession instance is the way Spark executes user-defined manipulations across the cluster.

#### DataFrames

A DataFrame is the most common Structured API and simply represents a table of data with rows and columns.
The list that defines the columns and the types within those columns is called the *schema*.

##### Partitions

## Chapter 3

## Chapter 5

Definitionally, a DataFrame consists of a series of *records* (like rows in a table), that are of type `Row`, and a number of *columns* (like columns in a spreadsheet) that represent a computation expression that can be performed on each individual record in the Dataset.

### Schemas

A schema defines the column names and types of a DataFrame.

### DataFrame Transformations

#### Adding Columns

There's also a more formal way of adding a new column to a DataFrame, and that's by using the `withColumn` method on our DataFrame.

#### Removing Columns

## Chapter 6

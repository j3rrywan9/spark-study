# Learning Spark SQL

## Getting Started with Spark SQL

Spark SQL is at the heart of all applications developed using Spark.

### What is Spark SQL?

Spark SQL is one of the most advanced components of Apache Spark.
It has been a part of the core distribution since Spark 1.0 and supports Python, Scala, Java, and R programming APIs.

### Introducing `SparkSession`

In Spark 2.0, `SparkSession` represents a unified entry point for manipulating data in Spark.
It minimizes the number of different contexts a developer has to use while working with Spark.
`SparkSession` replaces multiple context objects, such as the `SparkContext`, `SQLContext`, and `HiveContext`.
These contexts are now encapsulated within the `SparkSession` object.

In Spark programs, we use the builder design pattern to instantiate a `SparkSession` object.
However, in the REPL environment (that is, in a Spark shell session), the `SparkSession` is automatically created and made available to you via an instance object called **spark**.

The `SparkSession` object can be used to configure Spark's runtime config properties.

The `SparkSession` object can be used to read data from various sources, such as CSV, JSON, JDBC, stream, and so on.
In addition, it can be used to execute SQL statements, register User Defined Functions (UDFs), and work with Datasets and DataFrames.

The DataFrame can be registered as a SQL temporary view using the `createOrReplaceTempView()` method.
This allows applications to run SQL queries using the `sql` function of the `SparkSession` object and return the results as a DataFrame.

### Understanding Resilient Distributed Datasets (RDDs)

RDDs are Spark's primary distributed Dataset abstraction.
It is a collection of data that is immutable, distributed, lazily evaluated, type inferred, and cacheable.

You can create RDDs by parallelizing an existing collection of data or accessing a Dataset residing in an external storage system, such as the file system or various Hadoop-based data sources.
The parallelized collections form a distributed Dataset that enable parallel operations on them.

The programming interface to RDDs support two types of operations: transformations and actions.
The transformations create a new Dataset from an existing one, while the actions return a value or result of a computation.

### Understanding DataFrames and Datasets

A DataFrame is similar to a table in a relational database, a pandas dataframe, or a data frame in R.
It is a distributed collection of rows that is organized into columns.
It uses the immutable, in-memory, resilient, distributed, and parallel capabilities of RDD, and applies a schema to the data.
DataFrames are also evaluated lazily.
Additionally, they provide a domain-specific language (DSL) for distributed data manipulation.

Conceptually, the DataFrame is an alias for a collection of generic objects `Dataset[Row]`, where a row is a generic untyped object.
This means that syntax errors for DataFrames are caught during the compile stage; however, analysis errors are detected only during runtime.

DataFrames can be constructed from a wide array of sources, such as structured data files, Hive tables, databases, or RDDs.
The source data can be read from local filesystems, HDFS, Amazon S3, and RDBMSs.
In addition, other popular data formats, such as CSV, JSON, Avro, Parquet, and so on, are also supported.
Additionally, you can also create and use custom data sources.

In Spark 2.0, the main benefit of using SQL, DataFrames, and Datasets is that it's easier to program using these high-level programming interfaces while reaping the benefits of improved performance, automatically.

The Dataset API was first added to Spark 1.6 to provide the benefits of both RDDs and the Spark SQL's optimizer.
A Dataset can be constructed from JVM objects and then manipulated using functional transformations such as `map`, `filter`, and so on.
As the Dataset is a collection of strongly-typed objects specified using a user-defined case class, both syntax errors and analysis errors can be detected at compile time.

### Understanding the Catalyst optimizer

The Catalyst optimizer is at the core of Spark SQL and is implemented in Scala.

## Using Spark SQL for Processing Structured and Semistructured Data

Spark provides easy and standard structures (that is, RDDs and DataFrames/Datasets) to work with both structured and semistructured data.
We include some of the data sources that are most commonly used in big data applications, such as, relational data, NoSQL databases, and files (CSV, JSON, Parquet, and Avro).
Spark also allows you to define and use custom data sources.

### Understanding data sources in Spark applications

Architects and developers need to understand which data stores to use in order to best meet their processing requirements.

### Selecting Spark data sources

Typically, it is better to use Spark to read the data, perform aggregations, and so on, and then write the results out to a database that serves end users.

### Using Spark with JSON data

There is no need for defining the schema for the JSON data, as the schema is automatically inferred.
In addition, Spark greatly simplifies the query syntax required to access fields in complex JSON data structures.

### Using Spark with Parquet files

Apache Parquet is a popular columnar storage format.
It is used in many big data applications in the Hadoop ecosystem.
Parquet supports very efficient compression and encoding schemes that can give a significant boost to the performance of such applications.

In the next step, we create a DataFrame from the Parquet file using just one statement:
```
scala> val reviewsParquetDF = spark.read.parquet("file:///Users/aurobindosarkar/Downloads/amazon_reviews/parquet/part-00000-3b512935-ec11-48fa-8720-e52a6a29416b.snappy.parquet")
```

After the DataFrame is created, you can operate on it as you normally would with the DataFrames created from any other data source.
Here, we register the DataFrame as a temp view and query it using SQL:

## Using Spark SQL for Data Exploration

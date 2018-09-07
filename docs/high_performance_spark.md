# High Performance Spark

## Chapter 3

Spark SQL and its DataFrames and Datasets interfaces are the future of Spark performance, with more efficient storage options, advanced optimizer, and direct operations on serialized data.
These components are super important for getting the best of Spark performance.

These are relatively new components; Datasets were introduced in Spark 1.6, DataFrames in Spark 1.3, and the SQL engine in Spark 1.0.

Like RDDs, DataFrames and Datasets represent distributed collections, with additional schema information not found in RDDs.
This additional schema information is used to provide a more efficient storage layer (Tungsten), and in the optimizer (Catalyst) to perform additional optimizations.
Beyond schema information, the operations performed on Datasets and DataFrames are such that the optimizer can inspect the logical meaning rather than arbitrary functions.
DataFrames are Datasets of a special `Row` object, which doesn't provide any compile-time type checking.
The strongly typed Dataset API shines especially for use with more RDD-like functional operations.
Compared to working with RDDs, DataFrames allow Spark's optimizer to better understand our code and our data, which allows for a new class of optimizations we explore in "Query Optimizer".

### Getting Started with the `SparkSession` (or `HiveContext` or `SQLContext`)

Much as the `SparkContext` is the entry point for all Spark applications, and the `StreamingContext` is for all streaming applications, the `SparkSession` serves as the entry point for Spark SQL.

If you are using the Spark Shell you will automatically get a `SparkSession` called `spark` to accompany the `SparkContext` called `sc`.

Scala's type alias of `DataFrame = Dataset[Row]` is broken in Java - you must use `Dataset<Row>` instead.

`SparkSession` is generally created using the builder pattern, along with `getOrCreate()`, which will return an existing session if one is already running.

### Basics of Schemas

The schema information, and the optimizations it enables, is one of the core differences between Spark SQL and core Spark.
Inspecting the schema is especially useful for DataFrames since you don't have the templated type you do with RDDs or Datasets.
Schemas are normally handled automatically by Spark SQL, either inferred when loading the data or computed based on the parent DataFrames and the transformation being applied.

DataFrames expose the schema in both human-readable or programmatic formats.
`printSchema()` will show us the schema of a DataFrame and is most commonly used when working in the shell to figure out what you are working with.
This is especially useful for data formats, like JSON, where the schema may not be immediately visible by looking at only a few records or reading a header.
For programmatic usage, you can get the schema by simply calling `schema`, which is often used in ML pipeline transformers.

In addition to the human-readable schema, the schema information is also available for you to use programmatically.
The programatic schema is returned as a `StructField`.

The first part is a `StructType`, which contains a list of fields.
It's important to note you can nest `StructType`s, like how a case class can contain additional case classes.
The fields in the `StructType` are defined with `StructField`, which specifies the name, type, and a Boolean indicating if the field may be null/missing.

### DataFrame API

Spark SQL's DataFrame API allows us to work with DataFrames without having to register temporary tables or generate SQL expressions.
The DataFrame API has both transformations and actions.
The transformations on DataFrames are more relational in nature, with the Dataset API offering a more functional-style API.

#### Transformations

Transformations on DataFrames are similar in concept to RDD transformations, but with a more relational flavor.
Instead of specifying arbitrary functions, which the optimizer is unable to introspect, you use a restricted expression syntax so the optimizer can have more information.
As with RDDs, we can broadly break down transformations into simple single DataFrame, multiple DataFrame, key/value, and grouped/windowed transformations.

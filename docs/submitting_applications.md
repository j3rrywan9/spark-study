# Submitting Applications

The `spark-submit` script in Spark's bin directory is used to launch applications on a cluster.
It can use all of Spark's supported cluster managers through a uniform interface so you don't have to configure your application especially for each one.

## Bundling Your Application's Dependencies

If your code depends on other projects, you will need to package them alongside your application in order to distribute the code to a Spark cluster.
To do this, create an assembly jar (or "uber" jar) containing your code and its dependencies.
Both sbt and Maven have assembly plugins.
When creating assembly jars, list Spark and Hadoop as `provided` dependencies; these need not be bundled since they are provided by the cluster manager at runtime.
Once you have an assembled jar you can call the `bin/spark-submit` script as shown here while passing your jar.

## Launching Applications with spark-submit

Once a user application is bundled, it can be launched using the `bin/spark-submit` script.
This script takes care of setting up the classpath with Spark and its dependencies, and can support different cluster managers and deploy modes that Spark supports:
```bash
./bin/spark-submit \
  --class <main-class> \
  --master <master-url> \
  --deploy-mode <deploy-mode> \
  --conf <key>=<value> \
  ... # other options
  <application-jar> \
  [application-arguments]
```
Some of the commonly used options are:
* `--class`: The entry point for your application
* `--conf`: Arbitrary Spark configuration property in key=value format.
For values that contain spaces wrap "key=value" in quotes (as shown).
* `application-jar`: Path to a bundled jar including your application and all dependencies.
The URL must be globally visible inside of your cluster, for instance, an `hdfs://` path or a `file://` path that is present on all nodes.

## References

* [Submitting Applications](https://spark.apache.org/docs/latest/submitting-applications.html)

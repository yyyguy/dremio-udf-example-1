# dremio-udf-example
An example of a user defined function deployed in Dremio 15.x

# Background

Dremio user defined functions (UDF) are implemented within the Gandiva execution engine. For some background on this topic, see:

- https://arrow.apache.org/blog/2018/12/05/gandiva-donation/
- https://www.dremio.com/adding-a-user-define-function-to-gandiva

NOTE: UDFs are not officially supported by Dremio, meaning you cannot raise a case with Dremio Support and expect them to help you with it. Assistance can only be made for a UDF in the form of billable Professional Services work.

# Requirements

To compile this source code, the following are required:

- Java JDK 1.8
- Maven 3.x
- Git
- A working Dremio 15.x or newer cluster for testing

# Usage

Step 1. Clone this git repo

Clone this git repo with the commands:

     $ git clone https://github.com/gregpalmr/dremio-udf-example

     $ cd dremio-udf-example

Step 2. Compile the source code

Use the following commands to compile the Java source code:

     $ mvn clean install -DskipTests

Upon a successful build the UDF's jar file will be place in the targets directory:

    $ ls ./target/udf-string-agg-1.0.0.jar

# Step 3. Copy the UDF's jar file to the Dremio Coordinator and Executor nodes

If you are running Dremio as a "stand-alone" installation (on 1 or more servers or cloud instances), use scp or your favorate file copying utility to copy the udf-string-agg-1.0.0.jar file to every Dremio Coordinator and Executor node. Place the jar file in the Dremio 3rd party jars directory, which is usually found here:

     $ ls /opt/dremio/jars/3rdparty/

If you are running Dremio on a Kubernetes cluster, then you must copy the udf-string-agg-1.0.0.jar file to the Docker container and save the container as a new image. Then upload that new image to your private container repository. The following commands may be used:

     $ docker run dremio/dremio-oss

     From a different command shell, copy the file to the Docker container

     $ docker cp ./target/udf-string-agg-1.0.0.jar <CONTAINER_ID>:/opt/dremio/jars/3rdparty/

     $ docker commit <CONTAINER_ID> <new image name>:<tag>

     $ docker push <hub-user>/<repo-name>:<tag>

Then modify the Dremio helm chart values.yaml file to use the new iamge tag.

$ Step 4. Restart all Dremio nodes

If you are running Dremio as a "stand-alone" installation (on 1 or more servers or cloud instances), then use the sysetmctl command to restart all of the Dremio Coordinator nodes and Executor nodes. Use this command on each node:

     $ systemctl restart dremio

If you are running Dremio on a Kubernetes cluster, then use the helm chart to restart all the Dremio pods. Use a command like this:

     $ helm upgrade my-dremio-cluster dremio_v2 -f values.dremio.yaml --namespace dremio


$ Step 5. Test the UDF

After restarting the Dremio cluster, run a test SQL command to see the results of the string_agg UDF. Like this:

   SQL> SELECT string_agg(name, ',') FROM sys.options

---

Direct comments or questions to greg@dremio.com

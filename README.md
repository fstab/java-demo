Java Hello World
================

Java Demo Application for Kubernetes.

Overview
--------

The demo runs on HTTP port 8080, and provides the current system environment variables formatted as an ASCII table:

![Screen Shot](screenshot.png)

This is useful for exploring the environment of a Kubernetes pod. For example, the `HOSTNAME` variable tells which pod is serving the request.

Build
-----

Option 1: Build the Docker image explicitly:

```sh
mvn package
docker build -t fstab/java-demo .
```

Option 2: Build using the Docker maven plugin:

```sh
mvn package docker:build
```

A pre-built Docker image is available on [fstab/java-demo](https://hub.docker.com/r/fstab/java-demo/).

Run
---

Test locally:

```sh
docker run -p8080:8080 --rm fstab/java-demo
```

Deploy on Kubernetes

```yaml
kubectl create -f java-demo.yaml
```

The yaml file references the Docker image [fstab/java-demo](https://hub.docker.com/r/fstab/java-demo/). If you create your own image, update the image location in the yaml file.

Test
----

Test locally:

View [http://localhost:8080](http://localhost:8080).

Test on Kubernetes:

1.  Get the service's cluster IP:
    ```bash
    export DEMO_SERVICE_IP=$(kubectl get service java-demo -o=jsonpath='{.spec.clusterIP}')
    ```
2.  Access the pods through the service's cluster IP:
    ```bash
    curl $DEMO_SERVICE_IP
    ```

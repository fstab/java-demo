Java Hello World
================

Demo Java application for Kubernetes

Build
-----

Option 1: Build the Docker image explicitly:

```sh
mvn package
docker build -t fstab/java-hello-world .
```

Option 2: Build using the Docker maven plugin:

```sh
mvn package docker:build
```

Run
---

Test locally:

```sh
docker run -p8080:8080 --rm fstab/java-hello-world
```

Deploy on Kubernetes

```yaml
kubectl create -f java-hello-world-deployment.yaml
```

Test
----

View [http://localhost:8080](http://localhost:8080).

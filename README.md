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
kubectl create -f java-hello-world.yaml
```

Test
----

Test locally:

View [http://localhost:8080](http://localhost:8080).

Test on Kubernetes:

1.  Get the service's cluster IP:
    ```bash
    export HELLO_WORLD_SERVICE_IP=$(kubectl get service java-hello-world -o=jsonpath='{.spec.clusterIP}')
    ```
2.  Access the pods through the service's cluster IP:
    ```bash
    curl $HELLO_WORLD_SERVICE_IP
    ```

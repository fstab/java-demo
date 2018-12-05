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

Kubernetes deployment descriptor:

```yaml
apiVersion: apps/v1
kind: Deployment
spec:
  replicas: 2
  template:
    spec:
      containers:
      - image: fstab/java-hello-world
        name: java-hello-world
        ports:
        - containerPort: 8080
```

Test
----

View [http://localhost:8080](http://localhost:8080).

# Spring boot 3.x native image exploration
This repository is just a collection of simple project to help building native images.

```
podman run -it --rm   \
	-v "$PWD":/opt/app:Z \
	-v "$HOME"/.m2:/root/.m2:Z \
	 docker.io/oviubiqube/graalvm17-maven-musl \
	 -Pnative clean native:compile -DskipTests
```

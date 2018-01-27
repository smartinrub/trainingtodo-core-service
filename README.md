# trainingtodo-core-service

## Generate trainingtodo-core-service jar file
```sh
brew install gradle
gradle clean
gradle build
```

## Create and run trainingtodo-core-service Docker image

```sh
docker build -t trainingtodo-core-service .
docker run -p 8080:8080 trainingtodo-core-service

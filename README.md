## Spring profiles

- `standalone` - to run `admin-server`, `catalogue-service`, `feedback-service`, `customer-app` and `manager-app` modules without Spring Cloud Eureka, Spring Cloud Config, Docker and Kubernetes.
- `cloud` - to run the `admin-server`, `eureka-server`, `catalogue-service`, `feedback-service`, `customer-app` and `manager-app` modules without Spring Cloud Config, Docker and Kubernetes.
- `cloudconfig` - to run the `admin-server`, `eureka-server`, `catalogue-service`, `feedback-service`, `customer-app` and `manager-app` modules without Docker and Kubernetes.
- `gateway` - to run `catalogue-service`, `feedback-service`, `customer-app` and `manager-app` modules behind Gateway APIs
- `native` - for running `config-server` module with configs from local directory
- `git` - for running `config-server` module with configs from git repository

## Infrastructure

### Keycloak

The project uses it as an OAuth 2.0/OIDC server for service authorization and user authentication.

Running in Docker:

```shell
docker run --name selmag-keycloak -p 8082:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -v ./config/keycloak/import:/opt/keycloak/data/import quay.io/keycloak/keycloak:23.0.7 start-dev --import-realm
```

### PostgreSQL

In the project it is used as a database of the catalog module.

Running in Docker:

```shell
docker run --name catalogue-db -p 5432:5432 -e POSTGRES_USER=catalogue -e POSTGRES_PASSWORD=catalogue -e POSTGRES_DB=catalogue postgres:16
```

### MongoDB

In the project it is used as a feedback module database.

Running in Docker:

```shell
docker run --name feedback-db -p 27017:27017 mongo:7
```

### Victoria Metrics

In the project, it is used to collect service metrics.

Running in Docker:

```shell
docker run --name selmag-metrics -p 8428:8428 -v ./config/victoria-metrics/promscrape.yaml:/promscrape.yaml victoriametrics/victoria-metrics:v1.93.12 -promscrape.config=/promscrape.yaml
```

### Grafana

In the project it is used to visualize metrics, logs and traces.

Running in Docker:

```shell
docker run --name selmag-grafana -p 3000:3000 -v ./data/grafana:/var/lib/grafana -u "$(id -u)" grafana/grafana:10.2.4
```

### Grafana Loki

In the project, it is used as a centralized log storage.

Running in Docker:

```shell
docker run --name selmag-loki -p 3100:3100 grafana/loki:2.9.4
```

### Grafana Tempo

In the project it is used as a centralized trace storage.

Running in Docker:

```shell
docker run --name selmag-tracing -p 3200:3200 -p 9095:9095 -p 4317:4317 -p 4318:4318 -p 9411:9411 -p 14268:14268 -v ./config/tempo/tempo.yaml:/etc/tempo.yaml grafana/tempo:2.3.1 -config.file=/etc/tempo.yaml
```

## FAQ

### Why the ip address 172.17.0.1?

This is the address of the host machine in a Docker bridge connection: all containers can access the host system at this address. If your system has a different address, change it in your configuration files to the correct one.

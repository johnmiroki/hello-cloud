## Config Server in One Word

In a broad stroke, the purpose of Config Server is to map configuration files in arbitrary formats, be it git repo (local or hosted), local files, databases, Vault and etc, to conventional http endpoints, for example http://config-server/application-name/profile/(git)label

## Experimenting Config Sources

### File System

https://cloud.spring.io/spring-cloud-config/reference/html/#_file_system_backend
The [part](https://cloud.spring.io/spring-cloud-config/reference/html/#_file_system_backend) of official document is rather vague. It took me much longer than expected to make it work. the key is to add placeholders explicitly for application, profile or label as {application}, {profile} and {label} respectively. eg:

```yaml
spring:
  profiles:
    active: native # turn on file system
  cloud:
    config:
      server:
        native:
          search-locations:
            - classpath:/config-repo/{application}/{label} 
            - classpath:/config-repo/{application}
```
and the config files folder structure is as follows:

    .
    ├── application-git.yml
    ├── application.yml
    └── config-repo
        ├── consumer-one
        │   ├── master
        │   │   ├── application-dev.properties
        │   │   └── application.properties
        │   └── ver2.0
        │       └── application-dev.properties
        └── consumer-two
            ├── application-dev.properties
            └── application.properties


config-repo, as the base dir for all config files excluding the ones for config-server itself, sits in /src/main/resources. the son level folders are used for application, grandson for label, and profiles lie in the config file names, eg application-{profile}.properties|yml|ymal

To access the `{application: consumer-one, profile: dev, label: master}`, we use `http://config-server:8888/consumer-one/dev/master`.

To access the `{application: consumer-one, profile: none, label: master}`, we use `http://config-server:8888/consumer-one/**default**/master`.
 Pay attention to the mapping conventions. 



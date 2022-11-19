# payara-micro
payara-micro demo project. 

### com.mysql.cj.jdbc.exceptions.CommunicationException : Communication link failure. 

> This type of exception can occur while deployment web server try to get a secure connection but the application has unsecured connection. 
> So, to allow unsecured connection also, we add the following  in  url used while connecting to mysql server.
>>"?useSSl=false&allowPublicKeyRetrieval=true"

### Error injecting: org.apache.maven.plugin.war.WarMojo
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <version>3.3.1</version>
</plugin>
```

### Payara Micro URLs: empty
```
<packaging>war</packaging> 
instead of jar
```  
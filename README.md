# militiaman
使用consul服务发现，config配置管理，rabbitmq实现消息代理，Zuul代理网关。
## consul 服务端
1、下载 consul https://www.consul.io/downloads.html	     
2、配置环境变量到目录 https://www.consul.io/intro/getting-started/install.html	     
3、简易模式启动 consul agent -dev    
## consul 客户端
1、pom 文件中添加依赖    
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-consul-dependencies</artifactId>
                <version>1.0.1.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
</dependencyManagement>
				<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-consul-discovery</artifactId>
        </dependency>

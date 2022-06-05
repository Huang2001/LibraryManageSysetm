# LibraryManageSysetm
总体设计：
将静态文件（图片，CSS，HTML，JS）放入Nginx，将jsp放入第一个Tomcat服务器，通过Nginx连接Tomcat；
后端接口采用微服务架构，接口通过springcloud Gateway组件统一路由，配置通过springcloud config统一管理，服务发现与注册采用Eureka

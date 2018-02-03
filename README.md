# YYMall-Distributed
这是分布式版本的在线商城项目，基于SOA架构。<br>
采用Dubbo作为SOA框架，把整个项目划分为消费者与生产者（即YYMall-Web、YYMall-Service以及YYMall-API）。<br>
采用Nginx作为负载均衡器，分发请求到Tomcat集群。<br>
采用Redis作为集中存储Session的缓存服务器，实现Session共享。<br>
采用6个Redis（3Master & 3Slave）作为缓存集群。<br>
vsftpd+Nginx搭建图片服务器。

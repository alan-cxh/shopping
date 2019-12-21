# Shopping

### shopping 服务配置信息

    
|   服务分类          | 服务名            | 依赖基础组件         |   端口                            | 备注          |
|--------------------|-------------------|---------------------|----------------|-------------|
||||
|  注册中心          | shopping-center    |                     | 8500(consul默认端口)            |  采用consul | 
|  单点登录          | shopping-sso-server |                 | 8183(consul默认端口)               |  采用consul | 


    
|  服务           |   服务名         |  端口     | 备注                                            |
|----------------|-----------------|-----------|-------------------------------------------------|
|  |
|  数据库         |   mysql         |  3306     |  目前各应用共用1个实例，各应用可建不同的database     |
|  KV缓存         |   redis         |  6379     |  目前共用，原则上各应用单独实例    |
|  消息中间件      |   rabbitmq      |  5672     |  共用                          |
|  注册与配置中心  |   nacos         |  8848     |  [启动和使用文档](./docs/register.md)             |
|  日志收集中间件  |   zipkin-server |  9411     |  共用                          |
|  搜索引擎中间件  |   elasticsearch |  9200     |  共用    |
|  日志分析工具    |   kibana        |  5601     |  共用    |
|  数据可视化工具  |   grafana       |  3000     |  共用    |


* [安装consule教程1](https://www.cnblogs.com/toov5/p/9912541.html)
* [安装consule教程2](https://www.jianshu.com/p/7d20dc58c9fc)
* 启动命令：./consul  agent -dev -ui -node=consul-dev -client=192.168.0.20

## 聚合项目打包
    使用idea打包时，在顶层父项目中无法添加任何的插件
    
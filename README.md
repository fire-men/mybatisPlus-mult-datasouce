# Mybatis-plus-multi-datasouce使用
mysql双主双从架构图
位置：classpath:mysql双主双从架构图.png

**mybatis-plus-多数据源约定**

1、本框架只做切换数据源 这件核心的事情，并不限制你的具体操作，切换了数据源可以做任何CRUD。

2、配置文件所有以下划线 _ 分割的数据源 首部 即为组的名称，相同组名称的数据源会放在一个组下。

3、切换数据源可以是组名，也可以是具体数据源名称。组名则切换时采用负载均衡算法切换。

4、默认的数据源名称为 master ，你可以通过 spring.datasource.dynamic.primary 修改。

5、方法上的注解优先于类上注解。

6、DS支持继承抽象类上的DS，暂不支持继承接口上的DS

**bug**
使用mybatis-plus的数据源使得mybatis-plus的逻辑删除失效
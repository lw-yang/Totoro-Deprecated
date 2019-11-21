# Totoro
Totoro is a mall system that uses SpringBoot+Vue

 基于商城系统的SpringBoot+Vue前后端分离全栈开发 

[![Build Status](https://travis-ci.org/lw-yang/Totoro.svg?branch=master)](https://travis-ci.org/lw-yang/Totoro)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/cc0446cdd4fc4a93bf14b17e59a01c0e)](https://www.codacy.com/manual/1670906161/Totoro?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=lw-yang/Totoro&amp;utm_campaign=Badge_Grade)
## Features
- `Totoro_v1.0`
    - 用户模块 ( Customer Module )
    - 分类模块 ( Classification Module )
    - 商品模块 ( Product Module )
    - 订单模块 ( Order Module )
    - 购物车模块 ( Shopping Cart Module )
- `Totoro_v2.0`
    - 商户模块 ( Merchant Module ) 
    - 评论模块 ( Comment Module )
    - 积分模块 ( Integration Module )
    - 支付模块 ( Payment Module )
- `Totoro_v2.5`
    - 后台管理 ( Background Management )
- `Totoro_v3.0`
    - 资讯模块 ( Information Module )
    - 聊天模块 ( Chat Module )

## Quickstart
👉  Get started with the following commands:
```shell script
git clone https://github.com/lw-yang/Totoro.git
```
### database
First you need to config the jdbc connection in pom.xml(root)
```
<properties>
	<!--jdbc connection configuration-->
	<jdbc.driver>com.mysql.jdbc.Driver</jdbc.driver>
	<jdbc.url>jdbc:mysql://localhost:3306/totoro?serverTimezone=UTC</jdbc.url>
	<jdbc.username>root</jdbc.username>
	<jdbc.password>123456</jdbc.password>
</properties>
```
Then you can run the maven plugin to create tables
```shell script
cd Totoro
mvn flyway:migrate
```
### front-end page
```shell script
#npm install -g cnpm --registry=https://registry.npm.taobao.org
cd Totoro/totoro-vue
npm install
npm run serve
```
### back-end service
```shell script
cd Totoro
mvn install
mvn clean package
java -Dfile.encoding=UTF-8 -jar boot/target/boot-0.0.1-SNAPSHOT-exec.jar
```
## Technical
- `Vue`  前端MVVM框架，包括使用Vue Router、VueX
- `Vant`  基于vue的移动端UI组件库，对比几个前端UI框架（cube-ui、Mint UI、vonic、vux）最后选择了Vant
- `Axios` 基于Promise的HTTP库
- `vue-element-admin` 后台管理模板


- `SpringBoot` 核心框架
- `Mybatis` 数据库ORM框架
- `MySql` 关系型数据库
- `Redis` 缓存
- `Mongodb` 可能用来存放文件等资源
- `Shiro` 权限管理
- `flyway` 数据库版本管理
- `Swagger2` Api接口文档
## Contact
- Bugs: [Issues](https://github.com/lw-yang/Totoro/issues)
- Email: 1670906161@qq.com (lwyang)
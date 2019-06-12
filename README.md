## 东软HIS医院管理系统 服务器端

NeuSoft hospital information system

东软睿道 - Java 互联网架构 - 实训项目

### 环境与工具

本后端项目所使用的环境与工具如下：

- Maven 包管理工具
- JDK 1.8
- SSM
    - Spring
        - 自动装配与控制反转
    - Spring MVC
        - 数据有效性校验
        - 数据回显
        - 异常处理
        - 拦截器
    - MyBatis
        - MyBatis Generator 生成 bean 与 SQL 语句
        - MyBatis 数据库连接池
        - PageHelper: MyBatis 的分页插件
- MySQL 关系型数据库
- AspectJ 面向切面编程扩展
- log4j 日志记录
- JUnit4 单元测试
- Redis
- Apache Shiro 用于身份验证的开源安全框架

前端项目请参见 `NeuSoft-Cloud-Hospital-FE` .

#### 数据库配置

数据库配置主要由 SpringBoot 完成，在 `src/main/resources` 目录的 `application.properties` 配置文件中。

因为使用了 MyBatis Generator，还需要在 `src/main/resources` 目录中需要添加 `db.properties` 进行数据库配置，**本仓库未包含该文件**。

以下是一个 `db.properties` 文件的样例：

```
# This file is only used during the testing phase and should not be included in the officially publicly released software.
# 驱动位置
driverLocation=
# 驱动
driver=com.mysql.cj.jdbc.Driver

# 数据库 URL
url=jdbc:mysql://cdb-7fud9x6s.bj.tencentcdb.com:10111

# 数据库用户名密码
username=root
password=password

# 初始连接数
initialSize=1
# 最大活跃连接
maxActive=20
# 最大空闲连接
maxIdle=20
# 最小空闲连接
minIdle=1
# 最大等待连接
maxWait=60000
```

#### MyBatis 生成 Bean 与 Dao

在 Intellij IDEA 中新建 Maven 项目，Command Line 一栏中填写 `mybatis-generator:generate -e`.

#### 部署

- 建议部署于 Linux，使用 Docker 分配资源


#### 开发工具

- 建议 WebStorm 与 Intellij IDEA

### JavaDoc

- 类和类的所有方法应有(中文)注释，包括类或方法的用途，各项参数和返回值的意义等。

### 数据库

- 敏感信息加密存储。
- 使用数据库连接池连接。
- 使用小写加下划线命名表和属性。

### Git 协作

- 在使用 `git` 的 `revert` 功能前，请确认您的确需要执行这步操作，它可能导致您的协作者的代码丢失。
- 推荐使用 Intellij IDEA 的版本控制工具，请不要将项目工程文件(例如 `NeuSoft-Cloud-Hospital.imi`)和代码编译生成的文件(例如`out`目录)上传到 Git 仓库中，除非是完全适用于您的协作者的文件。

### 文档

见`doc`目录下的文档。

### 项目过程

#### 评分标准

1. 尽量实现需求
2. 用户体验，可用性高
3. 软件测试完善，保证出错率很低
4. 使用新技术，折合为工作量

满分的标准不会超过使产品达到可售卖的水平。

#### 建议的项目流程

1. Axure 快速原型制作
2. 数据库设计：Navicat 或 Jetbrains DataGrip，数据库表中属性必须添加注释，注释中指定好各参数值；设计过程中不必指定外键，每个表有单独的 `int(11)` 类型的自增主键 `id`，约束尽量使用程序实现
3. 使用 Maven 搭建项目，使用 Git 团队协作
4. 单元测试：代码量可达到源代码的三分之一，主要是黑盒测试
5. 部署

#### 成果物

- 答辩 PPT
- 项目源代码
- 数据库设计

### 参考项目

- [安逸医院](
https://mingmliang.github.io/his-demo/#/home)

:-) 

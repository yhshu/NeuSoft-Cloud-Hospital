## 东软云医院 

NeuSoft-CloudHospital

### 环境与工具

#### 后端
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

#### 前端

- BootStrap

### JavaDoc

- 类和类的所有方法应有(中文)注释，包括类或方法的用途，各项参数和返回值的意义等。

### 数据库

- 敏感信息加密存储。
- 使用数据库连接池连接。
- 使用小写加下划线命名表和属性。

### Git 协作

- 在使用 `git` 的 `revert` 功能前，请确认您的确需要执行这步操作，它可能导致您的协作者的代码丢失。
- 推荐使用 Intellij IDEA 的版本控制工具，请不要将项目工程文件(例如 `NeuSoft-Cloud-Hospital.imi`)和代码编译生成的文件(例如`out`目录)上传到 Git 仓库中，除非是完全适用于您的协作者的文件。

### 其他

见`东软HIS医院管理系统-开发.md`。
# 简介

一套简单的，易于理解的 SpringBoot + Vue 前后端解决方案。

这是个轮子，也可以说不是一个轮子。

它有的功能，别的解决方案都有。

它的某些想法未经过实战验证，只是个尝试。

你想要的功能，它或许真没有。

它算是我工作的经验与总结吧。

# 技术体系

### 后端：

| 框架        | 说明                         | 官网                                                         |
| ----------- | ---------------------------- | ------------------------------------------------------------ |
| SpringBoot  | 容器+MVC框架                 | [https://spring.io/projects/spring-boot](https://gitee.com/link?target=https%3A%2F%2Fspring.io%2Fprojects%2Fspring-boot) |
| MybatisPlus | ORM框架                      | https://baomidou.com/                                        |
| Hutool      | 一个小而全的Java工具类库     | https://www.hutool.cn/                                       |
| Sa-Token    | 一个简单、优雅的权限控制框架 | https://sa-token.dev33.cn/                                   |

### 前端：

前端代码仓库： `https://gitee.com/siumu/xiumu-admin-ui`

| 框架 | 说明                   | 官网                     |
| ---- | ---------------------- | ------------------------ |
| Vue3 | 渐进式 JavaScript 框架 | https://v3.cn.vuejs.org/ |
|      |                        |                          |

## 项目结构

```lua
xiumu
├── sql -- 该项目的 sql 文件
├── xiumu-admin -- 后台管理系统通用解决方案
		└── config -- 配置类，例如 mybatisplus 分页配置，sa-token 拦截配置
		└── controller -- 控制层
		└── dao -- 持久层
		└── enums -- 枚举类
		└── exception -- 自定义异常
		└── pojo -- 领域对象，Entity, DO, DTO, Query 等
		└── service -- 业务层
├── xiumu-common -- 公共通用工具类库
		├── common-core -- 工具类封装
			    └── annotation -- 自定义注解
			    └── constants -- 全局常量
			    └── entity -- entity 基类
			    └── enums -- 枚举类
			    └── exception -- 全局异常处理
			    └── pages -- 分页参数封装
			    └── result -- 统一返回值
			    └── tree -- 树形结构生成工具
			    └── utils -- 其他工具类
├── xiumu-generator -- 一个简单的代码生成器模块
```

#### 模块说明：

**xiumu-common**

1. 这是一个公共模块，封装的都是一些常用的工具类，引入了 Hutool 
2. 该模块随着项目的越做越大，也会补充很多工具类，例如多数据源的配置，日志的配置，redis缓存等配置
3. 或许可以发展成一个单独的项目，作为本公司的技术沉淀，技术选型的统一。
4. 工具的统一也会避免一个项目使用三个json工具，三个POI工具，三个Http工具

**xiumu-generator**

1. 这是一个简单的，使用 `velocity` 根据模板来生成 POJO，dao，mapper，service，controller 层的项目
2. 目前功能简单，或许未来会把它完善成一个小项目，在线修改模板，在线生成类

# 项目功能

基本RBAC权限模型

1. 权限管理： 配置菜单权限与按钮权限
2. 角色管理：配置角色拥有的权限
3. 用户管理：配置用户信息以及用户的角色

没有字典，

没有监控，

没有岗位，

没有部门，

没有单点

# 开发规范

1. 领域对象 POJO ，专指只有 setter/getter/toString 的 简单类，在这里，Entity/DO/DTO/VO 统称为 POJO。

   + #### Entity

     + 通过 DAO 层向上传输数据源对象
     + 此对象与数据库表结构一一对应
     + 不能出现表中没有的字段
     + 不能出现与数据库无关的注解或者方法，比如 POI 注解， 参数校验注解

   + #### DO

     + 通过持久层向上传输数据源对象
     + 两个或多个表连接查询的对象, 将连表后的数据封装成 DO 返回
     + 命名规范：对象以 DO 结尾，正例: userDO， 反例: userDo

   + #### DTO

     + 数据传输对象。
     + 该对象一般用作接收前端传递的新增、修改的数据
     + 参数校验注解用在该对象上
     + 命名规范：对象以 DTO 结尾，正例: userDTO， 反例: userDto

   + #### Query

     + 数据查询对象，接收前端查询请求参数
     + 注意超过 2 个参数的查询需要封装
     + 命名规范：对象以 Query 结尾，正例: userQuery

   + #### VO

     + 显示层对象，通常是 controller 层向外传输的对象
     + 命名规范：对象以 VO 结尾，正例: userVO， 反例: userVo

2. Controller 控制层

   + 不可以在class上添加 `@RequestMapping` 注解来添加一个父路由，只能在方法上写全部路由

     反例：

     ```java
     @RequestMapping ("/department")
     public class DepartmentController {
     
         @GetMapping("/page")
         public ResponseDTO<List<DepartmentVO>> listDepartment() {
             return departmentService.listDepartment();
         }
     }
     ```

     正例：

     ```java
     public class DepartmentController {
     
         @GetMapping("/department/page")
         public ResponseDTO<List<DepartmentVO>> listDepartment() {
             return departmentService.listDepartment();
         }
     }
     ```

   + controller 负责协同和委派业务，充当路由的角色，每个方法要保持简洁

     + 不做任何的业务逻辑操作
     + 不做任何的业务校验，参数校验只允许使用@Valid 注解做简单的校验
     + 尽量不做任何的数据组合、拼装、赋值等操作

   + controller 层使用 restful 风格。URI 使用资源名称，而不是动作来描述。

     反例：

     ```java
     GET     /getUser/1    查询 ID 是 1 的用户
     POST    /createUser   新建一个用户
     PUT     /updateUser/1 修改 ID 是 1 的用户
     DELETE  /deleteUser/1 删除 ID 是 1 的用户
     ```

     正例

     ```java
     GET     /user/1 查询 ID 是 1 的用户
     POST    /user   新建一个用户
     PUT     /user/1 修改 ID 是 1 的用户
     DELETE  /user/1 删除 ID 是 1 的用户
     ```

3. Service 业务层

   + service 层方法命名遵循自解释原则，好的方法名可以直接简单明了的表示该方法的作用
   + 尽量少用 Wrapper 条件构造器，将 sql 写到 xml 中 做到 sql 与代码之间的隔离
   + 简单查询可以使用 Wrapper 条件构造器

4. Dao 持久层

   + 方法命名尽量以 sql 语义命名

   + 方法应当与业务无关

     正例：

     - 插入 insertXXX
     - 更新 updateXXX
     - 查询 selectXXX
     - 删除 deleteXXX
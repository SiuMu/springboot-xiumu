# 前言

有时候新创建一个项目挺麻烦的，写pom文件、建包、建类等总是这些步骤，还都一模一样，我就想能不能写一个通用的，到时候直接复制粘贴，不就很省事嘛。甚至把它升级成一个通用的后台框架模板。

> 当然我还很菜，肯定有不对的地方，只能摸索着慢慢来。反正闲着也是闲着，就试试呗。

## 项目分层结构

建项目，首先是要定项目分层结构，每一层都不能乱来。根据我浅显的经验和认知，我就先这么分吧：

- `controller:` 接收前端请求并输出相应的数据，负责协同和委派业务，充当路由的角色。
- `service:` 具体的业务处理，逻辑处理层。
- `manager:` 对 service 层通用能力的下沉，通用的业务处理。
- `dao:` 与数据库直接交互。
- `pojo:` 声明数据传输对象，领域模型对象。
- `utils:` 一些通用的工具类封装。
- `exception:` 全局异常处理相关
- `config:` 配置相关

## manager层是干嘛的

与常规的MVC分层不同，这里多了一个manager层。我们在项目中经常会遇到在service层中各个service类之间互相依赖，虽然springboot解决了循环依赖的问题，但是我总觉得这样不太好。后来我也是看了人家的手册和人家的分层结构，决定拾人牙慧，用上manager。我们可以把互相依赖的那部分方法作为通用方法放在manager层。然后各个service层只需要调用manager就可以了。大言不惭的说一声，这可能就是内聚吧。

## 领域模型POJO

- `POJO`: POJO 专指只有 setter/getter/toString 的简单类，包括 DO/DTO/VO 等

- `Entity`: 此对象与数据库表结构对应，通过 DAO 层向上传输数据源对象，放在entity包下。

- `DTO`: 数据传输对象，controller，service，manager层之间的数据传输对象。

- `VO`: controller层向显示层传输的对象。

- `Query`: 复杂的查询参数对象

### 1. 问题

关于pojo的使用总是有些混乱，每一个层都有自己对应的领域模型，过于追求每一层都用自己的领域模型，就会导致在一次请求中一个对象可能会出现3次甚至4次转换，当返回的时候同样也会出现3-4次转换。如果在开发中真的按照这么来，这种重复无用的逻辑实在是招人烦。

###  2. 最终方案

- controller层用于新增，修改或查询的参数可以使用DTO，VO或者Query来接收，用DTO或者VO来返回。该层不允许使用Entity。数据校验注解也不能出现在Entity中
- service，manager层可以使用DTO，VO，Query，Entity。但是DTO，VO，Query不允许传入DAO层，同理Entity不允许传入controller层

- 总的来说
DTO，VO，Query可以出现在controller，service，manager中；
Entity可以出现在Dao，manager，service中。


![输入图片说明](https://images.gitee.com/uploads/images/2021/1003/132419_3a1c864f_1806068.png "611384c204ece.png")

# 版本更新说明

我会把每一个版本打一个tag标签，希望我这个仓库标签越来越多，项目越做越大

## v1.0.0说明

该版本是初始版本，只给相应的分层建了相应的包名，以及一个demo类。

其中持久层引入了mybatisplus，jdbc。

工具类引入了Hutool-xx。这个工具包很好用，非常推荐

对象拷贝引入了MapStruct。它使用对象自己的set/get方法，效率比较高，推荐使用。

权限认证框架引入了Sa-Token，它用起来非常简单，方便，推荐使用。

该版本可以用于项目初始化。如果需要纯净的项目结构目录，自建类名，可以直接下载使用。


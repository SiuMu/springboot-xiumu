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

有关manager层，pojo领域对象规范等详细情况请查看[WIKI文档](https://gitee.com/siumu/springboot-xiumu/wikis/%E5%89%8D%E8%A8%80)

# 版本更新说明

我会把每一个版本打一个tag标签。选择不同的标签下载，方便我以及大家下载不同的版本。希望我这个仓库标签越来越多，项目越做越大

## v1.0.0说明

该版本是初始版本，只给相应的分层建了相应的包名，以及一个demo类。

其中持久层引入了mybatisplus，jdbc。

工具类引入了Hutool-xx。这个工具包很好用，非常推荐

对象拷贝引入了MapStruct。它使用对象自己的set/get方法，效率比较高，推荐使用。

权限认证框架引入了Sa-Token，它用起来非常简单，方便，推荐使用。

该版本可以用于项目初始化。如果需要纯净的项目结构目录，自建类名，可以直接下载使用。
## v1.1.0说明

该版本加入最简单的登录验证。

有时候项目的权限管理不需要那么强，只需要简单的登录验证就可以了，那么该版本就是加入了一个基础的登录验证。

使用全局异常处理来返回不同的错误码与错误信息非常好用，所以该版本也使用全局异常来处理错误。

当然权限框架是用的Sa-Token，简单好用，非常推荐。



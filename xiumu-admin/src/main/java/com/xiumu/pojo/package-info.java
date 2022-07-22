/**
 * 分层领域模型规约：<br/>
 * POJO: 专指只有 setter/getter/toString 的 简单类，在这里，Entity/DO/DTO/VO 统称为 POJO。<br/>
 * <br/>
 * <p>
 * Entity: 通过 DAO 层向上传输数据源对象  <br/>
 * 此对象与数据库表结构一一对应 <br/>
 * 不能出现表中没有的字段 <br/>
 * 不能出现与数据库无关的注解或者方法，比如 POI 注解， 参数校验注解。<br/>
 * <br/>
 * <p>
 * DO: 通过 DAO 层向上传输数据源对象。<br/>
 * 两个或多个表连接查询的对象, 将连表后的数据封装成 DO 返回。<br/>
 * 命名规范：对象以 DO 结尾，正例: userDO， 反例: userDo <br/>
 * <br/>
 * <p>
 * DTO: 数据传输对象。<br/>
 * 该对象一般用作接收前端传递的新增、修改的数据。<br/>
 * 参数校验注解用在该对象上。<br/>
 * 命名规范：对象以 DTO 结尾，正例: userDTO， 反例: userDto <br/>
 * <br/>
 * <p>
 * Query: 数据查询对象，接收前端查询请求参数。注意超过 2 个参数的查询需要封装<br/>
 * 命名规范：对象以 Query 结尾，正例: userQuery <br/>
 * <p>
 * <br/>
 * VO: 显示层对象，通常是 controller 层向外传输的对象。<br/>
 * 命名规范：对象以 VO 结尾，正例: userVO， 反例: userVo <br/>
 */
package com.xiumu.pojo;
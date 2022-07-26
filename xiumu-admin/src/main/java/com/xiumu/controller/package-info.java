/**
 * controller 层使用 restful 风格。不做任何的业务逻辑操作<br/>
 * URI 使用资源名称，而不是动作来描述：<br/>
 * 错误命名: <br/>
 * GET     /getUser/1    查询 ID 是 1 的用户<br/>
 * POST    /createUser   新建一个用户<br/>
 * PUT     /updateUser/1 修改 ID 是 1 的用户<br/>
 * DELETE  /deleteUser/1 删除 ID 是 1 的用户<br/>
 * 正确命名:<br/>
 * GET     /user/1 查询 ID 是 1 的用户<br/>
 * POST    /user   新建一个用户<br/>
 * PUT     /user/1 修改 ID 是 1 的用户<br/>
 * DELETE  /user/1 删除 ID 是 1 的用户<br/>
 * 注意：get 请求不能将参数放在 body 中, 有可能会被忽略 </br>
 * 待讨论：<br/>
 * 理论上 URI 不应该有动作，但是分页查询与全部查询如何区分？<br/>
 * /user/page 与  /user , page 算是动作吗？
 */
package com.xiumu.controller;
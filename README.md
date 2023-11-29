## 本项目实现的最终作用是基于JSP航班机票订票网站
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 查看用户信息
 - 查看订单
 - 添加航班
 - 留言管理
 - 管理员登录
 - 航班列表
### 第2个角色为用户角色，实现了如下功能：
 - 查看订单
 - 查询航班
 - 用户登录
 - 留言板
 - 订票
## 数据库设计如下：
# 数据库设计文档

**数据库名：** plane_ticket_book

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [admin_user](#admin_user) | 管理员用户表 |
| [common_user](#common_user) | 用户表 |
| [flight](#flight) | 航班信息 |
| [t_order](#t_order) |  |
| [user_message](#user_message) |  |

**表名：** <a id="admin_user">admin_user</a>

**说明：** 管理员用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | user |   varchar   | 16 |   0    |    N     |  Y   |       | 管理员用户名  |
|  2   | pwd |   varchar   | 255 |   0    |    N     |  N   |       | 管理员密码  |

**表名：** <a id="common_user">common_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | user_name |   varchar   | 16 |   0    |    N     |  Y   |       | 用户名  |
|  2   | user_pwd |   varchar   | 255 |   0    |    N     |  N   |       | 用户密码  |
|  3   | avatar_img |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | city |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 城市名称  |
|  5   | sfz |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  7   | email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 邮箱  |
|  8   | QQ |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | QQ号码  |

**表名：** <a id="flight">flight</a>

**说明：** 航班信息

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | f_n |   varchar   | 6 |   0    |    N     |  Y   |       | 航班号  |
|  2   | f_s_p |   varchar   | 4 |   0    |    N     |  N   |       | 航班起点  |
|  3   | f_e_p |   varchar   | 4 |   0    |    N     |  N   |       | 航班终点  |
|  4   | f_s_a |   varchar   | 12 |   0    |    N     |  N   |       | 航班起飞机场  |
|  5   | f_a_a |   varchar   | 12 |   0    |    N     |  N   |       | 航班到达机场  |
|  6   | f_d_t |   varchar   | 5 |   0    |    N     |  N   |       | 起飞(departure)时间  |
|  7   | f_a_t |   varchar   | 5 |   0    |    N     |  N   |       | 到达时间  |
|  8   | f_f_c_p |   int   | 10 |   0    |    N     |  N   |       | 头等舱价格Firstclassprice  |
|  9   | f_s_c_p |   int   | 10 |   0    |    N     |  N   |       | 商务舱价格  |
|  10   | f_t_c_p |   int   | 10 |   0    |    N     |  N   |       | 经济舱价格  |

**表名：** <a id="t_order">t_order</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | order_user |   varchar   | 255 |   0    |    N     |  N   |       | 下单用户  |
|  3   | f_n |   varchar   | 255 |   0    |    N     |  N   |       | 航班号  |
|  4   | p_name |   varchar   | 255 |   0    |    N     |  N   |       | 乘客姓名  |
|  5   | date |   varchar   | 255 |   0    |    N     |  N   |       | 订单日期  |
|  6   | grade |   varchar   | 255 |   0    |    N     |  N   |       | 舱别  |
|  7   | p_id |   varchar   | 255 |   0    |    N     |  N   |       | 乘客身份证号  |
|  8   | contact |   varchar   | 255 |   0    |    N     |  N   |       | 联系人  |
|  9   | c_p |   varchar   | 255 |   0    |    N     |  N   |       | 联系人电话  |
|  10   | status |   int   | 10 |   0    |    N     |  N   |   0    |   |

**表名：** <a id="user_message">user_message</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | time |   varchar   | 255 |   0    |    N     |  N   |       | 时间日期  |
|  3   | user_name |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  4   | message_content |   text   | 65535 |   0    |    N     |  N   |       |   |

**运行不出来可以微信 javape 我的公众号：源码码头**

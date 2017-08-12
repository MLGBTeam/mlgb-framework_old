# mlgb-framework

模块分类

1. authorization:权限管理

   1. api:登录接口、角色、用户管理等
   1. shiro:shiro权限配置

1. core:工具包、通用基类

1. persistence:持久层（目前只用mybatis）

   1. datasource:数据源配置
   1. mybatis:mybatis框架配置

1. starter:启动配置

1. system:系统模块

1. web:web、mvc配置




#### .gitignore 文件不起作用

先在`Terminal`中运行
```git
git rm -r -f --cached .
```
再运行
```git
git add .
```

#### git 提交空文件夹

在目录下添加.gitignore文件,内容如下：

```git
# Ignore everything in this directory 
* 
# Except this file !.gitignore 
```

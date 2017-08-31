# SoftBlog
一个基于j2EE开发的轻博客项目(未使用框架)<br>
项目总共由三个人完成，包括的功能有登录注册，写文章，修改个人信息，浏览文章等，由于一些特殊原因，在好友这一模块并没有如期实现，请多多见谅<br>
### 本人负责的模块
本人参与到数据库的设计、Dao 层的封装、界面交互的设计。<br>
主要负责写用户信息模块，还有文章信息呈现的模块<br>
service层：BloggerInformationService,LoginService<br>
action 层：AjaxRegisterAction,ArticleAction,LoginAction,PageAction(实现分页呈现文章列表)，RegisterAction，UpLoad（上传图片）

### 项目使用方法
1. 下载导入eclipse
2. navicat中运行sql文件
3. 将项目部署到tomcat运行即可
### 后记
这是我们第一次做项目，一切都是在探索中进行，项目中有很多不尽人意的地方，比如功能没有实现完全，代码有些冗余，分层思想没彻底理解好等。但总归迈出了第一步，相信下次可以做的更好。

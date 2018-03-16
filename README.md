# auto-ant
自动蚂蚁，自动游走者，乃最大者。

# 更新<br />
2018/03/16 更新 <br />
1.升级chrome到65.0.3325.162版本（最新版本）。<br />
2.升级chromedriver到2.36版本（最新版本）。<br />
3.添加百度送花功能。<br />
4.修复chrome模拟手机端bug。<br />
5.修复头条改版引起的登录bug。<br />
6.修复浏览器退出而driver仍然驻守的bug。<br />

2017/9/1 更新 <br />
1.更新selenium到3.5.3，jar包更新。<br />
2.添加opera浏览器，添加firefox加载配置启动，实现自动翻墙<br />
3.修复头条登录bug，分享bug。<br />

2017/3/1 初始版<br />
1.实现百度自动登录、自动签到功能。<br />
2.实现微博自动登录、自动发微博功能。<br />
3.实现头条号自动登录、自动搜索关注、自动收藏和点赞、自动转发到微博和QQ空间功能。<br />
4.实现自动收发短信功能。<br />

# 功能计划
 1.百度<br />
 [1期] 自动登录（实现） ，自动签到（实现），自动送花（实现）<br />
 [2期] 自动回复，自动发帖，自动注册<br />
 [3期] 自动游走，收集内容<br />
 2.微博<br />
 [1期] 自动登录（实现），自动发微博（实现）<br />
 [2期] 自动加好友，自动注册<br />
 [3期] 自动游走，收集内容<br />
 3.头条号<br />
 [1期] 自动登录(包括微博、qq、手机)（实现），自动发头条（不打算实现）<br />
 [2期] 自动（搜索）关注、收藏、点赞等（实现），自动转发到微博（实现）、QQ空间（实现）、贴吧<br />
 [3期] 自动加好友，自动搜索排名<br />
 [4期] 自动游走，收集内容<br />
# 附属功能
 1.自动识别验证码（未能实现，可以接打码机）<br />
 2.自动收、发短信（已实现）<br />
 3.自动收、发邮件（发已实现，收已实现一半）<br />
# 要求
 1.切换浏览器User-Agent（没有实现）<br />
 2.切换代理IP（没有实现）<br />
# 技术
 1.Java 1.8.0<br />
 2.Selenium 3.5.3、WebDriver 2<br />
 3.需要的包可以到：https://pan.baidu.com/s/1o8OFOF4 下载 <br />
# 展望
 1.改用Maven构建项目<br />
 2.添加其他网站<br />
 3.兼容Linux，在Linux上自动运行<br />
 4.使用定时器，定时执行任务<br />
 5.日志分析<br />
 6.TimeSleep可以实现嵌入，非入侵代码<br />
 7.可以使用cucumber-jvm进行驱动开发<br />

# JavaWeb

# Web

## 概述

- 使用Java语言开发基于互联网的项目



#### 软件架构

* C/S： Client/Server 客户端/服务器端
   * 在用户本地有一个客户端程序，在远程有一个服务器端程序
   * 如：QQ，迅雷...
   * 优点：
     - 用户体验好
   * 缺点：
     - 开发、安装，部署，维护 麻烦
* B/S： Browser/Server 浏览器/服务器端
   * 只需要一个浏览器，用户通过不同的网址(URL)，客户访问不同的服务器端程序
   * 优点：

     - 开发、安装，部署，维护 简单
   * 缺点：
     - 如果应用过大，用户的体验可能会受到影响

     - 对硬件要求过高



## B/S架构

资源分类：

* 静态资源：
   * 使用静态网页开发技术发布的资源。
   * 特点：
     * 所有用户访问，得到的结果是一样的。
     * 如：文本，图片，音频、视频， HTML，CSS，JavaScript
     * 如果用户请求的是静态资源，那么服务器会直接将静态资源发送给浏览器。浏览器中内置了静态资源的解析引擎，可以展示静态资源
* 动态资源：
   * 使用动态网页技术发布的资源。
   * 特点：
     * 所有用户访问，得到的结果可能不一样。
     * 如：jsp/servlet，php，asp...
     * 如果用户请求的是动态资源，那么服务器会执行动态资源，转换为静态资源，再发送给浏览器
* 静态资源：
   * HTML：用于搭建基础网页，展示页面的内容
   * CSS：用于美化页面，布局页面
   * JavaScript：控制页面的元素，让页面有一些动态的效果



# HTML

## 概述

Hyper Text Markup Language 超文本标记语言，是最基础的网页开发语言

* 超文本：
			* 超文本是用超链接的方法，将各种不同空间的文字信息组织在一起的网状文本.
* 标记语言：
	* 由标签构成的语言。`<标签名称> `如 html，xml
	* 标记语言不是编程语言



## 快速入门

### 语法

- html文档后缀名 `.html` 或者 `.htm`
- 标签分为
  - 围堵标签：有开始标签和结束标签。如` <html> </html>`
  - 自闭和标签：开始标签和结束标签在一起。如 `<br/>`
- 标签可以嵌套：
  - 需要正确嵌套，不能你中有我，我中有你
    - 错误：`<a> <b> </a> </b>`
    - 正确：`<a> <b> </b> </a>`
- 在开始标签中可以定义属性。属性是由键值对构成，值需要用引号（单双都可）引起来
- html的标签不区分大小写，但是建议使用小写

```html
<html>
    
	<head>
		<title>title</title>
	</head>
    
	<body>
		<FONT color='red'>Hello World</font><br/>
		
		<font color='green'>Hello World</font>
	</body>
    
</html>
```



### 标签

- 文件标签：构成html最基本的标签
  - `html`：html文档的根标签
  - `head`：头标签，用于指定html文档的一些属性，引入外部的资源
  - `title`：标题标签
  - `body`：体标签
  - `<!DOCTYPE html>`：html5中定义该文档是html文档
  
- 文本标签：和文本有关的标签
  - `<!-- 注释内容 -->`：注释
  - `<h1> to <h6>`：标题标签
    
    - h1~h6:字体大小逐渐递减
  - `<p>`：段落标签
  - `<br>`：换行标签
  - `<hr>`：展示一条水平线
    
    - `color`：颜色
    - `width`：宽度
      - 数值：width='20' ,数值的单位，默认是 px(像素)
      - 数值%：占比相对于父元素的比例
       - `size`：高度
       - `align`：对其方式
       - `center`：居中
      - `left`：左对齐
    	* `right`：右对齐
  
  ```html
  <!--标题-->
  <h1>集团简介</h1>
  
  <!--分隔线，颜色-->
  <hr color="#ffd700">
  
  <!--分段-->
  <p>
      <!--    字体颜色，加粗，斜体-->
      <font color="FF0000">"中关村黑马程序员训练营"</font>、CSDN， 并委托<b><i>传智播客</i></b>进行教学实施的软件开发高端培训机构，致力于服务各大软件企业，解决当前软件开发技术飞速发展，
      而企业招不到优秀人才的困扰。
  <p/>
  
  <p>
      目前，“中关村黑马程序员训练营”已成长为行业“学员质量好、课程内容深、企业满意”的移动开发高端训练基地， 并被评为中关村软件园重点扶持人才企业。
  </p>
  
  <p>
      黑马程序员的学员多为大学毕业后，有理想、有梦想，想从事IT行业，而没有环境和机遇改变自己命运的年轻人。 黑马程序员的学员筛选制度，远比现在90%以上的企业招聘流程更为严格。任何一名学员想成功入学“黑马程序员”，
      必须经历长达2个月的面试流程，这些流程中不仅包括严格的技术测试、自学能力测试，还包括性格测试、压力测试、 品德测试等等测试。毫不夸张地说，黑马程序员训练营所有学员都是精挑细选出来的。百里挑一的残酷筛选制度确
      保学员质量，并降低企业的用人风险。
  </p>
  
  <p>
      中关村黑马程序员训练营不仅着重培养学员的基础理论知识，更注重培养项目实施管理能力，并密切关注技术革新， 不断引入先进的技术，研发更新技术课程，确保学员进入企业后不仅能独立从事开发工作，更能给企业带来新的技术体系和理念。
  </p>
  
  <p>
      一直以来，黑马程序员以技术视角关注IT产业发展，以深度分享推进产业技术成长，致力于弘扬技术创新，倡导分享、 开放和协作，努力打造高质量的IT人才服务平台。
  </p>
  
  <hr color="#ffd700">
  
  <!--字体颜色，大小-->
  <font color="gray" size="2">
      <!--    文字居中-->
      <center>
          江苏传智播客教育科技股份有限公司
          <p>
              版权所有Copyright 2006-2018, All Rights Reserved 苏ICP备16007882
          </p>
      </center>
  </font>
  
  ```
  
  - `<b>`：字体加粗
  - `<i>`：字体斜体
  - `<font>`：字体标签（废弃）
    - `color`：颜色
      - 英文单词：red,green,blue
      - `rgb(值1，值2，值3)`：值的范围：0~255  如  rgb(0,0,255)
      - `#值1值2值3`：值的范围：00~FF之间。如： #FF00FF
    - `size`：大小
    * `face`：字体
  - `<center>`：文本居中
  
- 图片标签：

  - `<img>`：展示图片
    - `src`：指定图片的位置
    - 相对路径 以 `.` 开头的路径
    - `./`：代表当前目录  `./image/1.jpg`
    - `../`：代表上一级目录

```html
<!--展示一张图片 img-->

<!--展示图片，右对齐，图片加载失败的时候显示“古镇”，图片宽256，高153-->
<img src="image/jingxuan_2.jpg" align="right" alt = "古镇" width="256" height="153">
```

- 列表标签：
  - 有序列表：
    - `ol`：列表
    - `li`：列表项
  - 无序列表：
    - `ul`：列表
    - `li`：列表项
- 链接标签：
  - `<a>`：定义一个超链接
    - `href`：指定访问资源的URL（统一资源定位符）
    - `target`：指定打开资源的方式
      - `_self`：默认值，在当前页面打开
      - `_blank`：在新的空白页面打开

```html

<!--定义超链接 img-->

<!--点击在当前页面打开新的网站-->
<a href="http://www.baidu.com" target="_self">百度</a>
<br>

<!--点击在新的空白页打开网站-->
<a href="http://www.baidu.com" target="_blank">百度2</a>
<br>

<!--点击跳转自己创建的其他网站-->
<a href="图片标签.html" target="_blank">图片标签</a>
<br>

<!--点击发送邮件-->
<a href="mailto:449062524@qq.com" target="_blank">联系我</a>
<br>

<!--点击图片跳转到网站-->
<a href="http://www.baidu.com" target="_blank"><img src="image/jiangxuan_2.jpg"></a>
<br>

```

- 块标签：
  - div：每一个div都占满一整行，块级标签
  - span：文本信息在一行显示，包裹作用，行内标签，内联标签
- 语义化标签：html5中为了提高程序的可读性，提供了一些标签，没有样式
  - `<header>`：页眉
  - `<footer>`：页脚
- 表格标签：
  - `<table>`：定义表格
    - `width`：宽度
    - `border`：边框
    - `cellpadding`：定义内容和单元格的距离
    - `cellspacing`：定义单元格之间的距离，如果为0，则单元格的线会合为一条
    - `bgcolor`：背景色
    - `align`：对齐方式
    
  - `<tr>`：定义行
    
    - `bgcolor`：背景色
    - `align`：对齐方式
    
  - `<th>`：定义表头单元格

    - `caption`：表格标题
    - `thead`：表示表格的头部分

    * `tbody`：表示表格的体部分

    - `tfoot`：表示表格的脚部分

  - `<td>`：定义单元格
    
    - `colspan`：合并列
    - `rowspan`：合并行

```html
<!--定义表格，边框，宽度，内容和单元格的距离，单元格之间的距离，背景色，对齐方式-->
<table border="1" width="50%" cellpadding="0" cellspacing="0" bgcolor="gray" align="center">
    
    <!--定义表格标题-->
    <caption>学生信息表</caption>
    
    <!--定义行-->
    <tr>
        <!--定义表头单元格,编号单元格占两行-->
        <th rowspan="2">编号</th>
        <th>姓名</th>
        <th>成绩</th>
    </tr>

    <tr>
        <!--定义单元格-->
        <td>小龙女</td>
        <td>100</td>
    </tr>

    <tr>
        <td>2</td>
        <!--杨过占两列-->
        <td colspan="2">杨过</td>
    </tr>

</table>
```

- 表单标签：
  - 用于采集用户输入的数据的，用于和服务器进行交互
  - 表单项中的数据要想被提交：必须指定其`name`属性
  - `<form>`：用于定义表单的，可以定义一个范围，范围代表采集用户数据的范围
    - `action`：指定提交数据的URL
    - `method`：指定提交方式
      - 分类：一共7种，2种比较常用
        - get：
          1. 请求参数会在地址栏中显示。会封装到请求行中（HTTP协议后讲解）
          2. 请求参数大小是有限制的。
          3. 不太安全。
        - post：
          1. 请求参数不会再地址栏中显示。会封装在请求体中（HTTP协议后讲解）
          2. 请求参数的大小没有限制。
          3. 较为安全。
- 表单项标签：
  - `<intput>`：可以通过`type`属性值，改变元素展示的样式
    - `type`
      - `text`：文本输入框，默认值
        1. `placeholder`：指定输入框的提示信息，当输入框的内容发生变化，会自动清空提示信息（）
      - `password`：密码输入框
      - `radio`：单选框
        1. 要想让多个单选框实现单选的效果，则多个单选框的name属性值必须一样
        2. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
        3. checked属性，可以指定默认值
      - `checkbox`：复选框
        1. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
        2. `checked`：可以指定默认值
      - `file`：文件选择框
      - `hidden`：隐藏域，用于提交一些信息
      - 按钮：
        1. `submit`：提交按钮，提交表单
        2. `button`：提交按钮，提交表单
        3. `image`：提交按钮，提交表单
           - `src`：指定图片路径
  - `<label>`：指定输入项的文字描述信息
    - `<label>`的`for`属性一般会和 `<input>` 的 `id`属性值对应。如果对应了，则点击`<label>`区域，会让`<input>`输入框获取焦点。
  - `<select>`: 下拉列表
    - `option`：子元素，指定列表项
  - `<textarea>`：文本域
    - `cols`：指定列数，每一行有多少个字符
    - `rows`：默认多少行



#### 表格案例

![image-20200926013150222](https://i.loli.net/2020/09/26/a1XyHWcxYMAGQud.png)

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>表格作业</title>
</head>

<body>
<table border="1" width="50%"  align="center" cellspacing="0" cellpadding="5">

    <caption>学生信息表</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>成绩</th>
    </tr>
    </thead>

    <tbody>
    <tr align="center">
        <td>1</td>
        <td>小龙女</td>
        <td>女</td>
        <td>100</td>

    </tr>

    <tr align="center">
        <td>2</td>
        <td>杨过</td>
        <td>男</td>
        <td rowspan="2">90</td>
    </tr>

    <tr align="center">
        <td>3</td>
        <td>金轮法王</td>
        <td>男</td>
    </tr>

    <tr align="center">
        <td>总成绩</td>
        <td colspan="3">90</td>
    </tr>
    </tbody>


</table>

</body>

</html>
```



### 表单案例

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>HTML注册页面</title>
    </head>
    <body>

        <form action="#" method="post">
            <table border="1" width="500" align="center">
                <tr>
                    <td><label for="username">用户名</label></td>
                    <td><input type="text" name="username" id="username"></td>
                </tr>

                <tr>
                    <td><label for="password">密码</label></td>
                    <td><input type="password" name="password" id="password"></td>
                </tr>

                <tr>
                    <td><label for="E-mail">E-mail</label></td>
                    <td><input type="text" name="E-mail" id="E-mail"></td>
                </tr>

                <tr>
                    <td><label for="name">姓名</label></td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>

                <tr>
                    <td><label for="tel">手机</label></td>
                    <td><input type="text" name="tel" id="tel"></td>
                </tr>

                <tr>
                    <td><label>性别</label></td>
                    <td><input type="radio" name="gender" value="male">男
                        <input type="radio" name="gender" value="female">女
                    </td>
                </tr>

                <tr>
                    <td><label for="birthday">出生日期</label></td>
                    <td><input type="date" name="birthdate" id="birthday"></td>
                </tr>

                <tr>
                    <td><label for="checkCode">验证码</label></td>
                    <td><input type="text" name="checkCode" id="checkCode">
                        <img src="../img注册/verify_code.jpg">
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="注册"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
```





# CSS

## 概述

Cascading Style Sheets 层叠样式表

- 层叠：多个样式可以作用在同一个html的元素上，同时生效
- 功能强大
- 将内容展示和样式控制分离
  - 降低耦合度，解耦
  - 让分工协作更容易
  - 提高开发效率



## CSS的使用

### CSS与html结合方式

- 内联样式
  - 在标签内使用style属性指定css代码
  - 如：`<div style="color:red;">hello css</div>`
- 内部样式
  - 在head标签内，定义style标签，style标签的标签体内容就是css代码

```css
<style>
div{
    color:blue;
}

</style>
<div>hello css</div>
```

- 外部样式
  - 定义css资源文件
  - 在head标签内，定义link标签，引入外部的资源文件

```css
a.css文件：
div{
    color:green;
}

<!--导入方式1-->
.html文件:
<link rel="stylesheet" href="a.css">

<!--导入方式2-->
<style>
	@import"a.css";
</style>
```



### 语法

- 格式：

```css
选择器 {
    属性名1:属性值1;
    属性名2:属性值2;
    ...
}
```

- 选择器：筛选具有相似特征的元素
- 每一对属性需要使用`;`隔开，最后一对属性可以不加`;`



### 选择器

筛选具有相似特征的元素

- 基础选择器
  - id选择器：选择具体的id属性值的元素，建议在一个html页面中id值唯一（优先级最高）
    - 语法：`#id属性值{}`
  - 类选择器：选择具有相同的class属性值的元素
    - 语法：`.class属性值{}`
    - id选择器选择器优先级高于类选择器
  - 元素选择器：选择具有相同标签名称的元素（优先级最低）
    - 语法： `标签名称{}`
    - 类选择器优先级高于元素选择器

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>选择器</title>
        <style>
            #div1{
                color: chocolate;
            }

            div{
                color: yellow;
            }

            .cls1{
                color: deeppink;
            }
        </style>
    </head>
    <body>

        <div id="div1">传智播客</div>
        <div>黑马程序员</div>

        <p class=".cls1">船只大学</p>


    </body>
</html>
```

- 扩展选择器
  - 选择所有元素
    - 语法：` *{}`
  - 并集选择器
    - 语法：`选择器1,选择器2{}`
  - 子选择器：筛选选择器1元素下的选择器2元素
    - 语法：  `选择器1 选择器2{}`
  - 父选择器：筛选选择器2的父元素选择器1
    - 语法： ` 选择器1 > 选择器2{}`
  - 属性选择器：选择元素名称，属性名=属性值的元素
    - 语法：`元素名称[属性名="属性值"]{}`
  - 伪类选择器：选择一些元素具有的状态
    - 语法：`元素:状态{}`
    -  例如`<a>`状态：
         * `link`：初始化的状态
         * `visited`：被访问过的状态
         * `active`：正在访问状态
      			* `hover`：鼠标悬浮状态

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>选择器</title>
        <style>
            #div1{
                color: chocolate;
            }

            div{
                color: brown;
            }

            .cls1{
                color: darkblue;
            }

            div p{
                color: darkgreen;
            }

            div > p{
                border: 5px solid;
            }

            input[type="text"]{
                border: 5px solid;
            }

            a:link{
                color: pink;
            }
            a:hover{
                color: green;
            }
            a:active{
                color: yellow;
            }
            a:visited{
                color: red;
            }

        </style>
    </head>
    <body>
        <!--id选择器-->
        <div id="div1">传智播客</div>
        <!--元素选择器-->
        <div>黑马程序员</div>
        <!--类选择器-->
        <p class="cls1">船只大学</p>

        <!--子选择器-->
        <!--父选择器-->
        <div>
            <p>
                扩展选择器
            </p>
        </div>

        <p>子选择器对比</p>
        <div>父选择器对比</div>

        <br>

        <input type="text">
        <input type="password">

        <br>

        <!--伪类选择器-->
        <a href="#">伪类选择器</a>

    </body>
</html>
```



### 属性

- 字体、文本
    * `font-size`：字体大小
   * `color`：文本颜色
  * `text-align`：对其方式
  * `line-height`：行高 
- 背景
  -  `background`：
- 边框
  - `border`：设置边框，符合属性
- 尺寸
  - `width`：宽度
  - `height`：高度
- 盒子模型：控制布局
  - `margin`：外边距
  - `padding`：内边距
    - 默认情况下内边距会影响整个盒子的大小
  - `box-sizing: border-box;`  设置盒子的属性，让width和height就是最终盒子的大小
- float：浮动
  - left
  - right

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>属性</title>

        <style>
            p{
                /*font*/
                font-size: 50px;
                color: red;
                text-align: center;
                line-height: 200px;

                /*border*/
                border: 2px solid darkgreen;
            }

            .div3{
                border: 1px solid red;
                /*尺寸*/
                height: 300px;
                width: 300px;
                /*背景*/
                background: url("../image旅游网/jiangwai_1.jpg") no-repeat center;
            }

            div{
                border: 1px solid red;
            }
            .div1{
                width: 100px;
                height: 100px;
                margin: 50px;
            }
            .div2{
                width: 200px;
                height: 200px;
            }

        </style>

    </head>
    <body>

        <p>传智播客</p>
        <div class="div3"></div>

        <br>

        <div class="div2">
            <div class="div1">

            </div>
        </div>

    </body>
</html>
```



### 案例

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>CSS注册页面</title>

        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                background: url("../img注册/register_bg.png") no-repeat center;
                padding-top: 25px;
            }

            .rg_layout {
                width: 900px;
                height: 500px;
                border: 8px solid #EEEEEE;
                background-color: white;
                /*让div水平居中*/
                margin: auto;
            }

            .rg_left {
                /*border: 1px solid red;*/
                float: left;
                margin: 15px;
            }
            .rg_left > p:first-child{
                color: #FFD026;
                font-size: 20px;
            }
            .rg_left > p:last-child {
                color: #A6A6A6;
                font-size: 20px;
            }

            .rg_center {
                /*border: 1px solid red;*/
                float: left;
            }

            .rg_right {
                /*border: 1px solid red;*/
                float: right;
                margin: 15px;
            }
            .rg_right > p:first-child{
                font-size: 15px;
            }
            .rg_right p a{
                color: pink;
            }

            .td_left{
                width: 100px;
                text-align: right;
                height: 45px;
            }
            .td_right{
                padding-left: 50px;
            }
            #username,#password,#email,#name,#birthday,#tel,#checkcode
            {
                width: 251px;
                height: 32px;
                border: 1px solid #A6A6A6;
                /*设置边框圆角*/
                border-radius: 5px;
                padding-left: 10px;
            }
            #checkcode{
                width: 110px;
            }
            #img_check{
                height: 32px;
                vertical-align: middle;
            }
            #btn_sub{
                width: 150px;
                height: 40px;
                background-color: #FFD026;
                border: 1px solid #FFD026;
            }


        </style>
    </head>
    <body>

        <div class="rg_layout">
            <div class="rg_left">
                <p>
                    新用户注册
                </p>

                <p>
                    USER REGISTER
                </p>

            </div>

            <div class="rg_center">
                <div class="form">
                    <form action="#" method="post">
                        <table>
                            <tr>
                                <td class="td_left"><label for="username">用户名</label></td>
                                <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名"></td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="password">密码</label></td>
                                <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码"></td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="email">Email</label></td>
                                <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱"></td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="name">姓名</label></td>
                                <td class="td_right"><input type="text" name="name" id="name" placeholder="请输入姓名"></td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="tel">手机号</label></td>
                                <td class="td_right"><input type="text" name="tel" id="tel" placeholder="请输入手机号"></td>
                            </tr>

                            <tr>
                                <td class="td_left"><label>性别</label></td>
                                <td class="td_right">
                                    <input type="radio" name="gender" value="male"> 男
                                    <input type="radio" name="gender" value="female"> 女
                                </td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="birthday">出生日期</label></td>
                                <td class="td_right"><input type="date" name="birthday" id="birthday" placeholder="请输入出生日期"></td>
                            </tr>

                            <tr>
                                <td class="td_left"><label for="checkcode" >验证码</label></td>
                                <td class="td_right"><input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
                                    <img id="img_check" src="../img注册/verify_code.jpg" alt="">
                                </td>
                            </tr>


                            <tr>
                                <td colspan="2" id="btn_sub" align="center"><input type="submit" value="注册"></td>
                            </tr>
                        </table>
                    </form>
                </div>

            </div>

            <div class="rg_right">

                <p>
                    已有账号?
                    <a href="#">立即登陆</a>
                </p>

            </div>
        </div>

    </body>
</html>
```
















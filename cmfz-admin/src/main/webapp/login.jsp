<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <%--去除页面缓存--%>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="0">

    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
    <script type="text/javascript">

        $(function () {


            //点击更换验证码：
            $("#captchaImage").click(function () {//点击更换验证码

            });
            //  form 表单提交
            $(".loginButton").onclick = function () {
                //取消异步请求
                $("#loginForm").form({ajax: false});

                $('#loginForm').form('submit', {

                    onSubmit: function () {
                        return $("#loginForm").form("validate");
                    },
                });
            }
            /*ajax动态改变验证码*/
            $("#captchaImage").click(function () {
                document.getElementById("captchaImage").src = "${pageContext.request.contextPath}/getVcode?time=" + new Date().getTime();
            });

        });
    </script>
</head>
<body>
<div class="login">
    <form id="loginForm" action="${pageContext.request.contextPath}/manager/login" method="post">
        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="${pageContext.request.contextPath}/img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <%--获取中文cookie--%>

                <%!String managerName = ""; %>
                <%
                    Cookie[] cookies = request.getCookies();
                    for (int i = 0; i < cookies.length; i++) {
                        if (cookies[i].getName().equals("managerName")) {
                            managerName = cookies[i].getValue();
                            break;
                        }
                    }
                %>
                <td>
                    <input type="text" id="managerName" name="managerName" class="easyui-textbox text"
                           data-options="required:true" value="<%=URLDecoder.decode(managerName,"UTF-8") %>"
                           maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" id="managerPassword" name="managerPassword" class="easyui-textbox text"
                           data-options="required:true" value="" maxlength="20" autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="Vcode" class="text captcha easyui-textbox"
                           data-options="required:true" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/getVcode"
                         title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
                <td>
                    <label>
                        <input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true"/> 记住用户名
                    </label>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <%--<input type="button" class="homeButton" value="" onclick="location.href='/index.jsp'">--%>
                    <input type="submit" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>
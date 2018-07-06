<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                type: 'POST',
                dataType: "json",
                url: '${pageContext.request.contextPath}/accordion/getParentMenu',
                success: function (data) {
                    //i是下标，n是对象
                    $.each(data, function (i, n) {//加载父类节点即一级菜单
                        if (i == 0) {//显示第一个一级菜单下的二级菜单
                            $('#layout_west_accordion').accordion('add', {
                                title: n.text,
                                iconCls: n.iconCls,
                                selected: true,
                                //定义content,内容由下面二级异步加载的函数决定，这里必须要是text,因为下面一部需要根据
                                //这个text决定content的最终内容
                                content: '<div style="padding:10px"><ul name="' + n.text + '"></ul></div>',
                            });
                        } else {
                            $('#layout_west_accordion').accordion('add', {
                                title: n.text,
                                iconCls: n.iconCls,
                                selected: false,
                                content: '<div style="padding:10px"><ul name="' + n.text + '"></ul></div>',
                            });
                        }

                    });
                }
            });
            //异步加载子节点，即二级菜单
            $('#layout_west_accordion').accordion({
                onSelect: function (title, index) {
                    //与text想匹配，匹配成功后查询内容，tree默认拿的json数据格式就是id : text: 等，我们属性名设计的就是text`
                    $("ul[name='" + title + "']").tree({
                        url: '${pageContext.request.contextPath}/accordion/getMenuTree',
                        queryParams: {
                            text: title
                        },
                        animate: true,//定义节点在展开或折叠的时候是否显示动画效果。
                        lines: true,//显示虚线效果
                        //相当于给每一个content增加一个onclick事件
                        onClick: function (node) {// 在用户点击一个子节点即二级菜单时触发addTab()方法,用于添加tabs
                            if (node.url) {//判断url是否存在，存在则创建tabs
                                //node表示该节点对象，也就是getMenuTree返回的每一个对象
                                addTab(node);
                            }
                        }
                    });
                }
            });
            //addTab()函数
            /*增加选项卡面板*/
            function addTab(node) {
                var exists =  $("#tt").tabs('exists',node.text);
                //如果不存在
                if(!exists){
                    $("#tt").tabs("add",{
                        /*获取按钮的名称作为选项卡面板的名字*/
                        title:node.text,
                        /*动态包含*/
                        href:'${pageContext.request.contextPath}/'+node.url,
                        /*增加关闭X*/
                        closable:true
                    });
                }else {
                    $("#tt").tabs('select',node.text);
                }

            }
        });
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${sessionScope.managerName}
        &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>
        &nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 gaozhy@zparkhr.com.cn
    </div>
</div>
<%--2018-07-05右侧动态导航的实现--%>
<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="layout_west_accordion" class="easyui-accordion"
         data-options="fit:true,border:false,nimate:true,lines:true">

    </div>
</div>
<div data-options="region:'center'">
    <%--增加选项卡--%>
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    //为了查询和搜索框查询方法的复用性，这里给name进行初始赋值，初始值作为查询语句的判断条件
    // 所以值为数据库中的字段，第一次要不需要查询条件，所以value给了空字符串，用来模拟没有条件
    var name = "guru_id";
    var value="";
    $(function () {
        $('.datagridView').datagrid({
            title: '上师管理',
            remoteSort: false,
            singleSelect: true,
            //分页
            pagination: true,
            nowrap: false,
            fitColumns: true,
            url: '${pageContext.request.contextPath}/guru/guruJson?name='+name+'&&value='+value,
            columns: [[
                {field: 'guruId', title: 'guruId', width: 80},
                {field: 'guruName', title: 'guruName', width: 100, sortable: true},
                {field: 'guruImage', title: 'guruImage', width: 80, align: 'right', sortable: true},
                {field: 'guruIntroduction', title: 'guruIntroduction', width: 150, sortable: true},
            ]],

            //增加小工具条 --包含两个功能，一个是增加，一个是修改
            toolbar:"#tb",
            view: detailview,
            detailFormatter: function (index, row) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/main/image/' + row.guruImage + '" style="height:150px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Describe: ' + row.guruIntroduction + '</p>' +
                    '<p>Name: ' + row.guruName + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });
    /*增加法师*/
    function addGuru() {
        $(".dialog").dialog({
            width: 450,
            height: 280,
            href: '${pageContext.request.contextPath}/guruForm.jsp',
            buttons: [{
                text: 'upload',
                handler: function () {
                    $(".addGuru").form('submit', {
                        url: "${pageContext.request.contextPath}/upload/guruImage",
                        onSubmit: function () {
                            return true;
                        },
                        success: function (data) {
                            if ("success" == data) {//代表添加成功
                                $.messager.show({
                                    title: 'New Message',
                                    msg: 'you have uploaded ! success ',
                                    timeout: 3000,
                                    showType: 'slide'
                                });
                                $(".dialog").dialog("close");
                                $('.datagridView').datagrid("reload");
                            } else {
                                $.messager.show({
                                    title: 'New Message',
                                    msg: 'Uploaded Fail !!! ',
                                    timeout: 5000,
                                    showType: 'slide'
                                });
                            }
                        }
                    });
                }
            }, {
                text: 'close',
                handler: function () {
                    $(".dialog").dialog("close");
                }
            }],

        })
    }

    /*修改法师*/
    function updateGuru() {
        //选中的行作为对象rowData
        var rowData = $(".datagridView").datagrid("getSelected");
        $(".dialog").dialog({
            width: 500,
            height: 280,
            href: '${pageContext.request.contextPath}/guruUpdate.jsp',
            //将rowData的数据进行回显
            onLoad: function () {
                $(".guruUpdate").form("load", rowData);
            },
            //增加button 最大作用在于当点击update按钮时进行数据update
            buttons: [{
                text: 'update',
                handler: function () {
                    $(".guruUpdate").form('submit', {
                        url: "${pageContext.request.contextPath}/guru/update",
                        onSubmit: function () {
                            return true;
                        },
                        success: function (data) {
                            if ("success" == data) {//代表更新成功
                                $.messager.show({
                                    title: 'New Message',
                                    msg: 'you have update ! success ',
                                    timeout: 3000,
                                    showType: 'slide'
                                });
                                $(".dialog").dialog("close");
                                $('.datagridView').datagrid("reload");
                            } else {
                                $.messager.show({
                                    title: 'New Message',
                                    msg: 'Update Fail !!! ',
                                    timeout: 5000,
                                    showType: 'slide'
                                });
                            }
                        }
                    });
                }
            }, {
                text: 'close',
                handler: function () {
                    $(".dialog").dialog("close");
                }
            }]
        })

    }

    /*搜索函数*/
    function searchGuru(value,name){
        $('.datagridView').datagrid({
            url: '${pageContext.request.contextPath}/guru/guruJson?name='+name+'&&value='+value
        });
    }
    /*导出上师excel*/
    function exportExcel(){
        location.href="${pageContext.request.contextPath}/guru/exportExcel"
    }
    /*批量添加上师*/
    function batchAddGuru(){
        $("#guruDialog").dialog({
            href:"${pageContext.request.contextPath}/importExcel.jsp",
            width:300,height:200,modal:true,
            title:"提示",
            buttons:[
                {text:"上传",iconCls:"icon-script_save",handler:function () {
                    //上传文件
                    importExcelFile();
                    $("#guruDialog").dialog("close")

                }},
                {text:"取消",iconCls:"icon-cancel",handler:function(){
                    $("#guruDialog").dialog("close")
                }}
            ]
        });
    }
</script>

<%--数据表格--%>
<table class="datagridView" style="float: left"></table>
<%--搜索--%>
<div id="tb" style="float: left ;display: none">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addGuru()">添加法师</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateGuru()">修改法师</a>
    <div id="search" style="float: right;"> <!--   若想调整搜索框位置，加一个div层 -->
        <input id="searchInput" style="width:300px" class="easyui-searchbox" data-options="searcher:searchGuru,prompt:'Please Input Value',menu:'#menuAcondition'"/>
        <div id="menuAcondition" style="width:100px">
            <!-- 搜索选项，若上面的初始化中有相关内容则不需要下面的内容 -->
            <div data-options="name:'guru_id'">法师ID</div>
            <div data-options="name:'guru_name'">法师名称</div>
        </div>
    </div>
    <a onclick="exportExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-download',text:'导出为Excel文档'"></a>
    <a  onclick="batchAddGuru()" class="easyui-linkbutton" data-options="iconCls:'icon-basket_remove',text:'批量添加'"></a>
</div>

<%--使用class id会冲突--%>
<%--点击新增轮播图的时候弹出该dialog--%>
<div class="dialog" data-options="resizable:true,modal:true"></div>
<%--上师批量添加的对话框--%>
<div id="guruDialog"></div>



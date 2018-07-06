<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $('#datagridView').datagrid({
            title: '轮播图管理',

            remoteSort: false,
            singleSelect: true,
            //分页
            pagination: true,

            nowrap: false,
            fitColumns: true,
            url: '${pageContext.request.contextPath}/carousel/carouselJson',
            columns: [[
                {field: 'carouselId', title: 'carouselId', width: 80},
                {field: 'carouselName', title: 'carouselName', width: 100, sortable: true},
                {field: 'carouselDescribe', title: 'carouselDescribe', width: 80, align: 'right', sortable: true},
                {field: 'carouselDate', title: 'carouselDate', width: 150, sortable: true},
                {field: 'carouselStatus', title: 'carouselStatus', width: 60, align: 'center'}
            ]],
            //增加小工具条
            toolbar: [{
                iconCls: 'icon-add',
                text: '新增轮播图',
                handler: function () {
                    $("#dialog").dialog({
                        width: 450,
                        height: 280,
                        href: '${pageContext.request.contextPath}/carouselForm.jsp',
                        buttons: [{
                            text: 'upload',
                            handler: function () {
                                $(".addCarousel").form('submit', {
                                    url: "${pageContext.request.contextPath}/upload/carouselImage",
                                    onSubmit: function () {
                                        return true;
                                    },
                                    success: function (data) {
                                        if ("success"==data) {//代表添加成功
                                            $.messager.show({
                                                title: 'New Message',
                                                msg: 'you have uploaded ! success ',
                                                timeout: 3000,
                                                showType: 'slide'
                                            });
                                            $("#dialog").dialog("close");
                                            $('#datagridView').datagrid("reload");
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
                                alert("关闭");
                            }
                        }],

                    })
                }
            }, {
                iconCls: 'icon-help',
                text: '帮助',
                handler: function () {
                    alert("寻求帮助");
                }
            }],
            view: detailview,
            detailFormatter: function (index, row) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/main/image/' + row.carouselName + '" style="height:150px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Describe: ' + row.carouselDescribe + '</p>' +
                    '<p>Status: ' + row.carouselStatus + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    })
</script>


<table id="datagridView"></table>


<%--点击新增轮播图的时候弹出该dialog--%>
<div id="dialog" data-options="resizable:true,modal:true"></div>



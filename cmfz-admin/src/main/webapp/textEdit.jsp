<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/upload/richEditor';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files';
    /*使用文本域进行传值*/
    var $text1 = $('#text1');
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    }
    editor.create();
    // 初始化 textarea 的值
    $text1.val(editor.txt.html());

    /*提交表单*/
    $(function () {
        $("#createArticle").linkbutton({
            onClick: function () {
                $('#article').form('submit', {
                    url:"${pageContext.request.contextPath}/article/createArticle",
                    onSubmit: function () {
                        return $("#loginForm").form("validate");
                    },
                    success:function (data) {
                        alert(data);
                    }
                });
            }
        })
    })
</script>
    <%--文章内容--%>
    <form action="#" method="post" id="article">
        文章标题：<input class="easyui-textbox" name="articleName"/><br/><br/>
        文章作者：<input class="easyui-textbox" name="articleAuthor"><br/><br/>
        <div id="editor">

        </div>
        <div style="display: none">
        <textarea id="text1" name="articleContent" ></textarea>
        </div>
    </form>
    <br/><br/>
    <a class="easyui-linkbutton" id="createArticle" data-options="iconCls:'icon-edit',text:'上传文章'"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-control_remove',text:'取消'"></a>
</div>



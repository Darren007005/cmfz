<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    //上传Excel文件
    function importExcelFile(){
        $("#importExcelForm").form('submit',{
           url:"${pageContext.request.contextPath}/guru/importExcel.do",
           success:function (data) {
               if (data=="true"){//代表添加成功
                   $.messager.show({
                       title:'提示',
                       msg:'上传成功!',
                       timeout:1000,
                       showType:'slide'
                   });
               }
               if (data=="error"){
                   $.messager.alert({
                       title:'提示',
                       msg:'请上传Excel文件',
                       timeout:1000,
                       showType:'slide'
                   });
               }
               if (data=="false"){
                   $.messager.alert({
                       title:'提示',
                       msg:'文件上传失败',
                       timeout:1000,
                       showType:'slide'
                   });
               }
           }
        });
    }
    //控制文件上传只能为excel
    $(".easyui-filebox").filebox({
        accept:'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel'
    })
</script>

<h3>请选择Excel文件</h3>
<form  enctype="multipart/form-data" id="importExcelForm" method="post">
    <input type="excelFile" name="fileExcel" class="easyui-filebox">
</form>

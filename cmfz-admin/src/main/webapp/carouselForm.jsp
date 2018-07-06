<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--新增轮播图--%>
<script type="text/javascript">


</script>

<form method="post" class="addCarousel" enctype="multipart/form-data">
    <table>
        <tr>
            <th>carouselDescribe：</th>
            <th><input class="easyui-textbox" name="carouselDescribe" style="width:200px" ></th>
        </tr>
        <tr>
            <th>carouselStatus：</th>
            <th><select id="cc" class="easyui-combobox" data-options="panelHeight:50" name="carouselStatus" style="width:200px;" >
                <option value="1">1</option>
                <option value="0">0</option>
            </select></th>
        </tr>
        <tr>
            <th>UploadFile：</th>
            <th><input class="easyui-filebox" name="myFile" style="width:200px"></th>
        </tr>


    </table>
</form>

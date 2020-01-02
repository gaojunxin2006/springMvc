<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量修改商品的查询</title>


    <script type="text/javascript">

        function updateItems() {


            alert("修改商品的提交方法执行！");

            //将form的action指向删除商品地址
            document.itemsForm.action="${pageContext.request.contextPath }/item/updateAllItemSubmit.action";



            //进行for提交
            document.itemsForm.submit();



        }


    </script>


</head>
<body> 
<form name="itemsForm" action="${pageContext.request.contextPath }/item/updateAllItemSubmit.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/>

<input type="button" value="批量提交" onclick="updateItems()">
</td>

商品类别：
    <td>
        <select>

                <c:forEach var="item" items="${itemsType}">
                    <option value="${item.key}">${item.value}
                    </option>
                </c:forEach>

        </select>
    </td>

</tr>




</table>
商品列表：
<table width="100%" border=1>
<tr>
    <td>选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="item" varStatus="s">
<tr>
<%--    s.index是序号--%>
    <td><input type="checkbox" name="itemsList[${s.index}].id" value="${item.id}"></td>
	<td><input type="text" value="${item.name }" name="itemsList[${s.index}].name"></td>
	<td><input type="text" value="${item.price }" name="itemsList[${s.index}].price"></td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/></td>
	<td><input type="text" value="${item.detail }" name="itemsList[${s.index}].detail"></td>
	
	<td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>
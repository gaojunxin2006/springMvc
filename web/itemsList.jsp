<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>


    <script type="text/javascript">

        function deleteItems() {


            alert("js方法执行！");

            //将form的action指向删除商品地址
            document.itemsForm.action="${pageContext.request.contextPath }/item/deleteItems.action";



            //进行for提交
            document.itemsForm.submit();



        }


    </script>


</head>
<body>

<h2>当前用户：${usercode}</h2>
<br>
<br>
<c:if test="${usercode!=null}">

<a href="${pageContext.request.contextPath }/logout.action">退出</a>
</c:if>

<hr>
<br>
<form name="itemsForm" action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/>

<input type="button" value="批量删除" onclick="deleteItems()">
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
    <td>rest连接</td>
</tr>
<c:forEach items="${list }" var="item">
<tr>
    <td><input type="checkbox" name="delete_id" value="${item.id}"></td>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>

    <td><a href="${pageContext.request.contextPath }/item/viewItems/${item.id}">rest连接</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>
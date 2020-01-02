<%--
  Created by IntelliJ IDEA.
  User: wii
  Date: 2019/10/21
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json数据测试</title>


    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>

    <script type="text/javascript">


        //请求json响应json
       function

       requestJson(){

           alert("请求json响应json执行")

        $.ajax({

            url:"${pageContext.request.contextPath}/requestJson.action",
            contentType:"application/json;charset=utf-8",
            type:"post",

            //请求json数据，使用json表示商品信息
            data:'{"name":"手机","price":1999}',

            //ajax回调方法
            success:function (data) {

                alert(data.name);

            }



        })





       }


       //请求key/value响应json

       function responseJson() {

           alert("请求key/value响应json执行")

           $.ajax({

               url:"${pageContext.request.contextPath}/responseJson.action",
               type:"post",

               //请求key/value数据，使用json表示商品信息
               data:"name==手机&price=5999",

               //ajax回调方法
               success:function (data) {

                   alert(data.name);

               }



           })


        }


    </script>


</head>
<body>

    <br>
<h2>json数据测试</h2>
<br>
<hr><br>


<input type="button" value="请求json响应json" onclick="requestJson()"><br><br>



<input type="button" value="请求key/value响应json" onclick="responseJson()"><br><br>




</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>指标类管理</title>
<link rel="stylesheet" href="<%=basePath %>test1/plugins/layui/css/layui.css"
	media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 50px;">
		<legend>指标类别管理</legend>
	</fieldset>
	<div class="layui-btn-group demoTable">
		<button style="margin-left: 10px;" class="layui-btn layui-btn-primary" data-type="getCheckData">删除选中行数据</button>
		<button style="left: 10px;" class="layui-btn layui-btn-primary" data-type="add">提交</button>
	</div><hr/>
	 <c:forEach items="${fid }" var="feenback">
		<table class="layui-table" lay-data="{width:1000, url:'Feenback_findList.action?f1id=${feenback.feenback_id }',id:'test3'}" lay-filter="test3">
  		<thead>
  	 <tr>
   	 	<th lay-data="{align:'center',width: 1000}" rowspan="1" colspan="5">${feenback.feenback_name }</th>
   	 </tr>
    <tr>
    	<th lay-data="{type:'numbers',width:40}" rowspan="2" >序号</th>
     	<th lay-data="{field:'fb_name', width:400}" rowspan="2">指标</th>
     	<th lay-data="{field: 'fb_score', width: 80}" rowspan="2" >分值</th>
     	<c:forEach items="${tusers }" var="tc">
     		<th lay-data="{field:'score',align:'center',width: 80,edit: 'text'}" colspan="1" rowspan="1">${tc.username }</th>
 	 	</c:forEach>
    </tr>
    <tr>
   	 <c:forEach items="${tusers }" var="tc">
     		<th lay-data="{width: 80, align:'center'}" colspan="1" rowspan="1">${tc.coursename }</th>
 	 	</c:forEach>
      
    </tr>
  </thead>
  </table>
 

  </c:forEach>
</body>
<script src="<%=basePath %>test1/plugins/layui/layui.js"></script>
<script>
		layui.use(['form','table','laypage'], function() {
			var table = layui.table,
			layer = layui.layer,
			form = layui.form,
			laypage = layui.laypage;
			//监听单元格编辑
			  table.on('edit(test3)', function(obj){
			    var value = obj.value //得到修改后的值
			    ,data = obj.data //得到所在行所有键值
			    ,field = obj.field; //得到字段
			    console.log(obj);
			    layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
			  });
			
		});
		
	</script>
</html>
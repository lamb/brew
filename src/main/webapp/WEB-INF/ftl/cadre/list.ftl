<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${appTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content=""/>
</@head>
<body>
<table class="table table-hover">
  <thead>
	<tr>
	  <th>#</th>
	  <th>项目名称</th>
	  <th>英文缩写</th>
	  <th></th>
	  <th></th>
	  <th><a href="${contextPath}/cadre/create">新增</a></th>
	</tr>
  </thead>
  <tbody>
  	<#list cadres as cadre>
		<tr>
		  <td>${cadre.id}</td>
		  <td>${cadre.name}</td>
		  <td>${cadre.abbr}</td>
		  <td><a href="${contextPath}/cadre/${cadre.id}">查看</a></td>
		  <td><a href="${contextPath}/cadre/${cadre.id}/modify">修改</a></td>
		  <td><a href="${contextPath}/cadre/${cadre.id}/delete">删除</a></td>
		</tr>
	</#list>
  </tbody>
</table>
	<#include "footer.ftl">
</body>
</html>
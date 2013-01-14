<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${appTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content=""/>
</@head>
<body>
	<form id="project" class="form-horizontal" action="${contextPath}/project/${project.id}/modify" method="POST">
	  <div class="control-group">
	    <label class="control-label" for="name">项目名称</label>
	    <div class="controls">
	      <input type="text" id="name" name="name" placeholder="项目名称" required maxlength="100" value="${project.name}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label" for="abbr">英文缩写</label>
	    <div class="controls">
	      <input type="text" id="abbr" name="abbr" placeholder="英文缩写" required maxlength="100" value="${project.abbr}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <div class="controls">
	      <button id="project" type="submit" class="btn">保存</button>
	    </div>
	  </div>
	</form>
	<#include "footer.ftl">
</body>
</html>
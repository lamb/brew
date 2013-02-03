<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${appTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content=""/>
</@head>
<body>
	<form class="form-horizontal" action="${contextPath}/cadre/${cadre.id}/modify" method="POST">
	  <div class="control-group">
	    <label class="control-label">姓名</label>
	    <div class="controls">
	      <input type="text" name="name"  required maxlength="100" value="${cadre.name}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">部门</label>
	    <div class="controls">
	      <input type="text" name="department" required maxlength="100" value="${cadre.department}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">性别</label>
	    <div class="controls">
	      <input type="text" name="gender" required maxlength="100" value="${cadre.gender}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">生日</label>
	    <div class="controls">
	      <input type="text" name="birthday"  required maxlength="100" value="${cadre.birthday}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">名族</label>
	    <div class="controls">
	      <input type="text" name="nation" required maxlength="100" value="${cadre.nation}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">籍贯</label>
	    <div class="controls">
	      <input type="text" name="birthplace" required maxlength="100" value="${cadre.birthplace}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">政治面貌</label>
	    <div class="controls">
	      <input type="text" name="appearance" required maxlength="100" value="${cadre.appearance}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">学历</label>
	    <div class="controls">
	      <input type="text" name="education" required maxlength="100" value="${cadre.education}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">毕业院校</label>
	    <div class="controls">
	      <input type="text" name="graduate" required maxlength="100" value="${cadre.graduate}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">专业</label>
	    <div class="controls">
	      <input type="text" name="major" required maxlength="100" value="${cadre.major}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">研究方向</label>
	    <div class="controls">
	      <input type="text" name="research" required maxlength="100" value="${cadre.research}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">电话</label>
	    <div class="controls">
	      <input type="text" name="phone" required maxlength="100" value="${cadre.phone}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">邮箱</label>
	    <div class="controls">
	      <input type="text" name="email" required maxlength="100" value="${cadre.email}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">邮编</label>
	    <div class="controls">
	      <input type="text" name="zipcode" required maxlength="100" value="${cadre.zipcode}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">地址</label>
	    <div class="controls">
	      <input type="text" name="address" required maxlength="100" value="${cadre.address}"/>
	    </div>
	  </div>
	  <div class="control-group">
	    <div class="controls">
	      <button type="submit" class="btn">保存</button>
	    </div>
	  </div>
	</form>
	<#include "footer.ftl">
</body>
</html>
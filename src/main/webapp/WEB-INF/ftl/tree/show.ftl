<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${appTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content=""/>
</@head>
<body>
	<ul id="treeDemo" class="ztree"></ul>
	<#include "footer.ftl">
	<SCRIPT type="text/javascript">
	var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		async: {
			enable: true,
			url: "${contextPath}/department",
			autoParam: ["id"],
			dataFilter: ajaxDataFilter
		}
	};

	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, null);
	});
	
	function ajaxDataFilter(treeId, parentNode, responseData) {
	    if (responseData) {
	      for(var i =0; i < responseData.length; i++) {
	        responseData[i].pId = responseData[i].superior;
	      }
	    }
	    return responseData;
	};
	</SCRIPT>
</body>
</html>
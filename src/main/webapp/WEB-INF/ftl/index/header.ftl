<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="#">Bamboo</a>
			<div class="nav-collapse collapse">
				<ul class="nav pull-right">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="divider-vertical"></li>
					<form id="signForm" class="navbar-form pull-right" action="${contextPath}/signin" method="post">
		              <input class="span2" type="text" name="username" placeholder="用户名" rel="popover" data-placement="bottom" />
		              <input class="span2" type="password" name="password" placeholder="密码" rel="popover" data-placement="bottom" />
		              <input type="submit" class="btn" value="登陆" />
		            </form>
	            </ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>
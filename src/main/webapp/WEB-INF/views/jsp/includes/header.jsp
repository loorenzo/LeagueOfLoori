<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<body>
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/home">League of Loori</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
						Dropdown 
						<span class="caret"></span></a>
						<ul class="dropdown-menu" >
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul>
					</li>
				</ul>
				<c:url var="search" value="/search"></c:url>
				<form:form class="navbar-form navbar-left" action="${search }" method="post">
					<div class="form-group">
						<input name="search" type="text" class="form-control" placeholder="Search">
						<select name="region" class="form-control">
							<option value="EUW">EUW</option>
							<option value="NA">NA</option>
							<option value="KR">KR</option>
						</select>
					</div>
					<button name="summoner" type="submit" class="btn btn-primary">Search Summoner</button>
					<button name="game" type="submit" class="btn btn-danger">Search Game</button>
				</form:form>
					<sec:authorize var="isUser" access="hasRole('ROLE_USER') and isAuthenticated()" />
					<c:choose>
						<c:when test="${isUser }">
							<sec:authentication var="user" property="principal" />
							<c:url var="logout" value="/logout"></c:url>
							<form:form class="navbar-form navbar-right" action="${logout }">
								<div class="form-group">
									<button type="submit" class="btn btn-primary ">Logout</button>
								</div>
							</form:form>
							<a href="/summoner/${user.region }/${user.summonerName }">
								<ul class="nav navbar-nav navbar-right user-profile">
									<li><img class="img-responsive img-scale" src="/avatar/${user.summonerName }"></li>
									<li><p class="navbar-text">${user.summonerName }</p></li>
								</ul>
							</a>
						</c:when>
						<c:otherwise>
							<ul class="nav navbar-nav navbar-right">
								<li><p class="navbar-text">Already have an account?</p></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> 
								<span class="caret"></span></a>
								<ul id="login-dp" class="dropdown-menu">
									<li>
										<div class="row">
											<div class="col-md-12">
		<!-- 										Login via -->
		<!-- 										<div class="social-buttons"> -->
		<!-- 											<a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a> <a href="#" class="btn btn-tw"> -->
		<!-- 												<i class="fa fa-twitter"></i> Twitter -->
		<!-- 											</a> -->
		<!-- 										</div> -->
		<!-- 										or -->
												<c:url var="authenticate" value="/authenticate"></c:url>
												<form:form class="form" method="post" action="${authenticate }" id="login-nav">
													<div class="form-group">
														<label class="sr-only" for="exampleInputEmail2">Username</label> 
														<input name="username" class="form-control" id="exampleInputEmail2" placeholder="Username" required />
													</div>
													<div class="form-group">
														<label class="sr-only" for="exampleInputPassword2">Password</label> 
														<input name="password" type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required />
														<div class="help-block text-right">
															<a href="">Forget the password ?</a>
														</div>
													</div>
													<div class="form-group">
														<button type="submit" class="btn btn-primary btn-block">Sign in</button>
													</div>
													<div class="checkbox">
														<label> 
															<input name="_spring_security_remember_me" type="checkbox" /> Remember me
														</label>
													</div>
												</form:form>
											</div>
											<div class="bottom text-center">
												New here ? <a href="#"><b>Join Us</b></a>
											</div>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</body>
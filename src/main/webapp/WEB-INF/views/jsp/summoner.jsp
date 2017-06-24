<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Test Site</title>
<jsp:include page="includes/include.jsp" />
</head>
<body>
	<jsp:include page="includes/header.jsp" />
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				
				<c:forEach var="league" items="${model.leagues}">
				
					<div class="col-sm-6 col-md-6 center">
					  	 <div class="thumbnail">
					  	 	<img src="/resources/images/${league.tierUrl }">
				  	 		<div class="caption">
				  	 			<h2>${league.tier } ${league.rank }</h2>
				  	 			<h2>${league.queueType }</h2>
				  	 			<h3>LP: ${league.leaguePoints }</h3>
				  	 			<h3>Wins: ${league.wins }</h3>
				  	 			<h3>Losses: ${league.losses }</h3>
				  	 		</div>
					  	 </div>
				 	</div>
				</c:forEach>
			</div>
		
		</div>
		
	</div>

</body>
</html>
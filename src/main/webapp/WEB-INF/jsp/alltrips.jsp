<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
    	<title>The WorldWalkers - All Trips</title>
	</head>
    <body>
        <p>Hello WorldWalker</p>
        <p><a href="/">Home</a> </p>
        <p><a href="/alltrips/anotherpage">Another page</a> </p>
        
        <div id="trips">
            <c:if  test="${!empty tripList}">
                <h3>People</h3>
                <table class="table table-bordered table-striped">
                    <thead>
	                    <tr>
	                        <th>Name</th>
	                        <th>Description</th>
	                        <th>&nbsp;</th>
	                    </tr>	                    
	                    </thead>
                    <tbody>
                    <c:forEach items="${tripList}" var="trip">
                        <tr>
                            <td><span id="tripName_${trip.id}" class="tripRow">${trip.name}</span></td>
                            <td><span id="tripDescription_${trip.id}" class="tripRow">${trip.description}</span></td>
                            <td>
                                &nbsp;
                                <!-- 
                                <form action="delete/${person.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form>
                                -->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            
        </div>
    </body>
</html>
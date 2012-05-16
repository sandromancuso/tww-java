<!doctype html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>The WorldWalkers - Add Trip</title>
    </head>
    <body>
        <p>Add Trip</p>
        <p><a href="/">Home</a> </p>
        <p><a href="/alltrips/anotherpage">Another page</a> </p>
        
        <form:form method="post" action="add" commandName="trip" class="form-vertical">
            <form:label path="name">Name</form:label>
            <form:input id="txtName" path="name" />
            <form:label path="description">Description</form:label>
            <form:input id="txtDescription" path="description" />
            <input id="btnSaveTrip" type="submit" value="Save Trip" class="btn"/>
        </form:form>
    </body>
</html>
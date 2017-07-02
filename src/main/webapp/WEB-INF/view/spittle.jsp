<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<div class="spittleView">
	<form action="/myspring/spittles" method="POST">
			Message: <input type="text" name="message" value="${spittle.message}" /><br/>
			Latitude: <input type="text" name="latitude" value="${spittle.latitude}" /><br/>
			Longitude: <input type="text" name="longitude" value="${spittle.longitude}" /><br/>
			<input type="submit" value="submit" />
	</form>
</div>
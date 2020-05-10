
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/_view/main.css" >
        <Title>Courses</Title>
    </head>
    
    <body>
        <form action="${pageContext.servletContext.contextPath}/index" method="post">
            <div id = "titleDiv">
                <input id = "title" name="index" type="submit" value="Kinsley Tutoring Service" /><br>			
            </div>  
            <div class = "navBar">
                <input id="navBarItem" name="courses" type="submit" value="Courses" />
                <input id="navBarItem" name="groups" type="submit" value="Study Groups" />
                <input id="navBarItem" name="schedule" type="submit" value="Schedule" />
                <input id="navBarItem" name="tutors" type="submit" value="Tutors" />
                <input id="navBarItem" name="resources" type="submit" value="Resources" />
                <input id="navBarItem" name="profile" type="submit" value="Profile" />
                <input id="navBarItem" name="login" type="submit" value="Login" />
                <input id="navBarItem" name="createAccount" type="submit" value="Create Account" />
            </div>
        </form>
        <form action="${pageContext.servletContext.contextPath}/coursePage" method="get"> 
            <h1>${title}</h1>
            <h3>Days of Week:</h3>
                <h5>${daysOfWeek} </h5>            
            <h3>Sessions:</h3>
            <c:forEach items="${times}" var = "time">
                <h5>${time}</h5>            
            </c:forEach>
            <!--<h3>End Time: ${endTime}</h3>//-->
            <h3>List of Tutors:</h3>
            <c:forEach items="${tutorList}" var = "tutor">
                <tr>
                    <td>${tutor.name}<br></td>            
                </tr>
            </c:forEach>
            <h3>List of Tutoring Sessions:</h3>
            <table>
                <tr>
                    <td>Tutor</td>
                    <td>Days of Week</td>      
                    <td>Time</td>
                    <td>Room</td>   				
                </tr>
                <c:forEach items="${sessions}" var="session">
                                    <tr class="scheduleListings">
                                <td>${session.adminName}</td>
                                <td>${session.daysOfWeekString}</td>
                                <td>${session.startTime} - ${session.endTime}</td>
                                <td>${session.room}</td>		          
                        </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>|
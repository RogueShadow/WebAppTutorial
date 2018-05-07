<%--
  Created by IntelliJ IDEA.
  User: ashel
  Date: 4/22/2018
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data Editor</title>
</head>
<body>
    <div id="navbar" style="margin:auto;width:30%">
        <a href="dataeditor"><button>Data Editor</button></a>
        <a href="index.jsp"><button>Index</button></a>
        <a href="generator"><button>Generator</button></a>
    </div>
    <div id="datalists" style="margin:auto;width:50%">
        <form method="post" action="dataeditor">
            <label>Database Name
                <input type="text" name="dbName" value="${dbName}">
            </label><br>
            <label>Database Description
                <input type="text" name="dbDescription" value="${dbDescription}">
            </label><br>
            <label>Database World
                <input type="text" name="dbWorld" value="${dbWorld}">
            </label>
            <table cellpadding="0" style="width:900px">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Race</th>
                    <th>Job</th>
                    <th>Place</th>
                </tr>
                <tr>
                    <td><textarea name="names_form" style="height:300px;width:100%">${namesDB}</textarea></td>
                    <td><textarea name="surnames_form" style="height:300px;width:100%">${surnamesDB}</textarea></td>
                    <td><textarea name="races_form" style="height:300px;width:100%">${racesDB}</textarea></td>
                    <td><textarea name="jobs_form" style="height:300px;width:100%">${jobsDB}</textarea></td>
                    <td><textarea name="places_form" style="height:300px;width:100%">${placesDB}</textarea></td>
                </tr>
            </table>
            <input type="submit" value="Update">
        </form>
        <form action="loaddata" enctype="multipart/form-data" method="post">
            <input type="file" formenctype="multipart/form-data" name="dataFile">
            <input type="submit" value="Load Data">
        </form>
        <form action="loaddata" enctype="multipart/form-data" method="get">
            <input type="submit" value="Download Data">
        </form>
    </div>
</body>
</html>

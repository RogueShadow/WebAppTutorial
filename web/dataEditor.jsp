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
    <link rel="stylesheet" href="editor.css">

</head>
<body>
    <div id="navbar" style="margin:auto;width:30%">
        <a href="dataeditor"><button>Data Editor</button></a>
        <a href="index.jsp"><button>Index</button></a>
        <a href="generator"><button>Generator</button></a>
    </div>
    <div id="datalists" style="margin:auto;width: 50%;">
        <table cellpadding="0" style="width:900px">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Race</th>
                <th>Job</th>
                <th>Place</th>
            </tr>
            <tr>
                <td><div class="scrollbox" name="names_form">${namesDB}</div></td>
                <td><div class="scrollbox" name="surnames_form">${surnamesDB}</div></td>
                <td><div class="scrollbox" name="races_form">${racesDB}</div></td>
                <td><div class="scrollbox" name="jobs_form">${jobsDB}</div></td>
                <td><div class="scrollbox" name="places_form">${placesDB}</div></td>
            </tr>
        </table>
        <form method="post" action="dataeditor">


            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>

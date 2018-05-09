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
                <th>Male Name</th>
                <th>Female names</th>
                <th>Last Names</th>
                <th>Race</th>
                <th>Job</th>
                <th>Place</th>
            </tr>
            <tr>
                <td><div class="scrollbox">${maleNames}</div></td>
                <td><div class="scrollbox">${femaleNames}</div></td>
                <td><div class="scrollbox">${lastNames}</div></td>
                <td><div class="scrollbox">${races}</div></td>
                <td><div class="scrollbox">${jobs}</div></td>
                <td><div class="scrollbox">${places}</div></td>
            </tr>
        </table>
        <form method="post" action="dataeditor">
            ${selections}
            <br>
            <label>Add: <input type="text"  name="addValue" title="Add"></label>
            <br>
            <label>Remove: <input type="text" name="removeValue" title="Remove"></label>
            <br>
            <select name="worldSelect">${worlds}</select>
            <input type="submit" value="Update">
        </form>
        <p>${response}</p>
    </div>
</body>
</html>

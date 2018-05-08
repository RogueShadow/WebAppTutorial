<%--
  Created by IntelliJ IDEA.
  User: ashel
  Date: 4/21/2018
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Generator App</title>
    </head>
    <body>
        <div id="navbar">
            <a href="dataeditor"><button>Data Editor</button></a>
            <a href="index.jsp"><button>Index</button></a>
            <a href="generator"><button>Generator</button></a>
        </div>
        <div id="output">
            <p>${name}</p>
        </div>
        <div id="genderSelect">
            <form action="generator" method="post">
                <select name="genderSelect">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                    <option value="R">Random</option>
                </select>
                <select name="worldSelect">
                    ${worlds}
                </select>
                <input type="submit">
            </form>
        </div>
    </body>
</html>

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
        <link rel="stylesheet" href="editor.css">
    </head>
    <body>
        <div class="navbar" id="navbar">
            <a href="dataeditor"><button>Data Editor</button></a>
            <a href="index.jsp"><button>Index</button></a>
            <a href="generator"><button>Generator</button></a>
        </div>
        <div class="output" id="output">
            <p>${name}</p>
        </div>
        <div id="genderSelect">
            <form action="generator" method="post">
                <select name="genderSelect">
                    ${genders}
                </select>
                <select name="worldSelect">
                    ${worlds}
                </select>
                <input type="submit">
            </form>
        </div>
    </body>
</html>

package webapp

import appLayer.User
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException


@WebServlet(name = "login")
class login : HttpServlet() {
    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val out = response.writer
        val username = request.getParameter("loginname")
        val password = request.getParameter("password")

        request.setAttribute("username",username)
        request.setAttribute("password",password)

        if (User().isValidUserCredentials(username, password)){
            request.getRequestDispatcher("/welcome.jsp").forward(request,response)
        } else {
            request.setAttribute("errorMsg","Invalid Login or Password combination. Try Again")
            request.getRequestDispatcher("/login.jsp").forward(request,response)
        }

    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val out = response.writer

        out.println("DoGet Version")
        out.println("Login Name: ${request.getParameter("loginname")}")
        out.println("Password: ${request.getParameter("password")}")
    }
}

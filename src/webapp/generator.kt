package webapp

import dataLayer.Data
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(urlPatterns = ["/generator"],loadOnStartup = 0)
class Generator : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val gender: String? = request.getParameter("genderSelect")
        Data.db.world = request.getParameter("worldSelect") ?: "default"

        val name = if (gender == null || gender == "R"){
            Data.db.getNames(limit = 1)
        }else{
            if (gender == "M")Data.db.getNamesM(limit = 1) else Data.db.getNamesF(limit = 1)
        }
        val worlds = StringBuilder()
        Data.db.getWorlds().forEach {
            worlds.append("<option value=\"$it\">$it</option>\n")
        }
        request.setAttribute("worlds",worlds.toString())
        request.setAttribute("name",name)
        request.getRequestDispatcher("generator.jsp").forward(request,response)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val gender: String? = request.getParameter("genderSelect")
        Data.db.world = request.getParameter("worldSelect") ?: "default"

        val name = if (gender == null || gender == "R"){
            Data.db.getNames(limit = 1)
        }else{
            if (gender == "M")Data.db.getNamesM(limit = 1) else Data.db.getNamesF(limit = 1)
        }

        val worlds = StringBuilder()
        Data.db.getWorlds().forEach {
            worlds.append("<option value=\"$it\">$it</option>\n")
        }

        request.setAttribute("worlds",worlds.toString())
        request.setAttribute("name",name)

        request.getRequestDispatcher("generator.jsp").forward(request,response)
    }

}

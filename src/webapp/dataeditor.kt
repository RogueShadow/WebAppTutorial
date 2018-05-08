package webapp

import dataLayer.Data
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/dataeditor"])
class dataeditor : HttpServlet() {
    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {



    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        Data.db.world = "Earth"

        request.setAttribute("namesDB",listToString(Data.db.getNames()))
        request.setAttribute("racesDB", listToString(Data.db.getRaces()))
        request.setAttribute("placesDB",listToString(Data.db.getPlaces()))
        request.setAttribute("jobsDB",listToString(Data.db.getJobs()))
        request.setAttribute("surnamesDB",listToString(Data.db.getSurNames()))


        request.getRequestDispatcher("dataEditor.jsp").forward(request,response)
    }

    private fun listToString(list: List<String>): String{
        val sb = StringBuilder()
        list.forEach {
            sb.append("$it<br>")
        }
        return sb.toString()
    }
}

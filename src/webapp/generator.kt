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
        val gender = request.getParameter("genderSelect") ?: "R"
        Data.db.world = request.getParameter("worldSelect") ?: Data.db.world

        request.setAttribute("genders",Data.getGenderList(gender))
        request.setAttribute("worlds",Data.getWorldList())
        request.setAttribute("name",generate(gender))
        request.getRequestDispatcher("generator.jsp").forward(request,response)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val gender = request.getParameter("genderSelect") ?: "R"
        Data.db.world = request.getParameter("worldSelect") ?: Data.db.world

        request.setAttribute("genders",Data.getGenderList(gender))
        request.setAttribute("worlds",Data.getWorldList())
        request.setAttribute("name",generate(gender))
        request.getRequestDispatcher("generator.jsp").forward(request,response)
    }

    fun generate(gender: String = "R"): String {
        val fname = when (gender){
            "M" -> Data.db.getNamesM(limit = 1).first()
            "F" -> Data.db.getNamesF(limit = 1).first()
            else -> Data.db.getNames(limit = 1).first()
        }
        val lname = Data.db.getSurNames(limit = 1).first()
        val race = Data.db.getRaces(limit = 1).first()
        val job = Data.db.getJobs(limit = 1).first()
        val place = Data.db.getPlaces(limit = 1).first()
        return "Hello, $fname $lname.<br>Race: $race<br>Job: $job<br>From: $place<br>I hope you are well."
    }

}

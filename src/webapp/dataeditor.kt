package webapp

import appLayer.Gen
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

        Gen.clearData()
        Gen.cG.properties["name"] = request.getParameter("dbName")
        Gen.cG.properties["description"] = request.getParameter("dbDescription")
        Gen.cG.properties["world"] = request.getParameter("dbWorld")
        Gen.addNames(request.getParameter("names_form"))
        Gen.addRaces(request.getParameter("races_form"))
        Gen.addPlaces(request.getParameter("places_form"))
        Gen.addJobs(request.getParameter("jobs_form"))
        Gen.addSurNames(request.getParameter("surnames_form"))

        doGet(request,response)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        request.setAttribute("namesDB",Gen.getNames())
        request.setAttribute("racesDB",Gen.getRaces())
        request.setAttribute("placesDB",Gen.getPlaces())
        request.setAttribute("jobsDB",Gen.getJobs())
        request.setAttribute("surnamesDB",Gen.getSurNames())
        request.setAttribute("dbName",Gen.cG.properties["name"])
        request.setAttribute("dbDescription",Gen.cG.properties["description"])
        request.setAttribute("dbWorld",Gen.cG.properties["world"])

        request.getRequestDispatcher("dataEditor.jsp").forward(request,response)
    }
}

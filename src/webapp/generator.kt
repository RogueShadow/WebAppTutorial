package webapp

import appLayer.Gen
import net.granseal.chargenlib.Character
import net.granseal.chargenlib.Sex
import java.io.File
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(urlPatterns = ["/generator"],loadOnStartup = 0)
class Generator : HttpServlet() {


    override fun init() {
        val url = servletContext.getResource("./WEB-INF/lib/TestingData.zip")
        Gen.cG.loadCharacterDataFile(File(url.file))
        super.init()
    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val gender: String? = request.getParameter("gender")

        request.setAttribute("dataFileName",Gen.cG.properties["name"])
        if (gender != null)request.setAttribute("randomOut",generate(gender))
        request.getRequestDispatcher("generator.jsp").forward(request,response)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val gender: String? = request.getParameter("gender")

        request.setAttribute("dataFileName",Gen.cG.properties["name"])
        if (gender != null)request.setAttribute("randomOut",generate(gender)) else
            request.setAttribute("randomOut",generate(null))
        request.getRequestDispatcher("generator.jsp").forward(request,response)
    }

    private fun generate(gender: String?): Character {
        return Gen.cG.generate(when (gender) {
            "male" -> Sex.MALE
            "female" -> Sex.FEMALE
            else -> Sex.RANDOM
        })
    }


}

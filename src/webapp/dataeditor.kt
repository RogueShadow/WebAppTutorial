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
        Data.db.world = request.getParameter("worldSelect") ?: Data.db.world
        val selection: String = request.getParameter("selection") ?: "boyname"
        val addValue = request.getParameter("addValue")
        val removeValue = request.getParameter("removeValue")
        if (selection != null)request.setAttribute("response",Data.handleSelection(
                selection,
                if (addValue.isBlank()) null else addValue,
                if (removeValue.isBlank()) null else removeValue))
        else request.setAttribute("response","Please select a category first.")

        doGet(request,response)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        Data.db.world = request.getParameter("worldSelect") ?: Data.db.world
        val selection = request.getParameter("selection") ?: "boyname"

        request.setAttribute("maleNames",listToString(Data.db.getNamesM()))
        request.setAttribute("femaleNames",listToString(Data.db.getNamesF()))
        request.setAttribute("races", listToString(Data.db.getRaces()))
        request.setAttribute("places",listToString(Data.db.getPlaces()))
        request.setAttribute("jobs",listToString(Data.db.getJobs()))
        request.setAttribute("lastNames",listToString(Data.db.getSurNames()))
        request.setAttribute("worlds",Data.getWorldList())
        request.setAttribute("selections",getSelections(selection))

        request.getRequestDispatcher("dataEditor.jsp").forward(request,response)
    }

    private fun listToString(list: List<String>): String{
        val sb = StringBuilder()
        list.forEach { sb.append("$it<br>") }
        return sb.toString()
    }

    private fun getSelections(selection: String): String{
        val sb = StringBuilder()
        mapOf(Pair("boyname","Boy Name"),Pair("girlname","Girl Name"),Pair("lastname","Last Name"),
                Pair("race","Race"),Pair("job","Job"),Pair("place","Place"),Pair("world","World")).forEach { k, v ->
            if (k == selection)sb.append("<label><input type=\"radio\" name=\"selection\" value=\"$k\" checked>$v</label>")
            else sb.append("<label><input type=\"radio\" name=\"selection\" value=\"$k\">$v</label>")
        }
        return sb.toString()
    }
}
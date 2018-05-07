package webapp

import appLayer.Gen
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.MultipartConfig
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/loaddata"])
@MultipartConfig
class LoadData : HttpServlet() {
    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val filePart = request.getPart("dataFile")
        if (filePart.contentType != null){
            Gen.cG.loadCharacterDataFile(filePart.inputStream)
            request.getRequestDispatcher("dataEditor").forward(request,response)
        }else{
            response.writer.println("Select a File first.")
        }
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val dataFile = Gen.cG.getCharacterDataFile()
        response.contentType = "application/octet-stream"
        response.setHeader("Content-Disposition", "attachment; filename=data.zip")
        response.setContentLength(dataFile.size)
        val os = response.outputStream

        os.use {
            os.write(dataFile)
        }
    }
}

package dataLayer

import org.jetbrains.annotations.NotNull
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import kotlin.properties.Delegates

class DB_user {
    val JDBC_DRIVER = "com.mysql.jdbc.Driver"
    val DB_URL = "jdbc:mysql://localhost/myapptutorial"

    val USER = "webappuser"
    val PASS = "test123"


    fun isValidUserLogin(userName: String, userPassword: String): Boolean {
        var isValidUser = false

        var conn: Connection? = null
        var stmt: Statement? = null
        var sql: String

        try {
            Class.forName(JDBC_DRIVER)

            println("Connecting to database...")
            conn = DriverManager.getConnection(DB_URL,USER,PASS)

            println("Creating statement...")
            stmt = conn.createStatement()

            sql = "SELECT * FROM users WHERE user_name = \"$userName\" AND user_password = \"$userPassword\""

            println(sql)

            val rs = stmt.executeQuery(sql)

            if (rs.next()){
                isValidUser = true
            }

            rs.close()
            stmt.close()
            conn.close()
        }catch(se: SQLException){
            se.printStackTrace()
        }catch(e: Exception){
            e.printStackTrace()
        }finally {
            try {
                if (stmt != null){
                    stmt.close()
                }
            }catch(e: SQLException){
                e.printStackTrace()
            }
            try {
                if (conn != null){
                    conn.close()
                }
            }catch (e: SQLException){
                e.printStackTrace()
            }
        }

        println("Closing DB Connection... GoodBye!")
        return isValidUser
    }
}
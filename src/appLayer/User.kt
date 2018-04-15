package appLayer

class User {
    fun isValidUserCredentials(userName: String, password: String): Boolean {
        if (userName == "RogueShadow" && password == "RoguePass")return true
        return false
    }
}
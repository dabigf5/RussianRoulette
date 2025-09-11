package tools.important.russianroulette

val os = System.getProperty("os.name").lowercase()
val isWindows = os.contains("win")
val isUnix = os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("bsd")

//fun isRoot(): Boolean {
//    try {
//        val a = ProcessBuilder("id", "-u").start()
//        a.waitFor()
//        val reader = BufferedReader(InputStreamReader(a.inputStream))
//        val output = reader.readText().replace("\n", "")
//
//        return output == "0"
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }
//    return false
//}
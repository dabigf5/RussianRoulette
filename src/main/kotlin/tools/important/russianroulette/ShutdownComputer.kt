package tools.important.russianroulette

import kotlin.system.exitProcess

var shutdownBuilder: ProcessBuilder? = null

fun buildShutdownCommand(): ProcessBuilder? {
    return if (isUnix) {
        ProcessBuilder("shutdown", "-h", "now")
    } else if (isWindows) {
        ProcessBuilder("cmd.exe", "/c", "shutdown", "/p", "/f")
    } else {
        null
    }
}

fun shutdownComputer() {
    shutdownBuilder!!.start()
    exitProcess(0)
}
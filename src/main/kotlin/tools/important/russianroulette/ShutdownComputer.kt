package tools.important.russianroulette

// todo: cross-platform shutdown
fun shutdownComputer() {
    ProcessBuilder("cmd.exe", "/c", "shutdown", "/p", "/f")
        .start()
}
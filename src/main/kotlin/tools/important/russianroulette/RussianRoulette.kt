package tools.important.russianroulette

import tools.important.russianroulette.gui.RussianRouletteWindow
import javax.swing.JOptionPane
import kotlin.system.exitProcess

const val VERSION = "Russian Roulette 1.4.0"

fun main() {
    // It appears that oftentimes (in desktop environments, the only place this program should work) users have access to shutdown.
    // With this in mind, I think this check is redundant. I'm going to leave it in if this intuition about shutdown access proves wrong, however.
//    if (isUnix && !isRoot()) {
//        JOptionPane.showMessageDialog(null, "This program cannot shutdown the system unless it is being run as root!")
//        return
//    }

    shutdownBuilder = buildShutdownCommand()
    if (shutdownBuilder == null) {
        JOptionPane.showMessageDialog(RussianRouletteWindow, "Cannot figure out how to shut down on this forsaken, exotic operating system.")
        exitProcess(1)
    }

    Revolver.load()
    RussianRouletteWindow.isVisible = true
}
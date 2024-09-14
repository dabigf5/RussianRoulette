package tools.important.russianroulette.gui

import tools.important.russianroulette.VERSION
import javax.swing.JFrame

object RussianRouletteWindow : JFrame(VERSION) {
    private fun readResolve(): Any = RussianRouletteWindow

    init {


        setSize(250, 250)
        defaultCloseOperation = EXIT_ON_CLOSE
    }
}
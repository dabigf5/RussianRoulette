package tools.important.russianroulette

import tools.important.russianroulette.gui.RussianRouletteWindow

const val VERSION = "Russian Roulette 1.3.0"

fun main() {
    Revolver.load()
    
    RussianRouletteWindow.isVisible = true
}
package tools.important.russianroulette.gui

import tools.important.russianroulette.Revolver
import tools.important.russianroulette.VERSION
import tools.important.russianroulette.shutdownComputer
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.io.IOException
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import kotlin.system.exitProcess

object RussianRouletteWindow : JFrame(VERSION) {
    // Shut up, IntelliJ! You complain whenever this _isn't_ here, and whenever it _is_.
    @Suppress("unused")
    private fun readResolve(): Any = RussianRouletteWindow

    init {
        layout = BorderLayout()

        val statusLabel = JLabel()
        add(statusLabel, BorderLayout.SOUTH)



        val buttons = JPanel()
        buttons.layout = FlowLayout()



        val spinButton = JButton("Spin")
        spinButton.addActionListener(fun(_) {
            statusLabel.text = "Spun revolver!"
            Revolver.spin()
        })
        buttons.add(spinButton)

        val pullButton = JButton("Pull")
        pullButton.addActionListener(fun(_) {
            val bang = Revolver.pull()

            if (!bang) {
                statusLabel.text = "Click"
                return
            }
                statusLabel.text = "BANG!"
                try {
                    shutdownComputer()
                } catch (e: IOException) {
                    JOptionPane.showMessageDialog(RussianRouletteWindow, "Ran into an error while trying to shut down the machine: ${e.message}")
                    exitProcess(0)
                }
                return
        })
        buttons.add(pullButton)


        add(buttons, BorderLayout.CENTER)

        setSize(500, 250)
        defaultCloseOperation = EXIT_ON_CLOSE
    }
}
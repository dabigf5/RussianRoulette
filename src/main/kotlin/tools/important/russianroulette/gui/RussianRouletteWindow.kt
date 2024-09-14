package tools.important.russianroulette.gui

import tools.important.russianroulette.Revolver
import tools.important.russianroulette.VERSION
import tools.important.russianroulette.shutdownComputer
import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

object RussianRouletteWindow : JFrame(VERSION) {
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

            if (bang) {
                statusLabel.text = "BANG!"
                shutdownComputer()
                return
            }
            statusLabel.text = "Click"
        })
        buttons.add(pullButton)


        add(buttons, BorderLayout.CENTER)

        setSize(500, 250)
        defaultCloseOperation = EXIT_ON_CLOSE
    }
}
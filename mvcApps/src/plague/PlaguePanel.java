package plague;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import simstation.*;

public class PlaguePanel extends SimulationPanel implements ChangeListener {
    // based on Tournament code example in lecture
    private JSlider populationSlider, virulenceSlider, resistanceSlider;

    public PlaguePanel(SimStationFactory factory) {
        super(factory);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
        sliderPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));


        populationSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, PlagueSimulation.getPopulation());
        populationSlider.setMajorTickSpacing(50);
        populationSlider.setMinorTickSpacing(10);
        populationSlider.setPaintTicks(true);
        populationSlider.setPaintLabels(true);
        populationSlider.setLabelTable(populationSlider.createStandardLabels(50));
        populationSlider.addChangeListener(this);

        virulenceSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, PlagueSimulation.getVirulence());
        virulenceSlider.setMajorTickSpacing(20);
        virulenceSlider.setMinorTickSpacing(5);
        virulenceSlider.setPaintTicks(true);
        virulenceSlider.setPaintLabels(true);
        virulenceSlider.setLabelTable(virulenceSlider.createStandardLabels(20));
        virulenceSlider.addChangeListener(this);

        resistanceSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, PlagueSimulation.getResistance());
        resistanceSlider.setMajorTickSpacing(20);
        resistanceSlider.setMinorTickSpacing(5);
        resistanceSlider.setPaintTicks(true);
        resistanceSlider.setPaintLabels(true);
        resistanceSlider.setLabelTable(resistanceSlider.createStandardLabels(20));
        resistanceSlider.addChangeListener(this);

        sliderPanel.add(addSliderLabel("Initial Population Size:", populationSlider));
        sliderPanel.add(addSliderLabel("Infection Probability:", virulenceSlider));
        sliderPanel.add(addSliderLabel("Resistance Probability:", resistanceSlider));

        controlPanel.add(sliderPanel, BorderLayout.CENTER);
    }

    private JPanel addSliderLabel(String labelText, JSlider slider) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);
        return panel;
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == populationSlider) {
            PlagueSimulation.setPopulation(populationSlider.getValue());
        } else if (e.getSource() == virulenceSlider) {
            PlagueSimulation.setVirulence(virulenceSlider.getValue());
        } else if (e.getSource() == resistanceSlider) {
            PlagueSimulation.setResistance(resistanceSlider.getValue());
        }
        
        model.changed();
    }

    @Override
    public void update() {
        super.update();
        populationSlider.setValue(PlagueSimulation.getPopulation());
        virulenceSlider.setValue(PlagueSimulation.getVirulence());
        resistanceSlider.setValue(PlagueSimulation.getResistance());
    }
}
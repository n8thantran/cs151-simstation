package greed;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import simstation.*;

public class GreedPanel extends SimulationPanel implements ChangeListener {
    private JSlider greedSlider, growBackRateSlider, moveEnergySlider;

    public GreedPanel(SimStationFactory factory) {
        super(factory);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
        sliderPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

       // greedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, GreedSimulation.getGreed());
        greedSlider.setMajorTickSpacing(20);
        greedSlider.setMinorTickSpacing(5);
        greedSlider.setPaintTicks(true);
        greedSlider.setPaintLabels(true);
        greedSlider.setLabelTable(greedSlider.createStandardLabels(20));
        greedSlider.addChangeListener(this);

       // growBackRateSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, GreedSimulation.getGrowBackRate());
       // growBackRateSlider.setMajorTickSpacing(?);
      //  growBackRateSlider.setMinorTickSpacing(?);
        growBackRateSlider.setPaintTicks(true);
        growBackRateSlider.setPaintLabels(true);
     //   growBackRateSlider.setLabelTable(growBackRateSlider.createStandardLabels(?));
        growBackRateSlider.addChangeListener(this);

     //   moveEnergySlider = new JSlider(JSlider.HORIZONTAL, 0, 50, GreedSimulation.getMoveEnergy());
      //  moveEnergySlider.setMajorTickSpacing(?);
      //  moveEnergySlider.setMinorTickSpacing(?);
        moveEnergySlider.setPaintTicks(true);
        moveEnergySlider.setPaintLabels(true);
      //  moveEnergySlider.setLabelTable(moveEnergySlider.createStandardLabels(?));
        moveEnergySlider.addChangeListener(this);

        sliderPanel.add(addSliderLabel("Greed:", greedSlider));
        sliderPanel.add(addSliderLabel("Grow back rate:", growBackRateSlider));
        sliderPanel.add(addSliderLabel("Move Energy:", moveEnergySlider));

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
        if(e.getSource() == greedSlider) {
       //     GreedSimulation.setGreed(greedSlider.getValue());
        } else if(e.getSource() == growBackRateSlider) {
      //      GreedSimulation.setGrowBackRate(growBackRateSlider.getValue());
        } else if(e.getSource() == moveEnergySlider) {
     //       GreedSimulation.setMoveEnergy(moveEnergySlider.getValue());
        }
        model.changed();
    }

    @Override
    public void update() {
        super.update();
      //  greedSlider.setValue(GreedSimulation.getGreed());
     //   growBackRateSlider.setValue(GreedSimulation.getGrowBackRate());
     //   moveEnergySlider.setValue(GreedSimulation.getMoveEnergy());
    }
}

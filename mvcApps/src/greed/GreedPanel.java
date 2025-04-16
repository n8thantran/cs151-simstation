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

        greedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, ((GreedSimulation) model).getGreed());
        greedSlider.addChangeListener(this);

        growBackRateSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, ((Meadow) model).getGrowBackRate());
        growBackRateSlider.addChangeListener(this);

        moveEnergySlider = new JSlider(JSlider.HORIZONTAL, 0, 50, ((Meadow) model).getMoveEnergy());
        moveEnergySlider.addChangeListener(this);

        sliderPanel.add(addSliderLabel("Greed:", greedSlider));
        sliderPanel.add(addSliderLabel("Grow Back Rate:", growBackRateSlider));
        sliderPanel.add(addSliderLabel("Move Energy:", moveEnergySlider));

        // Fix missing buttons
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> new StartCommand(model).execute());

        JButton suspendButton = new JButton("Pause");
        suspendButton.addActionListener(e -> new SuspendCommand(model).execute());

        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(e -> new ResumeCommand(model).execute());

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> new StopCommand(model).execute());

        JButton statsButton = new JButton("Stats");
        statsButton.addActionListener(e -> new StatsCommand(model).execute());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5));
        buttonPanel.add(startButton);
        buttonPanel.add(suspendButton);
        buttonPanel.add(resumeButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(statsButton);

        controlPanel.add(sliderPanel, BorderLayout.NORTH);
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);
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
        // Cast model to GreedSimulation
        GreedSimulation greedSimulation = (GreedSimulation) model;

        if(e.getSource() == greedSlider) {
            // Use the instance method to set greed value
            greedSimulation.setGreed(greedSlider.getValue());
        } else if(e.getSource() == growBackRateSlider) {
            ((Meadow)model).setGrowBackRate(growBackRateSlider.getValue());
        } else if(e.getSource() == moveEnergySlider) {
            ((Meadow)model).setMoveEnergy(moveEnergySlider.getValue());
        }
        model.changed();
    }

    @Override
    public void update() {
        super.update();
        // Cast model to GreedSimulation to access instance method getGreed()
        GreedSimulation greedSimulation = (GreedSimulation) model;

        greedSlider.setValue(greedSimulation.getGreed()); // Use the instance method to get greed value
        growBackRateSlider.setValue(((Meadow)model).getGrowBackRate());
        moveEnergySlider.setValue(((Meadow)model).getMoveEnergy());
    }
}

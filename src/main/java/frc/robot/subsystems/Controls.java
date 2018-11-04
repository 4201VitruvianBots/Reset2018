package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.vitruvianlib.VitruvianLogger.*;

public class Controls extends Subsystem {
    //PowerDistributionPanel pdp = new PowerDistributionPanel();

    public Controls(){
        super("Controls");

        // Initialize a log for Controls that logs status every 0.5 seconds
        VitruvianLog controlsLog = new VitruvianLog("Controls", 0.5);
        controlsLog.addLogField("pdpTemp", this::getPdpTemperature);
        controlsLog.addLogField("pdpTotalCurrent", this::getPdpTotalCurrent);
        controlsLog.addLogField("pdpTotalPower", this::getPdpTotalPower);
        controlsLog.addLogField("pdpTotalVoltage", this::getTotalVoltage);
        VitruvianLogger.getInstance().addLog(controlsLog);

    }

    public double getPdpTemperature(){
        return 76;
        //return pdp.getTemperature();
    }

    public double getPdpTotalCurrent(){
        return 200.5;
        //return pdp.getTotalCurrent();
    }


    public double getPdpTotalPower(){
        return 120;
        //return pdp.getTotalPower();
    }

    public double getTotalVoltage() {
        return 12;
        //return pdp.getVoltage();
    }

    @Override
    protected void initDefaultCommand() {

    }
}

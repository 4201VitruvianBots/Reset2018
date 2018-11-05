package frc.robot.drive;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrain.DriveCommand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;

@RunWith(Parameterized.class)
public class DriveTrainTankTest {
    private final double kEpsilon = 1E-9;

    public double leftCommand;
    public double rightCommand;
    public DriveCommand expectedDriveCommand;

    @Parameters
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][] {
                {1.0, 1.0, new DriveCommand(12, -12)}, // Full stick forward
                {-1.0, -1.0, new DriveCommand(-12, 12)}, // Full stick reverse
                {0.02, 0.02, new DriveCommand(0, 0)}, // Deadband check
        });
    }

    public DriveTrainTankTest(double left, double right, DriveCommand expected) {
        this.leftCommand = left;
        this.rightCommand = right;
        this.expectedDriveCommand = expected;
    }

    @Test
    public void testTankDrive() {
        DriveCommand dc = DriveTrain.tankCommand(leftCommand, rightCommand);
        Assert.assertEquals(dc.leftVoltage, expectedDriveCommand.leftVoltage, kEpsilon);
        Assert.assertEquals(dc.rightVoltage, expectedDriveCommand.rightVoltage, kEpsilon);
    }
}
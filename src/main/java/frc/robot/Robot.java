/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.DriveSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveSubsystem drivesub;
  public static NetworkTableInstance inst;
  public static NetworkTable smartDashboardTable;
  public static NetworkTable camera1Table;
  public static NetworkTableEntry connected;
  public static NetworkTableEntry distance;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    drivesub = new DriveSubsystem();
    inst = NetworkTableInstance.getDefault();
    smartDashboardTable = inst.getTable("SmartDashboard/robotConnected");
    camera1Table = inst.getTable("RaspberryPi/distanceFromCenter");
    connected = smartDashboardTable.getEntry("key");
    distance = camera1Table.getEntry("distance");
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  Joystick joy1 = new Joystick(0);
  Joystick joy2 = new Joystick(1);
  TalonSRX flTalon = new TalonSRX(1);
  TalonSRX frTalon = new TalonSRX(2);
  TalonSRX blTalon = new TalonSRX(0);
  TalonSRX brTalon = new TalonSRX(3);
  
  @Override
  public void robotPeriodic() {
    double leftspeed = -joy1.getRawAxis(1) * .6;
    double rightspeed = joy2.getRawAxis(1) * .6;
    flTalon.set(ControlMode.PercentOutput, leftspeed);
    frTalon.set(ControlMode.PercentOutput, rightspeed);
    blTalon.set(ControlMode.PercentOutput, leftspeed);
    brTalon.set(ControlMode.PercentOutput,rightspeed);

    connected.setBoolean(true);


  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

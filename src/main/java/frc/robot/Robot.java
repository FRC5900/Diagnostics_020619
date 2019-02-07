/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  Spark motor0 = new Spark(0);
  Spark motor1 = new Spark(1);
  Spark motor2 = new Spark(2);
  Spark motor3 = new Spark(3);
  Spark motor4 = new Spark(4);
  Spark motor5 = new Spark(5);
  Spark motor6 = new Spark(6);
  Spark motor7 = new Spark(7);
  Spark motor8 = new Spark(8);
  Spark motor9 = new Spark(9);
 
  Solenoid Sol0 = new Solenoid(0);
  Solenoid Sol1 = new Solenoid(1);
  Solenoid Sol2 = new Solenoid(2);
  Solenoid Sol3 = new Solenoid(3);
  Solenoid Sol4 = new Solenoid(4);
  Solenoid Sol5 = new Solenoid(5);
  Solenoid Sol6 = new Solenoid(6);
  Solenoid Sol7 = new Solenoid(7);
 // Compressor c = new Compressor(0);

  private int motor_index = 0;
  private int motor_select_state = 0;
  private int solenoid_index = 0;
  private int solenoid_select_state = 0;
  private Joystick GameControl = new Joystick(0);



  @Override
  public void robotInit() 
  {
    SmartDashboard.putNumber ("Channel", motor_index);
    SmartDashboard.putNumber ("Solenoid", solenoid_index);
    //c.setClosedLoopControl(true);
  }

  @Override
  public void robotPeriodic() 
  {

    switch ( motor_select_state)
    {
      case 0:
        if( GameControl.getRawButton(1) == true )
        {
          motor_index++;
          if( motor_index > 9 )
            motor_index = 0;
          motor_select_state = 1;
          SmartDashboard.putNumber ("Channel", motor_index);
        }
        break;
      
      case 1:
        if( GameControl.getRawButton(1) == false )
        {
          motor_select_state = 0;
        }
        break;
      
      default:
        motor_select_state = 0;
        motor_index = 0;
        break;
    }

    switch ( solenoid_select_state)
    {
      case 0:
        if( GameControl.getRawButton(7) == true )
        {
          solenoid_index++;
          if( solenoid_index > 7 )
            solenoid_index = 0;
          solenoid_select_state = 1;
          SmartDashboard.putNumber ("Solenoid", solenoid_index);
        }
        break;
      
      case 1:
        if( GameControl.getRawButton(7) == false )
        {
          solenoid_select_state = 0;
        }
        break;
      
      default:
        solenoid_select_state = 0;
        solenoid_index = 0;
        break;
    }


  }
  @Override
  public void autonomousInit()
  {
  }

  @Override
  public void autonomousPeriodic() 
  {
  }

  @Override
  public void teleopInit() 
  {
  }

  @Override
  public void teleopPeriodic()
  {
  }

  @Override
  public void testInit() 
  {
  }

  @Override
  public void testPeriodic() 
  {

    Motor_Controls();
//    Solenoid_Controls();

  }

  void Motor_Controls()
  {
    switch ( motor_index )
    {
      case 0:
        motor0.set( GameControl.getRawAxis(5));
        break;

      case 1:
        motor1.set( GameControl.getRawAxis(5));
        break;

      case 2:
        motor2.set( GameControl.getRawAxis(5));
        break;

      case 3:
        motor3.set( GameControl.getRawAxis(5));
        break;
        
      case 4:
        motor4.set( GameControl.getRawAxis(5));
        break;

      case 5:
        motor5.set( GameControl.getRawAxis(5));
        break;

      case 6:
        motor6.set( GameControl.getRawAxis(5));
        break;

      case 7:
        motor7.set( GameControl.getRawAxis(5));
        break;

      case 8:
        motor8.set( GameControl.getRawAxis(5));
        break;

      case 9:
        motor9.set( GameControl.getRawAxis(5));
        break;
    }
  }

  void Solenoid_Controls()
  {

    switch ( solenoid_index )
    {
      case 0:
        if( GameControl.getRawButton(5) == true)
          Sol0.set(true);
        else  
          Sol0.set(false);
        break;

      case 1:
        if( GameControl.getRawButton(5) == true)
          Sol1.set(true);
        else  
          Sol1.set(false);
        break;

      case 2:
        if( GameControl.getRawButton(5) == true)
          Sol2.set(true);
        else  
          Sol2.set(false);
        break;

      case 3:
        if( GameControl.getRawButton(5) == true)
          Sol3.set(true);
        else  
          Sol3.set(false);
        break;
        
      case 4:
        if( GameControl.getRawButton(5) == true)
          Sol4.set(true);
        else  
          Sol4.set(false);
        break;

      case 5:
        if( GameControl.getRawButton(5) == true)
          Sol5.set(true);
        else  
          Sol5.set(false);
        break;

      case 6:
        if( GameControl.getRawButton(5) == true)
          Sol6.set(true);
        else  
          Sol6.set(false);
        break;

      case 7:
        if( GameControl.getRawButton(5) == true)
          Sol7.set(true);
        else  
          Sol7.set(false);
        break;
    
    }
  }
}

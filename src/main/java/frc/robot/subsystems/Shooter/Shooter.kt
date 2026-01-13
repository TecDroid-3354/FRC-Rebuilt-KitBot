package frc.robot.subsystems.Shooter


import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.config.SparkBaseConfig
import frc.robot.subsystems.shooterConfig
import edu.wpi.first.wpilibj2.command.SubsystemBase


import com.revrobotics.spark.config.SparkMaxConfig


object Shooter : SubsystemBase() {
    val sparkConfig = SparkMaxConfig()
    val config = shooterConfig
    val motorController= SparkMax(config.motorControllerID, SparkLowLevel.MotorType.kBrushless)

    fun setSpeed(speed: Double){
        motorController.set(speed)
    }

    fun stopMotor(){
        motorController.set(0.0)
    }

    fun getSpeed(): Double{
        return motorController.get()
    }

    init{
        sparkConfig.inverted(config.inverted)
        sparkConfig.idleMode(SparkBaseConfig.IdleMode.kBrake)
        sparkConfig.smartCurrentLimit(config.motorAmpsLimit)

        motorController.configure(sparkConfig)
    }



}
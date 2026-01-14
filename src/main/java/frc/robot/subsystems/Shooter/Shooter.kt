package frc.robot.subsystems.Shooter


import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.SparkBase
import com.revrobotics.spark.config.SparkBaseConfig
import frc.robot.subsystems.shooterConfig
import edu.wpi.first.wpilibj2.command.SubsystemBase


import com.revrobotics.spark.config.SparkMaxConfig
import edu.wpi.first.units.Units


object Shooter : SubsystemBase() {
    val sparkConfig = SparkMaxConfig()
    val config = shooterConfig
    val motorController= SparkMax(config.motorControllerID, SparkLowLevel.MotorType.kBrushless)

    fun setVoltage(volts: Double){
        motorController.setVoltage(volts)
    }

    fun stopMotor(){
        motorController.setVoltage(0.0)
    }
/*
    fun getSpeed(): Double{
        return motorController.get()
    }
*/
    init{
        sparkConfig.inverted(config.inverted)
        sparkConfig.idleMode(SparkBaseConfig.IdleMode.kBrake)
        sparkConfig.smartCurrentLimit(config.currentLimit.`in`(Units.Amps).toInt())

        motorController.configure(sparkConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kNoPersistParameters)
    }



}
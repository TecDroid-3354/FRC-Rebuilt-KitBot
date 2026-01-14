package frc.robot.subsystems

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode
import edu.wpi.first.units.Units
import edu.wpi.first.units.measure.Current


data class ShooterConfig  (//this class was created to define the basic information that the motor needs.
    var motorControllerID : Int, //main Motor

    var currentLimit : Current,

    var neutralMode : IdleMode,

    var inverted : Boolean, // To be honest we have to check if being inverted is CCW or CW
)

val shooterConfig = ShooterConfig( // this instace was created to define the basic parameters that the motor needs.
    motorControllerID = 1,
    currentLimit = Units.Amps.of(40.0),
    neutralMode = IdleMode.kBrake,


    inverted = false,

    )
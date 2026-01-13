package frc.robot.subsystems


data class ShooterConfig  (//this class was created to define the basic information that the motor needs.
    var motorControllerID : Int,
    var motorAmpsLimit : Int,

    var inverted : Boolean, // To be honest we have to check if being inverted is CCW or CW
)

val shooterConfig = ShooterConfig( // this instace was created to define the basic parameters that the motor needs.
    motorControllerID = TODO(),
    motorAmpsLimit = 40,

    inverted = false,

    )
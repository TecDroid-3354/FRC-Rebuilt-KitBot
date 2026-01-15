package frc.robot

import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup
import edu.wpi.first.wpilibj2.command.WaitCommand
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import edu.wpi.first.wpilibj2.command.button.Trigger
import frc.robot.Constants.OperatorConstants
import frc.robot.commands.Autos
import frc.robot.subsystems.Shooter.Shooter
import javax.swing.GroupLayout

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the [Robot]
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 *
 * In Kotlin, it is recommended that all your Subsystems are Kotlin objects. As such, there
 * can only ever be a single instance. This eliminates the need to create reference variables
 * to the various subsystems in this container to pass into to commands. The commands can just
 * directly reference the (single instance of the) object.
 */
object RobotContainer
{
    // Replace with CommandPS4Controller or CommandJoystick if needed
    private val driverController = CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT)
    val shooter = Shooter()
    init
    {
        configureBindings()
        // Reference the Autos object so that it is initialized, placing the chooser on the dashboard
        Autos
    }

    /**
     * Use this method to define your `trigger->command` mappings. Triggers can be created via the
     * [Trigger] constructor that takes a [BooleanSupplier][java.util.function.BooleanSupplier]
     * with an arbitrary predicate, or via the named factories in [GenericHID][edu.wpi.first.wpilibj2.command.button.CommandGenericHID]
     * subclasses such for [Xbox][CommandXboxController]/[PS4][edu.wpi.first.wpilibj2.command.button.CommandPS4Controller]
     * controllers or [Flight joysticks][edu.wpi.first.wpilibj2.command.button.CommandJoystick].
     */
    private fun configureBindings()
    {
        // Schedule `ExampleCommand` when `exampleCondition` changes to `true

        // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
        // cancelling on release.
        driverController.rightBumper().onTrue(
            SequentialCommandGroup(
                InstantCommand({ shooter.setVoltage(35.0)}, shooter),
                WaitCommand(0.1),
                InstantCommand({indexer.intake()},indexer) //Dani, cuando termines el indexer pon aqui la funcion de intake.
            )).onFalse(
            SequentialCommandGroup(
                InstantCommand({ shooter.setVoltage(0.0)}, shooter),
                WaitCommand(0.1),
                InstantCommand({indexer.stop()},indexer)//Aqui pon la funcion de apagado
        ))
}}
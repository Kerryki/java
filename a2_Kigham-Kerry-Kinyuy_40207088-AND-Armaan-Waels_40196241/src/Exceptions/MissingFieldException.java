package Exceptions;

/**
 * The {@code MissingFieldException} class is an exception indicating that a required field is missing in the input.
 * <p>
 * It extends the {@code Exception} class, serving as a custom exception for cases where a mandatory field is not present.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class MissingFieldException extends Exception {
    /**
     * Constructs a new {@code MissingFieldException} with no specified detail message.
     */
    public MissingFieldException() {
        super();
    }
}

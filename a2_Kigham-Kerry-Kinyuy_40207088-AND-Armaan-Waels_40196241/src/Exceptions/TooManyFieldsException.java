package Exceptions;

/**
 * The {@code TooManyFieldsException} class is an exception indicating that there are too many fields in a record.
 * <p>
 * It extends the {@code Exception} class, serving as a custom exception for cases where the number of fields in a record
 * exceeds the expected count.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class TooManyFieldsException extends Exception {
    /**
     * Constructs a new {@code TooManyFieldsException} with no specified detail message.
     */
    public TooManyFieldsException() {
        super();
    }
}


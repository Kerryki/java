package Exceptions;

/**
 * The {@code TooFewFieldsException} class is an exception indicating that there are too few fields in a record.
 * <p>
 * It extends the {@code Exception} class, serving as a custom exception for cases where the number of fields in a record
 * is less than the expected count.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class TooFewFieldsException extends Exception {
    /**
     * Constructs a new {@code TooFewFieldsException} with no specified detail message.
     */
    public TooFewFieldsException() {
        super();
    }
}


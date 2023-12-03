package Exceptions;

/**
 * The {@code BadYearException} class represents an exception that is thrown when encountering a semantic error
 * related to an invalid publication year in the input data.
 * <p>
 * This exception is raised when the year of publication of a book is considered invalid, falling outside the
 * expected range.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class BadyearException extends Exception{

    /**
     * Constructs a new {@code BadyearException} with no specified detail message.
     */
    public BadyearException() {
        super();
    }

}

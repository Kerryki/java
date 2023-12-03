package Exceptions;

/**
 * The {@code BadIsbn13Exception} class represents an exception that is thrown when encountering a semantic error
 * related to an ISBN-13 format in the input data.
 * <p>
 * ISBN-13 (International Standard Book Number with 13 digits) is a unique identifier for books.
 * This exception is raised when the ISBN-13 does not meet the required validation criteria.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class BadIsbn13Exception extends Exception{
    /**
     * Constructs a new {@code BadIsbn13Exception} with no specified detail message.
     */
    public BadIsbn13Exception() {
        super();
    }
}

package Exceptions;

/**
 * The {@code BadIsbn10Exception} class represents an exception that is thrown when encountering a semantic error
 * related to an ISBN-10 format in the input data.
 * <p>
 * ISBN-10 (International Standard Book Number with 10 digits) is a unique identifier for books.
 * This exception is raised when the ISBN-10 does not meet the required validation criteria.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class BadIsbn10Exception extends Exception{
    /**
     * Constructs a new {@code BadIsbn10Exception} with no specified detail message.
     */
    public BadIsbn10Exception() {
        super();
    }

}

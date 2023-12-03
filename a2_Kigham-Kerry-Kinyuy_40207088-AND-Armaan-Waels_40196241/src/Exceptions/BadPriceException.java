package Exceptions;

/**
 * The {@code BadPriceException} class represents an exception that is thrown when encountering a semantic error
 * related to an invalid price in the input data.
 * <p>
 * This exception is raised when the price of a book is considered invalid, such as being negative.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class BadPriceException extends Exception{

    /**
     * Constructs a new {@code BadPriceException} with no specified detail message.
     */
    public BadPriceException() {
        super();
    }

}

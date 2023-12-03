package Exceptions;

/**
 * The {@code UnknownGenreException} class is an exception indicating that an unknown genre is encountered.
 * <p>
 * It extends the {@code Exception} class, serving as a custom exception for cases where the genre of a book
 * is not recognized or falls into an unexpected category.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class UnknownGenreException extends Exception {
    /**
     * Constructs a new {@code UnknownGenreException} with no specified detail message.
     */
    public UnknownGenreException() {
        super();
    }
}


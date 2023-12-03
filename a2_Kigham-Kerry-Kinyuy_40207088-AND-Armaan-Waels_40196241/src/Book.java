//-------------------------------------------
// Assignment 2
//
// Written by: Kigham Kerry Kinyuy, 40207088 and Armaan Waels 40196241
//-------------------------------------------



import java.io.Serializable;

/**
 * Name(s) and ID(s): Kigham Kerry Kinyuy 40207088 and Armaan Waels 40196241
 * COMP249 Assignment #2
 * Due Date: 11 Nov 2023
 * **/

/**
 * The {@code Book} class represents a book with various attributes such as title, author, price, ISBN, genre, and year.
 * <p>
 * This class implements the {@link Serializable} interface to support serialization.
 * </p>
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date or Version Number]
 */
public class Book implements Serializable {
    /** The title of the book. */
    public String title;

    /** The author of the book. */
    public String author;

    /** The price of the book. */
    public double price;

    /** The ISBN (International Standard Book Number) of the book. */
    public String ISBN;

    /** The genre of the book. */
    public String genre;

    /** The year of publication of the book. */
    public int year;

    /**
     * Constructs a new {@code Book} with the specified attributes.
     *
     * @param title  the title of the book.
     * @param author the author of the book.
     * @param price  the price of the book.
     * @param ISBN   the ISBN of the book.
     * @param genre  the genre of the book.
     * @param year   the year of publication of the book.
     */

    /**
     * Constructs a new {@code Book} with the specified attributes.
     *
     * @param title  the title of the book.
     * @param author the author of the book.
     * @param price  the price of the book.
     * @param ISBN   the ISBN of the book.
     * @param genre  the genre of the book.
     * @param year   the year of publication of the book.
     */
    public Book(String title, String author, double price, String ISBN, String genre, int year) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.ISBN = ISBN;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Gets the title of the book.
     *
     * @return the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return the author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the price of the book.
     *
     * @return the price of the book.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param price the price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the ISBN of the book.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param ISBN the ISBN to set.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets the genre of the book.
     *
     * @return the genre of the book.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genre the genre to set.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the year of publication of the book.
     *
     * @return the year of publication of the book.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of publication of the book.
     *
     * @param year the year to set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Checks if this book is equal to another object.
     *
     * @param obj the object to compare.
     * @return {@code true} if the books are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;
        else {
            Book otherbook = (Book) obj;
            return (otherbook.title.equals(this.title)) && (this.author.equals(otherbook.author))
                    && (this.price == otherbook.price) && (this.ISBN.equals(otherbook.ISBN))
                    && (this.genre.equals(otherbook.genre)) && (this.year == otherbook.year);
        }
    }

    /**
     * Returns a string representation of the book.
     *
     * @return a string representation of the book.
     */
    @Override
    public String toString() {
        return title + "," + author + "," + price + "," + ISBN + "," + genre + "," + year;
    }
}
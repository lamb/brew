package org.mynah.brew.jdbc.exception;

import org.springframework.dao.DataRetrievalFailureException;

/**
 * Data access exception thrown when a column was not of the expected size, for example when expecting a single column but getting 0 or more than 1 columns.
 * 
 * @author Lamb
 * @since 0.0.1
 * @see EmptyResultDataAccessException
 */
@SuppressWarnings("serial")
public class IncorrectColumnSizeDataAccessException extends DataRetrievalFailureException {

    private int expectedSize;

    private int actualSize;

    /**
     * Constructor for IncorrectColumnSizeDataAccessException.
     * 
     * @param expectedSize
     *            the expected column size
     */
    public IncorrectColumnSizeDataAccessException(int expectedSize) {
        super("Incorrect column size: expected " + expectedSize);
        this.expectedSize = expectedSize;
        this.actualSize = -1;
    }

    /**
     * Constructor for IncorrectColumnSizeDataAccessException.
     * 
     * @param expectedSize
     *            the expected column size
     * @param actualSize
     *            the actual column size (or -1 if unknown)
     */
    public IncorrectColumnSizeDataAccessException(int expectedSize, int actualSize) {
        super("Incorrect column size: expected " + expectedSize + ", actual " + actualSize);
        this.expectedSize = expectedSize;
        this.actualSize = actualSize;
    }

    /**
     * Constructor for IncorrectColumnSizeDataAccessException.
     * 
     * @param msg
     *            the detail message
     * @param expectedSize
     *            the expected column size
     */
    public IncorrectColumnSizeDataAccessException(String msg, int expectedSize) {
        super(msg);
        this.expectedSize = expectedSize;
        this.actualSize = -1;
    }

    /**
     * Constructor for IncorrectColumnSizeDataAccessException.
     * 
     * @param msg
     *            the detail message
     * @param expectedSize
     *            the expected column size
     * @param ex
     *            the wrapped exception
     */
    public IncorrectColumnSizeDataAccessException(String msg, int expectedSize, Throwable ex) {
        super(msg, ex);
        this.expectedSize = expectedSize;
        this.actualSize = -1;
    }

    /**
     * Constructor for IncorrectColumnSizeDataAccessException.
     * 
     * @param msg
     *            the detail message
     * @param expectedSize
     *            the expected column size
     * @param actualSize
     *            the actual column size (or -1 if unknown)
     */
    public IncorrectColumnSizeDataAccessException(String msg, int expectedSize, int actualSize) {
        super(msg);
        this.expectedSize = expectedSize;
        this.actualSize = actualSize;
    }

    /**
     * Constructor for IncorrectColumnSizeDataAccessException.
     * 
     * @param msg
     *            the detail message
     * @param expectedSize
     *            the expected column size
     * @param actualSize
     *            the actual column size (or -1 if unknown)
     * @param ex
     *            the wrapped exception
     */
    public IncorrectColumnSizeDataAccessException(String msg, int expectedSize, int actualSize, Throwable ex) {
        super(msg, ex);
        this.expectedSize = expectedSize;
        this.actualSize = actualSize;
    }

    /**
     * Return the expected column size.
     */
    public int getExpectedSize() {
        return this.expectedSize;
    }

    /**
     * Return the actual column size (or -1 if unknown).
     */
    public int getActualSize() {
        return this.actualSize;
    }

}

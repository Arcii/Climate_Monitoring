package com.climatemonitoring.clientCM.utils;

/**
 * Custom exception class representing a format error in a field.
 * This exception is thrown when there is an issue with the format of a field.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 */
public class FieldFormatException extends Exception{

    /**
     * Constructs a new instance of FieldFormatException with the specified detail message.
     *
     * @param message The detail message, which is saved for later retrieval by the getMessage() method.
     */
    public FieldFormatException(String message){
        super(message);
    }

}

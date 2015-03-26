package util;

/**
 * Created by florian on 11/11/14.
 */
public enum ErrorMessage {

    WRONG_AUTHORIZATION,
    LOGIN_WRONG_PASSWORD_LOGIN,
    NOT_CONNECTED,
    WRONG_PASSWORD,
    UNIQUE_CONSTRAIN_VIOLATION,
    EMAIL_ALREADY_USED,
    DTO_NOT_EXPECTED,
    FATAL_ERROR,
    JSON_CONVERSION_ERROR,
    //not translate yet
    VALIDATION_SIZE,
    VALIDATION_NOT_NULL,
    DTO_VERIFICATION_PATTERN_STRING_EXPECTED, //a strign flied is expected for the pattern annotation, but th field {0} is a {1}
    VALIDATION_PATTERN,
    NOT_YOURSELF,
    NOT_YOUR_OLD_PASSWORD,
    NOT_YOUR_PASSWORD,
    VALIDATION_EMAIL,
    VALIDATION_PASSWORD

}

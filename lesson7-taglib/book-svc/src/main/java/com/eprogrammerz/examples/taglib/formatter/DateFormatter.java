package com.eprogrammerz.examples.taglib.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {

    private String datePattern;
    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern) {
        System.out.println("DateFormatter()5b========");
        this.datePattern = datePattern;
        dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
    }

    @Override
    public String print(Date date, Locale locale) {
        System.out.println("DateFormatter PRINT");
        return dateFormat.format(date);
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        System.out.println("DateFormatter PARSE");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            // the error message will be displayed when using <form:errors>
            throw new IllegalArgumentException(
                    "invalid date format. Please use this pattern\""
                            + datePattern + "\"");
        }
    }
}
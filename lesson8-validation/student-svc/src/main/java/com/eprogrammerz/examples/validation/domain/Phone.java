/**
 *
 */
package com.eprogrammerz.examples.validation.domain;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author B.Pirasanth
 */
public class Phone implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    @NumberFormat(style = Style.NUMBER)
    @Range(min = 100, max = 999, message = "{Size.phone.validation}")
    private int area;

    @NotNull
    @NumberFormat(style = Style.NUMBER)
    @Range(min = 100, max = 999, message = "{Size.phone.validation}")
    private int prefix;

    @NotNull
    @NumberFormat(style = Style.NUMBER)
    @Range(min = 1000, max = 9999, message = "{Size.phone.validation.number}")
    private int number;


    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }
}

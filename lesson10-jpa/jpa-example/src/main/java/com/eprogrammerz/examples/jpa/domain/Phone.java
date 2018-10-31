/**
 *
 */
package com.eprogrammerz.examples.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author J Bruen
 */
@Entity
public class Phone implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @OneToOne(mappedBy = "hotLine", cascade = CascadeType.ALL)
    Product product;
    @Column(name = "AREA_CODE")
    private Integer areaCode;
    @Column(name = "P_NUMBER")
    private Integer number;
    private Integer prefix;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer area) {
        this.areaCode = area;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPrefix() {
        return prefix;
    }

    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }
}

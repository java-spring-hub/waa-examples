package app04a.domain;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 5784L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
    private String description;
    private float price;

    @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name="phone_id")
    private Phone hotLine;

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
	public Phone getHotLine() {
		return hotLine;
	}
	public void setHotLine(Phone hotLine) {
		this.hotLine = hotLine;
	}
}
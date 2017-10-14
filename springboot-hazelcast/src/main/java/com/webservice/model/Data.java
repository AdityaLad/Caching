package com.webservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hotel_data")
public class Data implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String hotelid;
    
    @NotNull
    private String rsq;
    
    @NotNull
    private Integer ap;
    
    @NotNull
    private Integer discount;
    
    public Data() {}
    
    public Long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

	public String getHotelid() {
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}

	public String getRsq() {
		return rsq;
	}

	public void setRsq(String rsq) {
		this.rsq = rsq;
	}

	public Integer getAp() {
		return ap;
	}

	public void setAp(Integer ap) {
		this.ap = ap;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
    
    
}

package com.chinayouthedu.zqzc.common.utils.excelread;
import java.io.Serializable;
import java.util.Date;

public class Good implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 是否在销售
	 */
	private Boolean sale;
	/**
	 * 上架时间
	 */
	private Date upDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getSale() {
		return sale;
	}

	public void setSale(Boolean sale) {
		this.sale = sale;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	public Good() {
		super();
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", sale=" + sale + ", upDate=" + upDate + "]";
	}
	
	
}

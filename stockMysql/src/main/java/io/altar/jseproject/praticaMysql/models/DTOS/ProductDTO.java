package io.altar.jseproject.praticaMysql.models.DTOS;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import io.altar.jseproject.praticaMysql.models.Product;

@ManagedBean
public class ProductDTO extends EntityDTO<Product> {
	
	private List<Long> shelfIds = new ArrayList<Long>();
	private int discount;
	private int iva;
	private float pvp;

	public ProductDTO() {
	}
	
	public ProductDTO(long id,List<Long> shelfIds, int discount, int iva, float pvp) {
		this.id = id;
		this.shelfIds = shelfIds;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct on ProductDTO");
		System.out.println(this);
	}

	public List<Long> getShelfIds() {
		return shelfIds;
	}

	public void setShelfIds(List<Long> shelfIds) {
		this.shelfIds = shelfIds;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	@Override
	public String toString() {
		return "ProductDTO [shelfIds=" + shelfIds + ", discount=" + discount + ", iva=" + iva + ", pvp=" + pvp + "]";
	}
}

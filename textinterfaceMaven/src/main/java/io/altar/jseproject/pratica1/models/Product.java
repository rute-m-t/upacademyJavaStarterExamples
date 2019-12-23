package io.altar.jseproject.pratica1.models;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private long id;
	private List<Long> shelvesIds = new ArrayList<Long>();
	private int discount;
	private int iva;
	private float pvp;
	
	
	public Product() {}
	
	public Product(int discount, int iva, float pvp) {
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}

	public Product(long id, List<Long> shelvesIds, int discount, int iva, float pvp) {
		this.id = id;
		this.shelvesIds = shelvesIds;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Long> getShelvesIds() {
		return shelvesIds;
	}
	public void setShelvesIds(List<Long> shelvesIds) {
		this.shelvesIds = shelvesIds;
	}
	public void addShelfId(long shelfId) {
		this.shelvesIds.add(shelfId);
	}
	public void removeShelfId(long shelfId) {
		this.shelvesIds.remove(shelfId);
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
		return "Product [id=" + id + ", shelvesIds=" + shelvesIds + ", discount=" + discount + ", iva=" + iva + ", pvp="
				+ pvp + "]";
	}
	
	
	
}

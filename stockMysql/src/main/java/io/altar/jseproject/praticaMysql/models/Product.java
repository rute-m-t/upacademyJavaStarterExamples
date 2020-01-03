package io.altar.jseproject.praticaMysql.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = Product.GET_ALL_PRODUCTS, query = "SELECT p FROM Product p"),
	@NamedQuery(name = Product.GET_ALL_PRODUCTS_IDS, query = "SELECT p.id FROM Product p"),
	@NamedQuery(name = Product.GET_PRODUCTS_COUNT, query = "SELECT COUNT(p.id) FROM Product p")
})
public class Product extends Entity_ {

	public static final String GET_ALL_PRODUCTS = "getAllProducts";
	public static final String GET_ALL_PRODUCTS_IDS = "getAllProductsIds";
	public static final String GET_PRODUCTS_COUNT = "getProductsCount";

	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "product", fetch = FetchType.EAGER)
	private List<Shelf> shelves;
	private int discount;
	private int iva;
	private float pvp;
	
	public static String getName() {
		return "Product";
	}

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
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

//	@Override
//	public String toString() {
//		return "Product [shelves=" + shelves + ", discount=" + discount + ", iva=" + iva + ", pvp=" + pvp + "]";
//	}
}
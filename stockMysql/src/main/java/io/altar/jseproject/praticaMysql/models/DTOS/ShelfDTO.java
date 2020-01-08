package io.altar.jseproject.praticaMysql.models.DTOS;

public class ShelfDTO extends EntityDTO {

	private long productId;
	private int capacity;
	private float dailyPrice;

	public ShelfDTO() {
	}

	public ShelfDTO(long id, int capacity, float dailyPrice, long productId) {
		this.id = id;
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
		this.productId = productId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	@Override
	public String toString() {
		return "ShelfDTO [productId=" + productId + ", capacity=" + capacity + ", dailyPrice=" + dailyPrice + "]";
	}
	
}

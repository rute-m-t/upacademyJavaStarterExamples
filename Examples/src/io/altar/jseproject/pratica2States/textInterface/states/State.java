package io.altar.jseproject.pratica2States.textInterface.states;

import io.altar.jseproject.pratica2States.services.ProductService;
import io.altar.jseproject.pratica2States.services.ShelfService;
import io.altar.jseproject.pratica2States.textInterface.scannerUtils.ScannerUtils;

public abstract class State {
	public static final ScannerUtils SCANNER_UTILS = new ScannerUtils();
	public static final ProductService PRODUCT_SERVICE = new ProductService();
	public static final ShelfService SHELF_SERVICE = new ShelfService();
	
	public abstract int run();
}

package in.laptop.service;

import java.util.List;

import in.laptop.entity.Product;

public interface IProdService {
	
	public List<Product> getAllProds();
	
	public boolean saveProd(Product product);
	
	public void deleteProd(Integer pid);
	
	public Product updateProd(Integer pid);

}

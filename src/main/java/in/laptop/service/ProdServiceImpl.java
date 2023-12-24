package in.laptop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.laptop.entity.Product;
import in.laptop.repo.ProdRepository;

@Service
public class ProdServiceImpl implements IProdService {
	
	@Autowired
	private ProdRepository prodRepo;

	public List<Product> getAllProds() {
		return prodRepo.findByActiveSW("Active");
	}
	
	@Override
	public boolean saveProd(Product product) {
		Product save = prodRepo.save(product);
		if(save.getPid() != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void deleteProd(Integer pid) {
//		prodRepo.deleteById(pid);
		Optional<Product> findById = prodRepo.findById(pid);
		if(findById.isPresent()) {
			Product product = findById.get();
			product.setActiveSW("In-Active");
			prodRepo.save(product);
		}
	}
	
	@Override
	public Product updateProd(Integer pid) {
		Optional<Product> findById = prodRepo.findById(pid);
		if(findById.isPresent()) {
			Product product = findById.get();
			return product;
		}
		return null;
	}
}

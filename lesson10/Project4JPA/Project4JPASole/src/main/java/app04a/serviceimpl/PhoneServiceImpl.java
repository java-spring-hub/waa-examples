package app04a.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app04a.domain.Phone;
import app04a.repository.EmployeeRepository;
import app04a.repository.PhoneRepository;
import app04a.service.PhoneService;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
	PhoneRepository phoneRepository;
	
  	public List<Phone> getAll() {
		return  (List<Phone>) phoneRepository.findAll();
	}
	
	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
		
	}
	
	
		   
}
 

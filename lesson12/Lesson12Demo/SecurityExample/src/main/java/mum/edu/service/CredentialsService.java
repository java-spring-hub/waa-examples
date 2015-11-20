package mum.edu.service;

import java.util.List;

import mum.edu.domain.Credentials;
import mum.edu.domain.Member;
 
public interface CredentialsService {

	public void save(Credentials credentials);
	public List<Credentials> findAll();
 }

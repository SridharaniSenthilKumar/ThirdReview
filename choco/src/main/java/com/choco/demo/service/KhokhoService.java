package com.choco.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.choco.demo.model.details;
import com.choco.demo.repository.KhokhoRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
@Service
public class KhokhoService {
@Autowired
KhokhoRepository kRepository;
	public List<details> getAllDatas() {
		List<details>dataList=kRepository.findAll();
		return dataList;
	}

	public details saveKhokho(details a) {
		details obj=kRepository.save(a);
		return obj;
	}
	
	public details updateKhokho(details a) {
		details obj=kRepository.save(a);
		return obj;
	}
	
	public void deleteKhokho(int playerID) {
		kRepository.deleteById(playerID);
	}
	
	public List<details>sortAsec(String field)
	{
		return kRepository.findAll(Sort.by(field).ascending());
	}
	public List<details>pagination(int pageno,int pagesize){
		Page<details>p = kRepository.findAll(PageRequest.of(pageno, pagesize));
		return p.getContent();
	}
	public List<details>sortTennisData(String field){
 		return kRepository.findAll(Sort.by(field));
 	}
 	
 	public List<details> sortDesTennisData(String field){
 		
 		return kRepository.findAll(Sort.by(Direction.DESC,field));
 	}

 	public List<details> getpaginationss(int offset, int pagesize) {
 		
 		Page<details> paging=kRepository.findAll(PageRequest.of(offset, pagesize));
 		return paging.getContent();
 	}

 	public List<details> getsortpaginations(int offset, int pagesize,String field) {
 		
 		Page<details> paging=kRepository.findAll(PageRequest.of(offset, pagesize,Sort.by(field)));
 		return paging.getContent();
 	}
 	
public details register(@RequestBody details id) {
		
		return kRepository.save(id);
	}
public List<details>getFieldByData(String fullname) {
	List<details> dataList=kRepository.getFieldByData(fullname);
	return dataList;
}
@Transactional
public int deleteFieldByData(String fullname) {
	return kRepository.deleteFieldByData(fullname);
}s

@Transactional
public int UpdateFieldByData(String fullname,int playerID) {
	return kRepository.UpdateFieldByData(fullname,playerID);
}

public List<details> sortKhokho(String field) {
	// TODO Auto-generated method stub
	return null;
}

public List<details> sortDesKhokho(String field) {
	// TODO Auto-generated method stub
	return null;
}

}
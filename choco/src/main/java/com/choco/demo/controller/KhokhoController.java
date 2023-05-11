package com.choco.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.choco.demo.model.details;
import com.choco.demo.service.KhokhoService;

@RestController
public class KhokhoController {
	@Autowired
	KhokhoService khokhoService;
@GetMapping(value="/fetchdata")
public List<details>getAllDatas(){
	List<details>dataList=khokhoService.getAllDatas();
	return dataList;
}
@PostMapping(value="/saveKhokho")
public details saveKhokho(@RequestBody details a)
{
	return khokhoService.saveKhokho(a);
}
@PutMapping(value="/updateKhokho")
public details updateAthletics(@RequestBody details a)
{
	return khokhoService.saveKhokho(a);
}
@DeleteMapping(value="/deleteKhokho/{id}")
public void deleteKhokho(@PathVariable("id") int playerID)
{
	khokhoService.deleteKhokho(playerID);
}

//sorting
	@GetMapping("/pageget/{mname}")
	public List<details>sortmovie(@PathVariable("mname")String mname)
	{
		return khokhoService.sortAsec(mname);
	}
	//pagination
	@GetMapping("/pagination/{pageno}/{pagesize}")
	public List<details>page(@PathVariable("pageno")int pageno,@PathVariable("pagesize")int pagesize){
	{
		return khokhoService.pagination(pageno,pagesize);
	}
	}
	@GetMapping("/auto/{field}")
	public List<details>sortCrudD(@PathVariable String field){
		return khokhoService.sortKhokho(field);
	}
	@GetMapping("/autio")
	public List<details>sortCrudDes(@RequestParam String field){
		return khokhoService.sortDesKhokho(field);
	}
	
	
	@GetMapping("/pagination")
	
	public List<details> pagination(@RequestParam int offset,@RequestParam int pagesize){
		
		return khokhoService.getpaginationss(offset,pagesize);
	}
	
	@GetMapping("/sortpagination")
	
	public List<details> sortpagination(@RequestParam int offset,@RequestParam int pagesize,String field){
		
		return khokhoService.getsortpaginations(offset,pagesize,field);
	}
	
	
	@PostMapping("/reg")
	public details regid(@RequestBody details id) {
		
		
		return khokhoService.register(id);
		
	}
	@GetMapping("/getFieldByData/{field}")
	 public List<details>getFieldByData(@PathVariable String fullname) {
		 List<details> dataList=khokhoService.getFieldByData(fullname);
		 return dataList;
	 }
	 
	 @DeleteMapping("/deleteFieldByData/{fullname}")
	 public String deleteFieldByData(@PathVariable String fullname) {
		 int result=khokhoService.deleteFieldByData(fullname);
		 if(result>0)
			 return "Data record deleted";
		 else
			 return "Problem occured while deleting";
	 }
	 @PutMapping("/updateFieldByData/{fullname}/{playerID}")
	 public String updateFieldByData(@PathVariable String fullname,@PathVariable int payerID) {
		 int result=khokhoService.UpdateFieldByData(fullname,payerID);
		 if(result>0)
			 return "Data record updated";
		 else
			 return "Problem occured while updating";
	 }
	
}
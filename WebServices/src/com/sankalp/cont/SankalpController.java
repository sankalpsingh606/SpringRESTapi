package com.sankalp.cont;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sankalp.model.User;

@RestController
public class SankalpController {

	List<User> list = new ArrayList();

	@PostMapping("/insert")
	public String insert(@RequestBody User user) {
		list.add(user);
		return "success";
	}
	@GetMapping("/fetch")
	public List<User> getAllUser(){
		return list;
	}
	@DeleteMapping("/delete/{id}")
	public List<User> delete(@PathVariable String id){
		System.out.println(id);
		Optional<User> u=list.stream().filter(x->x.getPassword().equals(id)).findAny();
		list.remove(u.get());
		return list;
	}
	@PutMapping("/update")
	public List<User> update(@RequestBody User user){
		Optional<User> u=list.stream().filter(x->x.getPassword().equals(user.getPassword())).findAny();
		list.set(list.indexOf(u.get()), user);
		return list;
		
	}
}

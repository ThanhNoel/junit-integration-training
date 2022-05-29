package com.thanh.demo.controller;

import java.util.List;

import com.thanh.demo.dto.BasicDto;
import com.thanh.demo.dto.BasicsDto;
import com.thanh.demo.mapper.BasicMapper;
import com.thanh.demo.request.CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.thanh.demo.model.Basic;
import com.thanh.demo.service.BasicService;

@RestController
@RequestMapping("/basics")
public class BasicController 
{
	@Autowired
	private BasicService basicService;

	@Autowired
	private BasicMapper basicMapper;
	
	@GetMapping("")
	public BasicsDto findAll() {
		List<Basic> basics = basicService.findAll();
		List<BasicDto> basicDtos = basicMapper.map(basics);
		return new BasicsDto(basicDtos);
	}
	
	@GetMapping("/{id}")
	public BasicDto findById(@PathVariable int id) {
		Basic basic = basicService.findById(id);
		if(basic == null) {
			return null;
		}
		return basicMapper.map(basic);
	}
	
	@PostMapping("")
	public BasicDto save(@RequestBody CreateRequest createRequest) {
		Basic basic = basicMapper.map(createRequest);
		basic = basicService.save(basic);
		if(basic == null) {
			return null;
		}
		return basicMapper.map(basic);
	}
	
	@DeleteMapping("/{id}")
	public BasicDto deleteById(@PathVariable int id) {
		Basic basic = basicService.deleteById(id);
		if(basic == null) {
			return null;
		}
		return basicMapper.map(basic);
	}

	@PutMapping("")
	public BasicDto update(@RequestBody BasicDto basicDto) {
		Basic basic = basicMapper.map(basicDto);
		basic = basicService.update(basic);
		if(basic == null) {
			return null;
		}
		return basicMapper.map(basic);
	}
}

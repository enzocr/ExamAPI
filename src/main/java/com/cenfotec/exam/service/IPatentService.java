package com.cenfotec.exam.service;

import java.util.List;

import com.cenfotec.exam.domain.Patent;

public interface IPatentService {

	public Patent set(Patent patent) throws Exception, Throwable;

	public List<Patent> getAll();

	public Patent getById(String id) throws Exception;

	public Patent getByGUID(String id) throws Exception;
	
	public Patent getByName(String name) throws Exception;

	public Patent update(Patent patent) throws Exception;

	public boolean delete(String id) throws Exception;

}

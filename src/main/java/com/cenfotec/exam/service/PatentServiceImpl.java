package com.cenfotec.exam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.exam.domain.Patent;
import com.cenfotec.exam.repository.PatentRepository;

@Service
public class PatentServiceImpl implements IPatentService {
	@Autowired
	PatentRepository repo;

	@Override
	public Patent set(Patent patent) throws Throwable {

		String guid = null;
		try {
			guid = new ClientServiceHttpImpl().getGUID();
		} catch (Throwable exception) {
			throw exception;
		}

		patent.setGuid(guid);
		patent.setEntry_date(new Date());

		repo.save(patent);

		return patent;
	}

	@Override
	public List<Patent> getAll() {
		return repo.findAll();
	}

	@Override
	public Patent getById(String id) throws Exception {
		return repo.findById(id).get();
	}

	@Override
	public Patent getByGUID(String guid) throws Exception {
		return repo.findByGuid(guid).get();
	}

	@Override
	public Patent getByName(String name) throws Exception {
		return repo.findByName(name).get();
	}

	@Override
	public Patent update(Patent patent) throws Exception {

		Patent ref = getById(patent.getId());
		patent.setGuid(ref.getGuid());
		patent.setEntry_date(new Date());
		repo.save(patent);
		return patent;

	}

	@Override
	public boolean delete(String id) throws Exception {

		repo.deleteById(id);

		if (repo.existsById(id)) {
			return false;
		} else {
			return true;
		}

	}

}

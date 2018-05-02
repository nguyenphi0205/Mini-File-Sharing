package com.dxc.msf.dao;

import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.msf.model.FileDTO;

@Repository
public class FileDAOImpl implements FileDAO {

	@Autowired
	SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public boolean AddUploadFile(FileDTO file) {
		try {
			UUID uuid = UUID.randomUUID();
			file.setFileID(uuid.toString());
			file.setCreateFileDate(new Date());
			file.setLastModifyDate(new Date());
			Session session = sessionfactory.openSession();
			Transaction transaction =session.beginTransaction();
			session.save(file);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

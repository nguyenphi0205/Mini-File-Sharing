package com.dxc.msf.dao;


import java.util.List;

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

	@Override
	public List<FileDTO> getListFile() {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			List<FileDTO> list = (List<FileDTO>) session.createQuery("from Files").list();
			transaction.commit();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

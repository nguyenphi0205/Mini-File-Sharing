package com.dxc.msf.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.msf.model.DownloadDTO;

@Repository
public class DownloadFileDAOImpl implements DownloadFileDAO {

	@Autowired
	SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public Boolean AddDownloadFile(DownloadDTO download) {
		try {
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			download.setDownloadDate(new Date());
			session.save(download);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<DownloadDTO> getListDownload() {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			List<DownloadDTO> list = (List<DownloadDTO>) session.createQuery("from Downloads").list();
			transaction.commit();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

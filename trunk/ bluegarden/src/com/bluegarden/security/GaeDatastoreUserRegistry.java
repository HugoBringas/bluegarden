package com.bluegarden.security;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.bluegarden.dbo.PMF;
import com.bluegarden.entities.GaeUser;

public class GaeDatastoreUserRegistry implements UserRegistry {

	@Override
	public GaeUser findUser(String userId) {
		PersistenceManager manager = null;
		GaeUser gaeUser = null;
		Query query = null;
		try {
			manager = PMF.get().getPersistenceManager();
			query = manager.newQuery(GaeUser.class);
			query.setFilter("googleId == googleIdParam");
			query.declareParameters("String googleIdParam");
			query.setUnique(true);
			gaeUser = (GaeUser) query.execute(userId);
		} finally {
			if (manager != null) {
				manager.close();
				if (query != null) {
					query.closeAll();
				}
			}
		}
		return gaeUser;
	}

	@Override
	public void registerUser(GaeUser newUser) {
		PersistenceManager manager = null;
		try {
			manager = PMF.get().getPersistenceManager();
			manager.makePersistent(newUser);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}

	}

	@Override
	public void removeUser(String userId) {
		PersistenceManager manager = null;
		Query query = null;
		try {
			manager = PMF.get().getPersistenceManager();
			query = manager.newQuery(GaeUser.class);
			query.setFilter("googleId == googleIdParam");
			query.declareParameters("String googleIdParam");
			query.deletePersistentAll(userId);
		} finally {
			if (manager != null) {
				manager.close();
				if (query != null) {
					query.closeAll();
				}
			}
		}
	}

}

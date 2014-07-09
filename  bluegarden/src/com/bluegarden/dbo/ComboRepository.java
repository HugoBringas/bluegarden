package com.bluegarden.dbo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.bluegarden.entities.Combo;

public class ComboRepository implements IComboRepository {

	@Override
	public void saveCombo(Object combo) {
		PersistenceManager manager = null;
		try {
			manager = PMF.get().getPersistenceManager();
			manager.makePersistent(combo);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}

	}

	@Override
	public List<Combo> getAllCombos() {
		PersistenceManager manager = null;
		List<Combo> combos = null;
		try {
			manager = PMF.get().getPersistenceManager();
			Query query = manager.newQuery(Combo.class);
			combos = (List<Combo>) query.execute();
			return combos != null ? combos : new ArrayList<Combo>();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	@Override
	public void deleteCombo(int id) {
		PersistenceManager manager = null;
		Query query = null;
		try {
			manager = PMF.get().getPersistenceManager();
			query = manager
					.newQuery("DELETE FROM COMBO WHERE NAME =" + 4785074604081152L);
		} finally {
			if (query != null) {
				query.closeAll();
			}

			if (manager != null) {
				manager.close();
			}
		}
	}

	@Override
	public Combo getCombo(String key) {
		PersistenceManager manager = null;
		Combo combo = null;
		try {
			manager = PMF.get().getPersistenceManager();
		    combo = manager.getObjectById(Combo.class, key);
		} finally {
			if (manager != null) {
				manager.close();
			}

		}
		return combo;
	}

}

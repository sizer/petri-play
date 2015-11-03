package models.service.dao;

import java.util.ArrayList;
import java.util.List;

import models.entity.Qanda;

public class QandaDao extends BaseDao {

	private static final long serialVersionUID = 1L;

	/**
	 * isQuestion=1をキーに、QANDAリストを取得する
	 */
	public List<Qanda> getQuestions() {
		List<Qanda> retList = new ArrayList<>();
		List<Qanda> qList = findAll(Qanda.class);
		for (Qanda q : qList) {
			if (q.isQuestion != 0) {
				retList.add(q);
			}
		}
		return retList;
	}

}

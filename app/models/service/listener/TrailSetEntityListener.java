package models.service.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import models.entity.AbstractTrailEntity;
import models.entity.User;
import utils.DateUtil;
import utils.NumericUtil;

/**
 * listener for set trail info to entity.
 *
 * @author mrdShinse
 * @param <T>
 *            Entity with trail info
 */
public class TrailSetEntityListener<T extends AbstractTrailEntity> {

	/**
	 * 登録処理キャッチリスナー
	 *
	 * @param entity
	 *            対象のエンティティ
	 */
	@PrePersist
	public void setPrePersistTrail(T entity) {
		setPersistTrail(entity);
	}

	/**
	 * 更新処理キャッチリスナー
	 *
	 * @param entity
	 *            対象のエンティティ
	 */
	@PreUpdate
	public void setPreUpdateTrail(T entity) {
		setUpdateTrail(entity);
	}

	// ----------------------------------------------------- Private Method Area
	/**
	 * 登録時証跡情報設定処理
	 *
	 * @param entity
	 *            対象のエンティティ
	 */
	private void setPersistTrail(T entity) {
		System.out.println("------------------setPersistTrail()------------------");
		Date now = DateUtil.now();
		System.out.println("now:"+now);
		entity.setCreateUser(User.getLoginUser());
		entity.setCreateTime(now);
		entity.setUpdateUser(User.getLoginUser());
		entity.setUpdateTime(now);
		entity.setDeleteFlg(NumericUtil.INTEGER_ZERO);
	}

	/**
	 * 更新時証跡情報設定処理
	 *
	 * @param entity
	 *            対象のエンティティ
	 */
	private void setUpdateTrail(T entity) {
		Date now = DateUtil.now();
		entity.setUpdateUser(User.getLoginUser());
		entity.setUpdateTime(now);
	}

}

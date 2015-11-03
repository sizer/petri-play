package models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import models.service.listener.TrailSetEntityListener;
import utils.DateUtil;

/**
 * Abstract class of Entity with trail info
 *
 * @author mrdShinse
 */
@MappedSuperclass
@EntityListeners({ TrailSetEntityListener.class })
public abstract class AbstractTrailEntity extends AbstractEntity {

	@Getter	@Setter
	@NotNull @Column(name = "create_time")
	@Temporal(TemporalType.DATE)
	protected Date createTime;

	@ManyToOne @JoinColumn(name="user_id")
	@Getter @Setter
	@NotNull
	protected User createUser;

	@Getter	@Setter
	@NotNull @Column(name = "update_time")
	@Temporal(TemporalType.DATE)
	protected Date updateTime;

	@ManyToOne @JoinColumn(name="user_id")
	@Getter	@Setter
	@NotNull
	protected User updateUser;

	@Getter	@Setter
	@NotNull @Column(name = "is_delete")
	protected Integer deleteFlg;

	/**
	 * 最終更新からの経過時間を取得する。
	 *
	 * @return 最終更新からの経過時間
	 */
	public String getSinceLastUpdate() {
		return DateUtil.howLongFromNow(updateTime);
	}

}

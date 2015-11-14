package models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.format.Formats.DateTime;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtil;


import lombok.Getter;
/**
 * abstract model defining common column
 */
@Entity
public abstract class AbstractTrailModel extends Model {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

		@Id @Getter
    public Long id;
    @Required
    @DateTime(pattern="yyyy-MM-dd")
    public Date create_time;
    @ManyToOne
    @Required
    public User createUser;
    @Required
    @DateTime(pattern="yyyy-MM-dd")
    public Date update_time;
    @ManyToOne
    @Required
    public User updateUser;
    @Required
		public Integer is_delete;

  /**
   * 最終更新からの経過時間を取得する。
   * @return 最終更新からの経過時間
   */
  public String getSinceLastUpdate(){
    return DateUtil.howLongFromNow(update_time);
  }
}

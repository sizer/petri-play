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

	public static final int INSERT = 1;
    public static final int UPDATE = 2;
    public static final int DELETE = 3;

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
     * 保存処理
     */
    @Override
    public void save(){
      if(create_time != null){
        setTrailInfo(UPDATE);
        super.save();

      }else{
        setTrailInfo(INSERT);
        super.save();
      }
    }

  /**
   * 最終更新からの経過時間を取得する。
   * @return 最終更新からの経過時間
   */
  public String getSinceLastUpdate(){
    return DateUtil.howLongFromNow(update_time);
  }

  /**
   * <pre>
   * 追跡情報をセットする。
   * 設定されるカラム...create_time/create_user_id.update_time/update_user_id
   * </pre>
   */
  public void setTrailInfo(int code){

    switch(code) {
      case INSERT:
        create_time = DateUtil.now();
        createUser = User.getLoginUser();
      case UPDATE:
      case DELETE:
        update_time = DateUtil.now();
        updateUser = User.getLoginUser();
    }

    if(code == DELETE){
      is_delete = 1;

    }else{
      is_delete = 0;
    }
  }
}

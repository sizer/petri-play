package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import services.util.DateUtil;

/**
 * abstract model defining common column
 */
@Entity
public abstract class AbstractTrailModel extends Model {

    @Constraints.Required
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date create_time;
    @Constraints.Required
		public Integer create_user_id;
    @Constraints.Required
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date update_time;
    @Constraints.Required
    public Integer update_user_id;
    @Constraints.Required
		public Integer is_delete;

  /**
   * 最終更新からの経過時間を取得する。
   */
  public String getSinceLastUpdate(){
    return DateUtil.getSince(update_time);
  }
}

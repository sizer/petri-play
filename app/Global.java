import play.GlobalSettings;
import play.api.mvc.EssentialFilter;
import play.filters.csrf.CSRFFilter;

public class Global extends GlobalSettings {
  /**
   * CSRFフィルター
   * @param <T>
   * @return
   */
  @Override
  public <T extends EssentialFilter> Class<T>[] filters(){
    return new Class[]{CSRFFilter.class};
  }

}

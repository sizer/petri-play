package mrdshinse.petri.web.bean;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import mrdshinse.petri.web.dto.Team;
import mrdshinse.petri.web.helper.HttpHelper;
import mrdshinse.petri.web.util.JsonUtil;

/**
 * temp class of Jackson verification
 *
 * * @author mrdShinse
 */
@Named(value = "indexBean")
@SessionScoped
public class IndexBean implements Serializable {

    @Getter
    private String result = null;

    @Getter
    private Team resultBean;

    public void sentRequest() throws IllegalStateException, IOException {
        String r = new HttpHelper("http://localhost:9000/team").executeGet().getStringResponse();
        result = r;
        resultBean = JsonUtil.transformToBean(r, Team.class);
    }
}

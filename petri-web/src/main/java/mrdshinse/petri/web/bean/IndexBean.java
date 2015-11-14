package mrdshinse.petri.web.bean;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import mrdshinse.petri.web.helper.HttpHelper;

/**
 *
 * * @author mrdShinse
 */
@Named(value = "indexBean")
@SessionScoped
public class IndexBean implements Serializable {

    @Getter
    private String result = null;

    public void sentRequest() throws IllegalStateException, IOException {
        String r = new HttpHelper("http://localhost:9000/team").executeGet().getStringResponse();
        result = r;
    }
}

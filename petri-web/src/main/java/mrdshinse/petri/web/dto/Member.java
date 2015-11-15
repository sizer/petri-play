package mrdshinse.petri.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * temp class of Jackson verification
 *
 * @author mrdShinse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @JsonProperty("m_name")
    public String memberName;
    public int age;

}

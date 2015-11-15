package mrdshinse.petri.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class Team {

    private int id;
    @JsonProperty("team_name")
    private String teamName;
    private List<Member> members;
}

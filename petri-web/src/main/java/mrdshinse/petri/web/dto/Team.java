package mrdshinse.petri.web.dto;

import java.util.List;

/**
 *
 * @author mrdShinse
 */
public class Team {

    public Team() {
    }

    public Team(int id, String teamName, List<Member> members) {
        this.id = id;
        this.teamName = teamName;
        this.members = members;
    }

    public int id;

    public String teamName;

    public List<Member> members;
}

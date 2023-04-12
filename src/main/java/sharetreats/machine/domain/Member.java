package sharetreats.machine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue
    @Column(name= "member_id")
    private Long id;

    private String name;

    private int cash;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Draw> draws = new ArrayList<>();

}

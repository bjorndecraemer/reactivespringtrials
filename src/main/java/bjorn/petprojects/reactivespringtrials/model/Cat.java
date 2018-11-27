package bjorn.petprojects.reactivespringtrials.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String name;
    private String type;

    public String describeMe(){
        return "I am "+name+", a "+type+" cat!";
    }
}

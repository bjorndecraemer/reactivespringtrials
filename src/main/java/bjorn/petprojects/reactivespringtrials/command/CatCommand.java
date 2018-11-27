package bjorn.petprojects.reactivespringtrials.command;

import bjorn.petprojects.reactivespringtrials.model.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatCommand {

    private String name;
    private String type;

    public CatCommand(Cat cat){
        this.name = cat.getName();
        this.type = cat.getType();
    }

    public String describeMe(){
        return "I am "+name+", a "+type+" cat!";
    }
}

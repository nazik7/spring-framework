package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
//@Data

public class DataStructure {
    //@NonNull
    ExtraHours extraHours;


    public void getTotalHours(){
        System.out.println("DataStructure Total Hours: "+ (20 + extraHours.getHours()));
    }
}

package dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Msg extends ResponseType{
    String msg;

    public String getMessage() {
        return this.msg;
    }

}

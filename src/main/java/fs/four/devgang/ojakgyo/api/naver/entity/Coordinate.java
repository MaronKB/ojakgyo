package fs.four.devgang.ojakgyo.api.naver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {
    private String x;
    private String y;

    public String toString() {
        return x + "," + y;
    }
    public String toJSONString() {
        return "{\"x\":\"" + x + "\",\"y\":\"" + y + "\"}";
    }
}

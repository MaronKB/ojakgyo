package fs.four.devgang.ojakgyo.api.local.entity;

import jakarta.persistence.Entity;
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
        return "Coordinate(x=" + x + ", y=" + y + ")";
    }
    public String toJSONString() {
        return "{\"x\":\"" + x + "\",\"y\":\"" + y + "\"}";
    }
}

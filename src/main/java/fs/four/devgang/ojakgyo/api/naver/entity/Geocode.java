package fs.four.devgang.ojakgyo.api.naver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Geocode {
    private String x;
    private String y;
    private String city_do;
    private String gu_gun;

    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"x\":\"");
        sb.append(x);
        sb.append("\",\"y\":\"");
        sb.append(y);
        sb.append("\",\"city_do\":\"");
        sb.append(city_do);
        sb.append("\",\"gu_gun\":\"");
        sb.append(gu_gun);
        sb.append("\"}");
        return sb.toString();
    }

    public String getAddress() {
        return city_do + " " + gu_gun;
    }
}

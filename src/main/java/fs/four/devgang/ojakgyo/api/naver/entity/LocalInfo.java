package fs.four.devgang.ojakgyo.api.naver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalInfo {
    private String title;
    private String link;
    private String category;
    private String description;
    private String telephone;
    private String address;
    private String roadAddress;
    private String mapx;
    private String mapy;

    public String toString() {
        return "Local(title=" + title + ", link=" + link + ", category=" + category + ", description=" + description + ", telephone=" + telephone + ", address=" + address + ", roadAddress=" + roadAddress + ", mapx=" + mapx + ", mapy=" + mapy + ")";
    }
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"title\":\"").append(title).append("\",");
        sb.append("\"link\":\"").append(link).append("\",");
        sb.append("\"category\":\"").append(category).append("\",");
        sb.append("\"description\":\"").append(description).append("\",");
        sb.append("\"telephone\":\"").append(telephone).append("\",");
        sb.append("\"address\":\"").append(address).append("\",");
        sb.append("\"roadAddress\":\"").append(roadAddress).append("\",");
        sb.append("\"mapx\":\"").append(mapx).append("\",");
        sb.append("\"mapy\":\"").append(mapy).append("\"");
        sb.append("}");
        return sb.toString();
    }
}

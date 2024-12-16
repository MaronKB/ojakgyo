package fs.four.devgang.ojakgyo.ad.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Getter
@Setter
@Component("adVO")
public class AdVO {
    private int adv_id;
    private String adv_title;
    private String adv_category;
    private String adv_desc;
    private String adv_image_name;
    private String adv_image_path;
    private String adv_link;
    private Timestamp adv_reg_date;
    private String adv_reg_by;
    private Timestamp adv_mod_date;
    private String adv_mod_by;
    private Timestamp adv_exp_date;
    private char adv_is_valid;
}

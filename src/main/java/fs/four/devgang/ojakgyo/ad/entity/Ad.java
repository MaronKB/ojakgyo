package fs.four.devgang.ojakgyo.ad.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Ad {
    private int adv_id;
    private String adv_title;
    private String adv_category;
    private String adv_exp_date;
    private String adv_is_valid;
}

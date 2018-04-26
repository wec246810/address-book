package com.ysk.addressbook.util;

import lombok.Data;
import me.ghui.fruit.annotations.Pick;

/**
 * Author: Y.S.K
 * Date:2018/4/22
 */
@Data
public class ZitiPage {

    @Pick(value = "#imgResult",attr = "src")
    private String imgResult;
}

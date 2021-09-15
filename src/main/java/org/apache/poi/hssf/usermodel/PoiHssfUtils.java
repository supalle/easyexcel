package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * utils
 *
 * @author Jiaju Zhuang
 */
public class PoiHssfUtils {

    /**
     * Whether to customize the height
     */
    public static final BitField CUSTOM_HEIGHT = BitFieldFactory.getInstance(0x640);

    /**
     * Whether to customize the height
     *
     * @param row
     * @return
     */
    public static boolean customHeight(Row row) {
        if (row instanceof XSSFRow) {
            XSSFRow xssfRow = (XSSFRow)row;
            return xssfRow.getCTRow().getCustomHeight();
        }
        if (row instanceof HSSFRow) {
            HSSFRow hssfRow = (HSSFRow)row;
            return CUSTOM_HEIGHT.getValue(hssfRow.getRowRecord().getOptionFlags()) == 1;
        }
        return false;
    }
}

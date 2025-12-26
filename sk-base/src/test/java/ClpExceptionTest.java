import com.exception.ClpExceptionUtils;
import com.exception.impl.ClpDbErrorMsg;
import com.exception.impl.ClpParamErrorMsg;

import java.util.PrimitiveIterator;

/**
 * @Author: sukang
 * @Date: 2023/4/17 17:49
 * @Description:
 */
public class ClpExceptionTest {


    public static void main(String[] args) {

        String userId = null;
        try {
            ClpExceptionUtils.assertBoolSupplier(() -> userId == null, ClpParamErrorMsg.PARAM_ERROR, "userId",userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int line = 0;

        try {
            ClpExceptionUtils.assertBoolSupplier(() -> line != 1, ClpDbErrorMsg.DB_EFFECT_LINE_ERROR, line ,1);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}

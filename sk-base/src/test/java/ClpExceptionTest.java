import com.exception.ClpExceptionUtils;
import com.exception.impl.ClpParamErrorMsg;

/**
 * @Author: sukang
 * @Date: 2023/4/17 17:49
 * @Description:
 */
public class ClpExceptionTest {


    public static void main(String[] args) {
        try {
            assertParam(null);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }



    public static void assertParam(String id){
        ClpExceptionUtils.assertParam(() -> id == null, ClpParamErrorMsg.PARAM_ERROR, "id");
    }
}

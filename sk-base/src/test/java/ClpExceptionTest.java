import com.exception.ClpException;

/**
 * @Author: sukang
 * @Date: 2023/4/17 17:49
 * @Description:
 */
public class ClpExceptionTest {


    public static void main(String[] args) {

        try {
            throw new ClpException("errorMessage", "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

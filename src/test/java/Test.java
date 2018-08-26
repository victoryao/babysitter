import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.test.context.TestExecutionListeners;

/**
 * Created by yaoqiang on 2018/7/1.
 */
public class Test {


    public static void main(String[] args) {

         int appId = 1400105911;

         String appKey = "a07263a2ba31a93bc139669fc1de249e";

         String smsTemplate = "您的验证码是%s。30分钟内有效，请在页面中提交验证码完成验证。";

        SmsSingleSenderResult result = null;
        SmsSingleSender sender = new SmsSingleSender(appId, appKey);
        try {
            result = sender.send(0, "86", "15811194218",
                    String.format(smsTemplate, 1234), "", "");
            System.out.println("result : " + result);
        } catch (Exception e) {
//            log.error("tencent send message error:{}", e);
        }

        System.out.println("ok");
    }
}

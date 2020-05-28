import com.loven.myshop.plus.admin.login.log.service.AdminLogServiceApp;
import com.loven.myshop.plus.admin.login.log.service.api.AdminLogService;
import com.loven.myshop.plus.admin.login.log.service.domain.UmsAdminLoginLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminLogServiceApp.class)
public class TestAdminLoginService {
    @Resource
    AdminLogService adminLogService;

    @Test
    public void testSelectByAdminId(){
        List<UmsAdminLoginLog> list = adminLogService.selectByAdminId(3L);
        list.forEach(System.out::println);
    }
}

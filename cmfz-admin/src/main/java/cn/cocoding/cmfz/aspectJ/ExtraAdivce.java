package cn.cocoding.cmfz.aspectJ;
import cn.cocoding.cmfz.entity.Log;
import cn.cocoding.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
/**
 * 额外功能 @Aspect注解声明这是一个额外功能类
 * Created by huzi on 2018/7/9.
 */
@Aspect
public class ExtraAdivce {
    @Autowired
    private HttpSession session;
    @Autowired
    private LogService logService;
    //创建系统日志实体类
    private Log sysLog;
    //声明切点
    @Pointcut("execution(* cn.cocoding.cmfz.serviceImpl.*.insert*(..)) || execution(* cn.cocoding.cmfz.serviceImpl.*.update*(..)) || execution(* cn.cocoding.cmfz.serviceImpl.*.delete*(..))")
    public void pc() {
    }
    //在切点处添加环绕通知
    @Around("pc()")
    public Object addLogs(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        sysLog = new Log();
        //获取并设置当前用户名
        String logUser = (String) session.getAttribute("managerName");
        sysLog.setLogUser(logUser);
        //获取并设置操作的时间
        Date logTime = new Date();
        sysLog.setLogTime(logTime);
        //获取并设置操作的资源message
        //获取参数
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length != 0 && args[0] != null) {
            sysLog.setLogMessage(args[0].toString());
        }else {
            sysLog.setLogResource("蜜汁错误!");
        }
        //获取并设置操作的类型
        //获取方法名
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String simpleName = methodSignature.getDeclaringType().getSimpleName();
        sysLog.setLogResource(simpleName.replace("Service",""));
        //设置action
        Method method = methodSignature.getMethod();

        if(method.getName().contains("insert")){
            sysLog.setLogAction("新增");
        }
        if(method.getName().contains("update")){
            sysLog.setLogAction("修改");
        }
        if(method.getName().contains("delete")){
            sysLog.setLogAction("删除");
        }
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            sysLog.setLogResult("success");
        } catch (Throwable throwable) {
            sysLog.setLogResult("fail");
            throwable.printStackTrace();
        }
        logService.modifyInsertSelective(sysLog);
        return proceed;
    }


}

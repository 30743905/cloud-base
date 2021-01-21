import org.junit.Test;
import org.simon.config.service.ChangeListenerService;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import cn.com.yusys.yusp.commons.config.core.ChangeEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @since 2020-08-24 9:41
 */
@Slf4j
public class AnnotationUtilsTest {

    @Test
    public void test01(){
        boolean ret = AnnotationUtils.isCandidateClass(TestService01.class, Component.class);


        AnnotationUtils.getAnnotation(TestService01.class, Component.class);

        log.info("ret:{}", ret);
    }

    @Test
    public void test02() throws NoSuchMethodException {

        Method method = ChangeListenerService.class.getDeclaredMethod("configChange", ChangeEvent.class);
        MergedAnnotations annotations = MergedAnnotations.from(method);
        annotations.isPresent(Component.class);
        AnnotationAttributes attributes = annotations.get(Component.class).asAnnotationAttributes();


        AnnotatedElementUtils.isAnnotated(TestService01.class, Component.class);
    }
}
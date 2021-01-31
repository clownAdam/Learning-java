package cn.clown.new8.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author clown
 */
public class OptionTest {
    @Test
    public void test(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);

    }
}

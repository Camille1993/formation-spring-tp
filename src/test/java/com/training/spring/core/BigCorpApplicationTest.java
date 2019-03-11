package com.training.spring.core;

import com.training.spring.core.utils.OutputCapture;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

public class BigCorpApplicationTest {

    @Rule
    public OutputCapture output = new OutputCapture();

    private BigCorpApplication application = new BigCorpApplication();

    @Test
    public void run() {
        application.run();
        assertThat(output.toString(), containsString("============================================================="));
        assertThat(output.toString(), containsString("Application ["));
    }
}

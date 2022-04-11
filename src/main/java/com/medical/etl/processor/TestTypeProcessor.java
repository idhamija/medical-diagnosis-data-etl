package com.medical.etl.processor;

import com.medical.etl.model.TestType;
import org.springframework.batch.item.ItemProcessor;

public class TestTypeProcessor implements ItemProcessor<TestType, TestType> {

    @Override
    public TestType process(TestType testType) {
        final String name = testType.getName().toLowerCase();

        return new TestType(testType.getId(), name, testType.getMinValue(), testType.getMaxValue(), testType.getUnit());
    }

}

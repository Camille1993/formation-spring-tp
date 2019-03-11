package com.training.spring.core.service.measure;

import com.training.spring.core.model.Captor;
import com.training.spring.core.model.Measure;
import com.training.spring.core.model.MeasureStep;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RealMeasureService implements MeasureService{

    @Value("${bigcorp.measure.default-real}")
    private Integer valueInWatt;
    @Override
    public List<Measure> readMeasures(Captor captor, Instant start, Instant end,
                                      MeasureStep step) {
       checkReadMeasuresAgrs(captor, start, end, step);
        List<Measure> measures = new ArrayList<>();
        Instant current = start;
        while(current.isBefore(end)){
            measures.add(new Measure(current, valueInWatt, captor));
            current = current.plusSeconds(step.getDurationInSeconds());
        }
        return measures;
    }
}

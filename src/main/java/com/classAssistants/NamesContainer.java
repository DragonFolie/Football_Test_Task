package com.classAssistants;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
public class NamesContainer {

    private String oldName;
    private String newName;

    public NamesContainer(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

}

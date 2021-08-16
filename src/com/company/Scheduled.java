package com.company;

import java.time.LocalDateTime;

public interface Scheduled {

    boolean isDue(LocalDateTime now);

    void dismiss();

}

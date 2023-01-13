package com.company;

import com.company.domain.Status;
import com.company.service.StatusService;
import com.company.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        StatusService.setCurrentStatus(Status.MAIN);
        while(true) {
            if (StatusService.getCurrent() == Status.MAIN) {
                ui.mainUI();
            }
            else if (StatusService.getCurrent() == Status.REGISTER) {
                ui.registerUI();
            }
            else if (StatusService.getCurrent() == Status.DELETE) {
                ui.deleteUI();
            }
            else if (StatusService.getCurrent() == Status.FIND) {
                ui.findUI();
            }
            else if (StatusService.getCurrent() == Status.LIST) {
                ui.listUI();
            }
            else if (StatusService.getCurrent() == Status.END) {
                ui.eopUI();
                break;
            }
        }
    }
}

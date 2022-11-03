package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    final private String FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    @Autowired
    private RecoveryRoomService recoveryRoomService;

    @GetMapping(value = "/create")
    public String initCreationForm(ModelMap model) {
        RecoveryRoom recoveryRoom = new RecoveryRoom();
        model.put("recoveryRoom", recoveryRoom);
        return FORM;
    }

    @PostMapping(value = "/create")
    public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("recoveryRoom", recoveryRoom);
            return FORM;
        } else {
            try {
                this.recoveryRoomService.save(recoveryRoom);
                return "welcome";
            } catch (Exception e) {

            }
            return FORM;


        }
    }
}

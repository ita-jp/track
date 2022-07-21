package com.pocotech.track.controller.ticket;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TicketForm {

    @NotBlank
    @Size(max=256)
    private String summary;

    @NotBlank
    @Size(max=256)
    private String description;

}

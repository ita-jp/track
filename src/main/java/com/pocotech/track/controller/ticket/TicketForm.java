package com.pocotech.track.controller.ticket;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TicketForm {

    @NotNull
    private long type; // TODO enum

    @NotBlank
    @Size(max = 256)
    private String summary;

    @Size(max = 256)
    private String description;

}

package com.ata.apiBanda.models.bandaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocalPhoneDTO {

    private String number;
    private List<Long> customerIds;
}

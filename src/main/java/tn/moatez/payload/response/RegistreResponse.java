package tn.moatez.payload.response;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class RegistreResponse {
    private String message;

    public RegistreResponse(String message) {
    this.message=message;
    }
}
